```
Technologies:
Spring Boot
Thymeleaf
H2 database
JPA
Bootstrap
Apache POI
Google Charts


__Project Structure

root
|
├──src
|  └── main
|      ├── java
|      |   └── com
|      |       └── example
|      |           └── ReadFromExcel
|      |               ├── ReadFromExcelApplication
|      |               ├── entity
|      |               |   └── ExcelFile.java
|      |               ├── controller
|      |               |   └── ExcelFileController.java
|      |               ├── service
|      |               |   ├── ExcelFileService.java
|      |               |   └── ExcelFileServiceImplementation.java
|      |               └── repository
|      |                   └── ExcelFileRepository.java
|      └── resources
|          ├── static
|          ├── templates
|          |   ├── excelfile.html <-- read comments because sometimes it has an error due to the files
|          |   ├── google-charts.html
|          |   
|          └── application.yml
└── pom.xml    
```
