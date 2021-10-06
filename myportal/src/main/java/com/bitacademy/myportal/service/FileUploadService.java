package com.bitacademy.myportal.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	// 파일 저장 위치
	private static String SAVE_PATH = "D:/upload";

	public String store(MultipartFile mFile) {
		String saveFileName = ""; // 저장할 이름
		String originalFilename = "";
		try {
			Long size = mFile.getSize();
			originalFilename = mFile.getOriginalFilename();
			String extName = originalFilename.substring(originalFilename.lastIndexOf('.'));
			System.out.println("원본파일명 : " + originalFilename);
			System.out.println("파일사이즈 : " + size);
			System.out.println("확장자: " + extName);
			saveFileName = getSaveFilename(extName);
			System.out.println("저장할 파일명 : " + saveFileName);
			writeFile(mFile, saveFileName);

		} catch (IOException e) {
//			e.printStackTrace();
			System.err.println("파일 저장 실패");
		}

		return saveFileName;
	}

	private void writeFile(MultipartFile mFile, String saveFilename) throws IOException {
		// 저장할 파일 바이너리
		byte[] fileData = mFile.getBytes();

		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
		fos.write(fileData);
		fos.close();
	}

	private String getSaveFilename(String ext) {
		// 중복되지 않는 파일명 생성
		Calendar cal = Calendar.getInstance();
		return String.valueOf(cal.getTimeInMillis() / 1000) + ext.toLowerCase();
	}
}
