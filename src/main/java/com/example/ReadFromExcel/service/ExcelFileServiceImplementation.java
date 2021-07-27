package com.example.ReadFromExcel.service;

import com.example.ReadFromExcel.entity.ExcelFile;
import com.example.ReadFromExcel.repository.ExcelFileRepository;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Iterator;
import java.util.List;

@Service
public class ExcelFileServiceImplementation implements ExcelFileService {

    @Autowired
    private ExcelFileRepository excelFileRepository;

    @Override
    public List<ExcelFile> findAll() {
        return (List<ExcelFile>) excelFileRepository.findAll(Sort.by(Sort.Direction.DESC, "calificacion"));
    }

    @Override
    public boolean saveDataFromUploadFile(MultipartFile file) {
        boolean isFlag = false;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());

        if (extension.equalsIgnoreCase("xls") || extension.equalsIgnoreCase("xlsx")) {
            isFlag = readDataFromExcel(file);
        }
        return isFlag;
    }

    private boolean readDataFromExcel(MultipartFile file) {
        Workbook workbook = getWorkBook(file);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();
        rows.next();
        while (rows.hasNext()){
            Row row = rows.next();
            ExcelFile excelFile = new ExcelFile();
         if (row.getCell(0).getCellType() == CellType.STRING){
             excelFile.setNombres(row.getCell(0).getStringCellValue());
         }
         if (row.getCell(1).getCellType() == CellType.STRING){
                excelFile.setApellidoPaterno(row.getCell(1).getStringCellValue());
         }
         if (row.getCell(2).getCellType() == CellType.STRING){
                excelFile.setApellidoMaterno(row.getCell(2).getStringCellValue());
         }
         if (row.getCell(3).getCellType() == CellType.STRING){
                excelFile.setFechaDeNacimiento(row.getCell(3).getStringCellValue());
         }
         if (row.getCell(4).getCellType() == CellType.NUMERIC){
                excelFile.setGrado((int) row.getCell(4).getNumericCellValue());
         }
         if (row.getCell(5).getCellType() == CellType.STRING){
                excelFile.setGrupo(row.getCell(5).getStringCellValue());
         }
         if (row.getCell(6).getCellType() == CellType.NUMERIC){
                excelFile.setCalificacion((int) row.getCell(6).getNumericCellValue());
         }
         excelFile.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
         excelFileRepository.save(excelFile);

        }
        return true;
    }

    private Workbook getWorkBook(MultipartFile file) {
        Workbook workbook = null;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        try {
            if (extension.equalsIgnoreCase("xlsx")){
                workbook = new XSSFWorkbook(file.getInputStream());
            } else if (extension.equalsIgnoreCase("xls")){
                workbook = new HSSFWorkbook(file.getInputStream());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return workbook;
    }

    @Override
    public Double avg() {
        return excelFileRepository.avg();
    }


}
