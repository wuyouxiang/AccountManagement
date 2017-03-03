package com.account.service;

import java.text.ParseException;
import java.util.List;

import com.account.domain.Account;

/** 
 * @ClassName: IAccountService.java
 * @Description: 服务层的接口
 * @author wuyouxiang 
 * @data 2017年3月1日 下午10:28:56
 */
public interface IAccountService {
	/**
	 * @Title: getAll
	 * @Description: 返回所有账号
	 * @author: wuyouxiang 
	 * @return
	 * @return: List<Account>
	 * @date 2017年3月3日 下午6:20:22
	 */
	public List<Account> getAll();
	/**
	 * @Title: add
	 * @Description: 添加新账号
	 * @author: wuyouxiang 
	 * @param account
	 * @return: void
	 * @date 2017年3月3日 下午6:20:47
	 */
	public void add(Account account);
	/**
	 * @Title: deleteA
	 * @Description: 删除账号
	 * @author: wuyouxiang 
	 * @param id
	 * @return: void
	 * @date 2017年3月3日 下午6:21:00
	 */
	public void deleteA(String id);
	/**
	 * @Title: selead
	 * @Description: 封存或解封账号
	 * @author: wuyouxiang 
	 * @param a
	 * @return: void
	 * @date 2017年3月3日 下午6:21:11
	 */
	public void selead(Account a);
	/**
	 * @Title: modify
	 * @Description: 修改账号
	 * @author: wuyouxiang 
	 * @param account
	 * @return: void
	 * @date 2017年3月3日 下午6:21:30
	 */
	public void modify(Account account);
	/**
	 * @Title: find
	 * @Description: 根据查询条件查询账号
	 * @author: wuyouxiang 
	 * @param a
	 * @param period
	 * @return
	 * @throws ParseException
	 * @return: List<Account>
	 * @date 2017年3月3日 下午6:21:46
	 */
	public List<Account> find(Account a,String period) throws ParseException;
}
