package com.example.ReadFromExcel.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ExcelFile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaDeNacimiento;
    private int grado;
    private String grupo;
    private int calificacion;

    @Transient
    private MultipartFile file;

    public ExcelFile(String nombres, String apellidoPaterno, String apellidoMaterno, String fechaDeNacimiento, int grado, String grupo, int calificacion) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.grado = grado;
        this.grupo = grupo;
        this.calificacion = calificacion;
    }
    public ExcelFile(){}

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }


    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setFileType(String extension) {}

    @Override
    public String toString() {
        return "ExcelFile{" +
                ", La mejor es de: " +
                ", nombres='" + nombres + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", calificacion=" + calificacion +
                '}';
    }
}
