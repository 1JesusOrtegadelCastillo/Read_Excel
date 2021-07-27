package com.example.ReadFromExcel.service;

import com.example.ReadFromExcel.entity.ExcelFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExcelFileService {
    List<ExcelFile> findAll();
    boolean saveDataFromUploadFile(MultipartFile file);
    public Double avg();
}
