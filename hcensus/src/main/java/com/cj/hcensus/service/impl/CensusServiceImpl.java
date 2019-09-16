package com.cj.hcensus.service.impl;

import com.cj.core.exception.MyException;
import com.cj.core.utils.excle.exportExcelUtil;
import com.cj.hcensus.domain.PatCensusModel;
import com.cj.hcensus.domain.RepCensusModel;
import com.cj.hcensus.domain.StaCensusModel;
import com.cj.hcensus.domain.WorCensusModel;
import com.cj.hcensus.mapper.PTPCensusMapper;
import com.cj.hcensus.mapper.RRCensusMapper;
import com.cj.hcensus.mapper.SCensusMapper;
import com.cj.hcensus.service.CensusService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author： 刘磊
 * @Description: 统计管理业务实现层
 * @date： 2019/5/23 9:14
 **/
@Service
@Transactional
public class CensusServiceImpl implements CensusService {

    @Autowired
    private SCensusMapper sCensusMapper;
    @Autowired
    private RRCensusMapper rrCensusMapper;
    @Autowired
    private PTPCensusMapper ptpCensusMapper;

    /**
     * 统计工作情况
     * @param map
     * @return
     */
    @Override
    public List<WorCensusModel> findCensusW(Map map) {
        return sCensusMapper.findCensusW(map);
    }

    /**
     * 统计巡查情况
     * @param map
     * @return
     */
    @Override
    public List<PatCensusModel> findCensusP(Map map) {
        return ptpCensusMapper.findCensusP(map);
    }

    /**
     * 统计维护情况
     * @param map
     * @return
     */
    @Override
    public List<RepCensusModel> findCensusR(Map map) {
        return rrCensusMapper.findCensusR(map);
    }

    /**
     * 统计台站状态
     * @param map
     * @return
     */
    @Override
    public StaCensusModel findCensusS(Map map) {
        return sCensusMapper.findCensusS(map);
    }

