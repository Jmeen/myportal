package com.bitacademy.myportal.exception;

import com.bitacademy.myportal.repository.UserVo;

// UserDao에ㅐ서 SQLException 발생시 전환할 구체적 Exception Class
public class UserDaoExeption extends RuntimeException {
	// 구체적 상황 정보
	private UserVo userVo = null;

	public UserDaoExeption() {
		super();
	}

	public UserDaoExeption(String message) {
		super(message);
	}

	public UserDaoExeption(String message, UserVo vo) {
		super(message);
		userVo = vo;
	}

	public UserVo getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVo userVo) {
		this.userVo = userVo;
	}

	
	
}
