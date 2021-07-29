package com.example.ReadFromExcel.controller;

import com.example.ReadFromExcel.entity.ExcelFile;
import com.example.ReadFromExcel.service.ExcelFileService;
import org.apache.poi.ss.usermodel.Row;
import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
public class ExcelFileController {

    @Autowired
    private ExcelFileService excelFileService;

    @GetMapping(value = "/")
    public String home (Model model){
        model.addAttribute("excelFile", new ExcelFile());
        List<ExcelFile> excelFiles = excelFileService.findAll();
        model.addAttribute("excelFiles", excelFiles);

        return "excelfile";
    }

    @PostMapping("/fileUpload")
    public String uploadFile(@ModelAttribute ExcelFile excelFile, RedirectAttributes redirectAttributes){
        boolean isFlag = excelFileService.saveDataFromUploadFile(excelFile.getFile());
        if (isFlag){
            redirectAttributes.addFlashAttribute("successmessage", "File uploaded successfully");
        } else {
            redirectAttributes.addFlashAttribute("errormessage", "File error");
        }
        return "redirect:/";
    }

    @GetMapping("/avg")
    public String getAvg(Model model){
        double avgResult = excelFileService.avg();
        model.addAttribute("promedio", avgResult);
        return "avg";
    }


}
