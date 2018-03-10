package com.jebill.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jebill.entity.Account;
import com.jebill.service.AccountService;

@RestController
@RequestMapping(value="/account")
public class AccountController {
	
	@Resource
	private AccountService accountService;
//	Integer fromUserId = 2;
//	Integer toUserId = 3;
	
	@RequestMapping(value="/transfer")
	public String balance(Account account) {
		System.err.println("================");
		try {
			accountService.transferAccounts(2, 3, 100);
			return "OK";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
	}

}
