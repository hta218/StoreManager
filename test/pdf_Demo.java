/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Huynh
 */
import java.io.FileOutputStream;
//import java.io.*;
//import java.util.*;
//import java.sql.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class pdf_Demo {

    public static void main(String[] args) throws Exception {

//        Create Connection objects 
//        Class.forName("oracle.jdbc.OracleDriver");
//        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "hr", "hr");
//        Statement stmt = conn.createStatement();
        /* Define the SQL query */
//        ResultSet query_set = stmt.executeQuery("SELECT DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID FROM DEPARTMENTS");
        /* Step-2: Initialize PDF documents - logical objects */
        
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("F:\\report.pdf"));
        my_pdf_report.open();
        // we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(4);
        // create a cell object
        PdfPCell table_cell;

            String dept_id = "ID";
            table_cell = new PdfPCell(new Phrase(dept_id));
            my_report_table.addCell(table_cell);

            String dept_name = "Name";
            table_cell = new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
        /* Attach report table to PDF */
        
        my_pdf_report.add(my_report_table);
//        my_pdf_report.close();

        /* Close all DB related objects */
//        query_set.close();
//        stmt.close();
//        conn.close();
    }
}
