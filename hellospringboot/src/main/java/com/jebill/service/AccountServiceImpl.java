package com.jebill.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jebill.dao.AccountDao;
import com.jebill.entity.Account;

/**
 * 
 * @author 		JeBillChen
 * @time		2018-03-09
 * @project		作为银企转账服务交互层，完成支出与收入的比账和服务
 *
 */

@Service(value="accountService")
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountDao accountDao;

	/**
	 * 功能：转账出户的用户进行扣钱动作，转正入户的用户进行加钱动作
	 * 方案：进行事务控制，出现异常情况，整体方法回滚处理
	 * 
	 */
	@Override
	@Transactional
	public void transferAccounts(int fromUserAC, int toUserAC, float balance) {
		
		Account accountA = accountDao.getOne(fromUserAC);
		// 转账出户的用户进行扣钱
		accountA.setBalance(accountA.getBalance()-balance);
		accountDao.save(accountA);
		
		Account accountB = accountDao.getOne(toUserAC);
		// 转账出户的用户进行扣钱
		accountB.setBalance(accountB.getBalance()+balance);
		// 堵塞加钱动作
		accountDao.save(accountB);
		
	}

}
