package com.cj.common.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface FileService {


    public String saveFile(HttpServletRequest request, MultipartFile multipartFile);
}
