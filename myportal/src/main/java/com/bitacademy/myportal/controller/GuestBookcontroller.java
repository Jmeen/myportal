package com.bitacademy.myportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/guestbook")
@Controller
public class GuestBookcontroller {
	@RequestMapping({ "", "/", "/list" })
	public String list() {
		return "guestbook/list";
	}
}
