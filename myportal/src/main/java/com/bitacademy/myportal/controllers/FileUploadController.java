package com.bitacademy.myportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.myportal.service.FileUploadService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {

	@Autowired
	private FileUploadService fileuploadservice;

	@RequestMapping("/form")
	public String form() {
		return "fileupload/form"; // form으로 포워드
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file1") MultipartFile file1, Model model) {
		// 파일 업로드

		String saveFilename = fileuploadservice.store(file1);
		System.out.println("저장될 파일 이름 " + saveFilename);

		model.addAttribute("urlImage", saveFilename);
		return "fileupload/result";
	}
}
