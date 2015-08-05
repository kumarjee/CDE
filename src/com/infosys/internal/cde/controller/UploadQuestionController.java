package com.infosys.internal.cde.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.poi.POIXMLException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.infosys.internal.cde.model.Questions;
import com.infosys.internal.cde.service.CertificationService;
import com.infosys.internal.cde.utils.ExcelUtil;
import com.infosys.internal.cde.validators.AddQuestionForm;
import com.infosys.internal.cde.validators.UploadQuestionForm;

@Controller
@RequestMapping("/admin/uploadquestion")
public class UploadQuestionController {
	
	@Autowired
	private CertificationService certificationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showUploadQuestion(Map model, HttpSession session) {	
		
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminlogin.html");
		}
		
		String pageHeading = "Upload Questions";
		
		UploadQuestionForm uploadQuestionForm = new UploadQuestionForm();
		
		model.put("pageHeading", pageHeading);
		model.put("uploadQuestionForm", uploadQuestionForm);
		model.put("certificationlist", certificationService.listCertifications());
		
		return new ModelAndView("/admin/uploadquestion");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processQuestionController(
			@Valid UploadQuestionForm uploadQuestionForm, BindingResult result,
			Map model, HttpSession session) {
		
		if ((session.getAttribute("adminEmail")) == null) {
			return new ModelAndView("redirect:adminlogin.html");
		}
		
		if(uploadQuestionForm != null){			
			MultipartFile multipart = uploadQuestionForm.getFile();			
			ExcelUtil excelUtil = new ExcelUtil();
			try {
				File file = excelUtil.multipartToFile(multipart);
				
				FileInputStream fileIS = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(fileIS);
	            XSSFSheet sheet = workbook.getSheetAt(0);
	            
	            Iterator<Row> rowIterator = sheet.iterator();
	            List<Questions> questionList = new ArrayList<Questions>();
	            //rowIterator.next();
	            
	            while(rowIterator.hasNext()) {	
	            	Questions questions = new Questions();
	                Row row = rowIterator.next();	
	                for(int i = 0; i < 5; i++){
	                	if(row.getCell(i) == null){
	                		System.out.println("Invalid Template Data. Check for the unfilled cells in the excel sheet.");
	                		return null;
	                	}
	                }
	                questions.setCertificationId(uploadQuestionForm.getCertificationId());
	               	questions.setQuestion(row.getCell(0).toString());
	               	questions.setRightOption((long)row.getCell(4).getNumericCellValue());
	               	
	                }
	            }
	            
	            
			catch(POIXMLException poixmlException){
				String exceptionMsg = poixmlException.getMessage();				
				System.out.println(exceptionMsg.substring(exceptionMsg.indexOf(':')+2));				
			}catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
					
		}
		
		return null;
		
		
	}
}
