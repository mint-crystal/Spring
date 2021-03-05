package com.mvc.file.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class ReportSubmissionController {
	@RequestMapping(value="report/submission.do", method=RequestMethod.GET)
	public String form() {
		return "report/submissionForm";
	}
	
	@RequestMapping(value="report/submitReport1.do", method=RequestMethod.POST)
	public String submitReport1(@RequestParam("studentNumber")String studentNumber, 
			@RequestParam("report") MultipartFile report) throws Exception{
		
		//파일명을 가져옴
		report.transferTo(new File("E:\\workspace\\servlet-workspace\\springst23\\src\\main\\webapp\\resources\\img\\"
									+report.getOriginalFilename()));
		
		return "report/submissionComplete";
	}
	
	@RequestMapping(value="report/submitReport2.do", method=RequestMethod.POST)
	public String submitReport2(MultipartHttpServletRequest request) throws Exception {
		String studentNumber = request.getParameter("studentNumber");
		MultipartFile report = request.getFile("report");
		
		printInfo(studentNumber,report);
		saveFile(report, request);
		
		return "report/submissionComplete";
	}
	
	@RequestMapping(value="report/submitReport3.do", method=RequestMethod.POST)
	public String submitReport3(Command command, HttpServletRequest request) {
		printInfo(command.getStudentNumber(), command.getReport());
		saveFile(command.getReport(), request);
		
		return "report/submissionComplete";
	}
	
	@RequestMapping(value="report/submitReport4.do", method=RequestMethod.POST)
	public String submitReport4(@RequestParam("studentNumber")String studentNumber, 
			@RequestParam("report") MultipartFile report[], HttpServletRequest request) {
		
		for(MultipartFile mfile : report) {
			printInfo(studentNumber, mfile);
			saveFile(mfile, request);
		}
		
		return "report/submissionComplete";
	}
	
	//파일 업로드 정보 출력
	private void printInfo(String studentNumber, MultipartFile report) {
		System.out.println(studentNumber+"가 업로드한 파일: "+report.getOriginalFilename());
	}
	
	//실제 파일 업로드 메소드 구현
	private void saveFile(MultipartFile report, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\img";
		String filePath = null;
		File folder = new File(savePath);	
		if(!folder.exists())
			folder.mkdir();	//폴더가 없으면 생성
		
		try {
			//파일 저장
			System.out.println(report.getOriginalFilename() + "을 저장합니다.");
			System.out.println("저장 경로: "+savePath);
			filePath = folder + "\\" +report.getOriginalFilename();
			report.transferTo(new File(filePath)); //파일을 저장
			System.out.println("파일 명 : " + report.getOriginalFilename());
			System.out.println("파일 경로 : " + filePath);
			System.out.println("파일 전송이 완료되었습니다.");
		} catch (Exception e) {
			System.out.println("파일 전송 에러 : " + e.getMessage());
		}
	}
}
