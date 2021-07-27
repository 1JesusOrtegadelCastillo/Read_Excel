package com.example.ReadFromExcel.repository;

import com.example.ReadFromExcel.entity.ExcelFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelFileRepository extends JpaRepository<ExcelFile, Integer> {
    @Query(value = "SELECT AVG(calificacion) FROM ExcelFile")
    public Double avg();
}
