package com.cj.common.service.impl;

import com.cj.common.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${web.path}")
    String path;


    String prifix = "file/";

    @Override
    public String saveFile(HttpServletRequest request, MultipartFile multipartFile) {
        String fileUrl = "";  //地址

        String bet = "";

        String contentType = multipartFile.getContentType();   //文件类型
        String fileName = multipartFile.getOriginalFilename();  //文件名字
        //获取后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        bet = suffix.substring(1)+"/";

        System.out.println("=======文件类型" + contentType);
        System.out.println("=======文件名字" + fileName);
        fileName = UUID.randomUUID().toString().replace("-","").toUpperCase() + suffix;

        //文件存放路径
        String filePath = path + prifix +bet;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            multipartFile.transferTo(new File(filePath+fileName));
//            FileUtil.uploadFile(multipartFile.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
            log.info("保存图片异常");
        }
        String url = null;
        url = request.getHeader("url");
        if (url != null){
            String uri = request.getRequestURI();
            url = url.replace(uri,"/");

        }else if (url == null) {
            url = request.getRequestURL().toString();
            String uri = request.getRequestURI();
            url = url.replace(uri,"/");
        }
        //图片的访问路径
        fileUrl = url   + prifix + bet+fileName;
        System.out.println("文件在系统中的完整访问路径===>>" + fileUrl);
        return fileUrl;
    }
}
