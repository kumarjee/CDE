package com.infosys.internal.cde.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.infosys.internal.cde.model.Questions;

public class ExcelUtil {
	
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException 
	{
	        File convFile = new File( multipart.getOriginalFilename());
	        multipart.transferTo(convFile);
	        return convFile;
	}
	
	public XSSFWorkbook generateWorkbookTemplate(){
		
		//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Question Template");
        
        Row header = sheet.createRow(0);
        
        header.createCell(0).setCellValue("Question");
        header.createCell(1).setCellValue("Option1");
        header.createCell(2).setCellValue("Option2");
        header.createCell(3).setCellValue("Option3");
        header.createCell(4).setCellValue("Option4");
        header.createCell(5).setCellValue("Correct Answer");
        
        return workbook;
		
	}
	
	public void parseworkBook(File file){
        try {
            
            FileInputStream fileIS = new FileInputStream(file);
             
            //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook(fileIS);
 
            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
             
            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            List<Questions> questionList = new ArrayList<Questions>();
            rowIterator.next();
            while(rowIterator.hasNext()) {
            	
                Row row = rowIterator.next();
                Questions questions = new Questions();
                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext()) {
                     
                   questions.setQuestion(cellIterator.next().getStringCellValue());
                   //questions.set
                   
                
                }
                System.out.println("");
            }
            fileIS.close();          
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	private static String GetFileExtension(String fname2)
	  {
	      String fileName = fname2;
	      String fname="";
	      String ext="";
	      int mid= fileName.lastIndexOf(".");
	      fname=fileName.substring(0,mid);
	      ext=fileName.substring(mid+1,fileName.length());
	      return ext;
	  }

}
