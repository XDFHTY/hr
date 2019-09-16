package com.cj.core.aop;

import com.cj.core.domain.ApiResult;
import com.cj.core.entity.OperateLog;
import com.cj.core.service.LogService;
import com.cj.core.utils.IpUtil;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@SuppressWarnings("ALL")
@Component
@Aspect
@Slf4j
public class ControllerAop {


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    Gson gson = new Gson();

    @Resource
    private LogService logService;

    //匹配com.cj.tangtuan.controller包及其子包下的所有类的所有方法
    @Pointcut("execution(* com.cj.*.controller.*..*(..))")
    public void executeService() {
    }


    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("收到请求：Around ====================================================");

        long start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        OperateLog operateLog = new OperateLog();


        try {
            Object result = joinPoint.proceed();
            if (result == null) {
                //如果切到了 没有返回类型的void方法，这里直接返回
                return null;
            }

            if (attributes == null) {
                return result;
            }
            StringBuffer Url = request.getRequestURL();
            if (Url.indexOf("/api/") == -1 || Url.indexOf("/ws") != -1) {
                return result;
            }
            String name = (String) session.getAttribute("name");
            if (name == null || name.length() < 1) {
                return result;
            }

            //获取IP
            String ip = IpUtil.getIpAddr(request);


            Object[] args = joinPoint.getArgs();// 参数
            int argsSize = args.length;
            String argsTypes = "";

            String typeStr = joinPoint.getSignature().getDeclaringType().toString().split(" ")[0];
            String returnType = joinPoint.getSignature().toString().split(" ")[0];


            // 记录下请求内容
            log.info("请求 URL : " + request.getRequestURL().toString());
            log.info("IP  地址 : " + ip);
            log.info("请求方式 : " + request.getMethod());
            log.info("请求时间 : " + sdf.format(start));
            log.info("请求用户 : " + name);
            log.info("请求端口 : " + session.getAttribute("client").toString());

            log.info("参数个数 :" + argsSize);

            if (argsSize > 0) {
                // 拿到参数的类型
                for (Object object : args) {
                    if (object != null) {
                        argsTypes += object.getClass().getTypeName().toString() + ", ";
                    }
                }
                log.info("参数类型 :" + argsTypes);
            }
            log.info("执行方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
            log.info("执行参数 : " + Arrays.toString(joinPoint.getArgs()));

//            log.info("返回类型 :" + returnType);

//            //获取所有参数方法一：
//            Enumeration<String> enu=request.getParameterNames();
//            while(enu.hasMoreElements()){
//                String paraName=(String)enu.nextElement();
//                System.out.println("======================"+paraName);
//            }



            String description = getControllerMethodDescription(joinPoint);
            log.info("执    行 : " + description);
            operateLog.setOperateId((Long) session.getAttribute("id"));
            operateLog.setClient(session.getAttribute("client").toString());
            operateLog.setLogName(description.substring(0,description.indexOf(" ==> ")));
            operateLog.setLogValue(description.substring(description.indexOf(">")+2));


            long end = System.currentTimeMillis();
            Long total = end - start;
            // 处理完请求，返回内容
            if ("ApiResult".equals(returnType)) {
                ApiResult apiResult = (ApiResult) result;
                log.info("执行结果 : " + apiResult.getMsg());
                operateLog.setLogState(apiResult.getMsg());
//                log.info("返回数据 : " + gson.toJson(apiResult.getData()));
//                apiResult.setParams("耗时："+total+"ms");
//                result = ObjectUtil.mapToObject(apiResult.toMap(), ApiResult.class);
            }

            new Thread(()->{
                logService.addLog(operateLog);
            }).start();



            log.info("Aop耗时  : " + total + " ms!");
//            log.info("执行完成 :==========================================================================================");


            return result;

        } catch (Throwable e) {
            long end = System.currentTimeMillis();
            log.info("====around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
                    + e.getMessage());
            throw e;
        }

    }

    @Before("executeService()")
    public void doBefore(JoinPoint joinPoint) {

    }

    @AfterReturning(value = "executeService()", returning = "obj")
    public void doAfterReturning(JoinPoint joinPoint, Object obj) {


    }

    // 通过反射获取参入的参数
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        String name = "";
        String value = "";

        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();

                if (clazzs.length == arguments.length) {
                    if (method.getAnnotation(Log.class) != null) {
                        name = method.getAnnotation(Log.class).name();
                        value = method.getAnnotation(Log.class).value();
                    }
                    break;
                }
            }
        }
        return name + " ==> " + value;
    }


}