    /**
     * 导出统计工作情况
     * @param map
     * @param response
     */
    @Override
    public String importW(Map map, HttpServletResponse response) {
        List<WorCensusModel> list = sCensusMapper.findCensusW(map);
        String fileName="工作情况统计";
        try {
            //设置输出文件地址和名字
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            //获得输出流
            OutputStream out = response.getOutputStream();
            //设置响应头
            response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "; filename*=utf-8''" + fileName);
            response.setCharacterEncoding("UTF-8");
            List<List<String>> result = new ArrayList<>();
            //生成格式是xlsx可存储103万行数据，如果是xls则只能存不到6万行数据
            XSSFWorkbook workbook = new XSSFWorkbook();
            //设置标题栏类容
            String[] headers = {"站点类型","巡查次数","售后处理次数"};
            //设置数据
            if(list!=null){
                for(WorCensusModel wor :list){
                    List<String> rowData = new ArrayList<String>();
                    //设置站点类型
                    rowData.add(wor.getSiteType());
                    //设置巡查次数
                    rowData.add(wor.getPatNum().toString());
                    //设置售后处理次数
                    rowData.add(wor.getStaNum().toString());
                    result.add(rowData);
                }
            }
            exportExcelUtil.exportExcel(workbook, 0, "工作情况统计", headers, result, out);
            //将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException("导出失败");
        }
        return "导出成功";
    }

    /**
     * 导出统计巡查情况
     * @param map
     * @param response
     */
    @Override
    public String importP(Map map, HttpServletResponse response) {
        List<PatCensusModel> list = ptpCensusMapper.findCensusP(map);
        String fileName="巡查情况统计";
        try {
            //设置输出文件地址和名字
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            //获得输出流
            OutputStream out = response.getOutputStream();
            //设置响应头
            response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "; filename*=utf-8''" + fileName);
            response.setCharacterEncoding("UTF-8");
            List<List<String>> result = new ArrayList<>();
            //生成格式是xlsx可存储103万行数据，如果是xls则只能存不到6万行数据
            XSSFWorkbook workbook = new XSSFWorkbook();
            //设置标题栏类容
            String[] headers = {"巡查类型","巡查站点数","巡查次数"};
            //设置数据
            if(list!=null){
                for(PatCensusModel pat :list){
                    List<String> rowData = new ArrayList<String>();
                    //设置巡查类型
                    rowData.add(pat.getTaskType());
                    //设置巡查站点数
                    rowData.add(pat.getStaNum().toString());
                    //设置巡查次数
                    rowData.add(pat.getPatNum().toString());
                    result.add(rowData);
                }
            }
            exportExcelUtil.exportExcel(workbook, 0, "巡查情况统计", headers, result, out);
            //将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException("导出失败");
        }
        return "导出成功";
    }

    /**
     * 导出统计维护情况
     * @param map
     * @param response
     */
    @Override
    public String importR(Map map, HttpServletResponse response) {
        List<RepCensusModel> list = rrCensusMapper.findCensusR(map);
        String fileName="维护情况统计";
        try {
            //设置输出文件地址和名字
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            //获得输出流
            OutputStream out = response.getOutputStream();
            //设置响应头
            response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "; filename*=utf-8''" + fileName);
            response.setCharacterEncoding("UTF-8");
            List<List<String>> result = new ArrayList<>();
            //生成格式是xlsx可存储103万行数据，如果是xls则只能存不到6万行数据
            XSSFWorkbook workbook = new XSSFWorkbook();
            //设置标题栏类容
            String[] headers = {"售后分类","故障设备","处理次数"};
            //设置数据
            if(list!=null){
                for(RepCensusModel rep :list){
                    for(int i=0;i<rep.getList().size();i++) {
                        List<String> rowData = new ArrayList<String>();
                        RepCensusModel rep1 = rep.getList().get(i);
                        //设置售后分类
                        if(i==0){
                            rowData.add(rep.getName());
                        }else{
                            rowData.add("");
                        }
                        //设置故障设备
                        rowData.add(rep1.getName());
                        //设置处理次数
                        rowData.add(rep1.getNum().toString());
                        result.add(rowData);
                    }
                    List<String> row = new ArrayList<String>();
                    //设置售后分类
                    row.add(rep.getName());
                    //设置故障设备
                    row.add("");
                    //设置处理次数
                    row.add(rep.getNum().toString());
                    result.add(row);
                }
            }
            exportExcelUtil.exportExcel(workbook, 0, "维护情况统计", headers, result, out);
            //将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException("导出失败");
        }
        return "导出成功";
    }

    /**
     * 导出统计台站状态
     * @param map
     * @param response
     */
    @Override
    public String importS(Map map, HttpServletResponse response) {
        StaCensusModel censusS = sCensusMapper.findCensusS(map);
        String fileName="台站状态统计";
        try {
            //设置输出文件地址和名字
            fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
            //获得输出流
            OutputStream out = response.getOutputStream();
            //设置响应头
            response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName + "; filename*=utf-8''" + fileName);
            response.setCharacterEncoding("UTF-8");
            List<List<String>> result = new ArrayList<>();
            //生成格式是xlsx可存储103万行数据，如果是xls则只能存不到6万行数据
            XSSFWorkbook workbook = new XSSFWorkbook();
            //设置标题栏类容
            String[] headers = {"正常站点","异常站点","处理中站点"};
            //设置数据
            if(censusS!=null){
                List<String> rowData = new ArrayList<String>();
                //设置正常站点
                rowData.add(censusS.getNor().toString());
                //设置异常站点
                rowData.add(censusS.getAbn().toString());
                //设置处理中站点
                rowData.add(censusS.getInp().toString());
                result.add(rowData);
            }
            exportExcelUtil.exportExcel(workbook, 0, "台站状态统计", headers, result, out);
            //将所有的数据一起写入，然后再关闭输入流。
            workbook.write(out);
            out.flush();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
            throw new MyException("导出失败");
        }
        return "导出成功";
    }
}
