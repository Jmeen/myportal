package com.bitacademy.myportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class myhomeController {
	@RequestMapping({"/", "/main"})
	public ModelAndView home () {
		ModelAndView mav = new ModelAndView();
		// 뷰 파일을 연결 : 서블릿에서 RequestDispatcher로 포워드 한 것과 비슷
		mav.setViewName("/WEB-INF/views/home.jsp");
		return mav;
	}
	
	
}
