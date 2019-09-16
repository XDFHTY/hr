package com.cj.common.controller;

import com.cj.common.service.FileService;
import com.cj.core.aop.Log;
import com.cj.core.domain.ApiResult;
import com.cj.core.domain.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/common/api/v1/file")
@Api(tags = "公共接口: 文件上传")
public class FileController {

    @Resource
    private FileService fileService;

    @PostMapping(value = "/upload")
    @ApiOperation("单文件上传，字节流，不压缩")
    @Log(name = "文件服务", value = "单文件上传，字节流，不压缩")
    public ApiResult upload(HttpServletRequest request,
                            @ApiParam(name = "multipartFile", value = "文件字节流", required = true)
                                    MultipartFile multipartFile) throws Exception {

        return ResultUtil.result(fileService.saveFile(request,multipartFile));
    }
    @PostMapping(value = "/uploads")
    public ApiResult uploads(MultipartFile[] files,HttpServletRequest request) throws Exception {

        List<String> fileUrls = new ArrayList<>();
        for (MultipartFile multipartFile : files){
            fileUrls.add(fileService.saveFile(request,multipartFile));
        }
        return ResultUtil.result(fileUrls);
    }

}
