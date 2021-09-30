package com.bitacademy.myportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitacademy.myportal.repository.GuestbookVo;
import com.bitacademy.myportal.service.GuestbookService;

@RequestMapping("/guestbook")
@Controller
public class GuestBookcontroller {
	@Autowired
	GuestbookService GuestbookserviceImpl;

	@RequestMapping({ "", "/", "/list" })
	public String list(Model model) {
		List<GuestbookVo> list = GuestbookserviceImpl.GetMessageLIst();
		System.out.println(list);
		model.addAttribute("list", list);
		return "guestbook/list";
	}
}
