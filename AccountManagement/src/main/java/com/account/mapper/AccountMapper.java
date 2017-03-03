package com.account.mapper;

import java.util.List;

import com.account.domain.Account;

/** 
 * @ClassName: AccountMapper.java
 * @Description: 
 * @author wuyouxiang 
 * @data 2017年3月1日 下午10:32:15
 */
public interface AccountMapper extends MyMapper<Account> {
	/**
	 * @Title: getAll
	 * @Description: 获取所有账号
	 * @author: wuyouxiang 
	 * @return: List<Account>
	 * @date 2017年3月3日 下午6:07:37
	 */
	public List<Account> getAll();
	/**
	 * @Title: add
	 * @Description: 添加一个新账号
	 * @author: wuyouxiang 
	 * @param account
	 * @return: void
	 * @date 2017年3月3日 下午6:08:06
	 */
	public void add(Account account);
	/**
	 * @Title: deleteA
	 * @Description: 删除账号（软删除）
	 * @author: wuyouxiang 
	 * @param id
	 * @return: void
	 * @date 2017年3月3日 下午6:08:25
	 */
	public void deleteA(String id);
	/**
	 * @Title: sealed
	 * @Description: 解封或封存
	 * @author: wuyouxiang 
	 * @param account
	 * @return: void
	 * @date 2017年3月3日 下午6:08:52
	 */
	public void sealed(Account account);
	/**
	 * @Title: modify
	 * @Description: 修改一个账号
	 * @author: wuyouxiang 
	 * @param account
	 * @return: void
	 * @date 2017年3月3日 下午6:09:41
	 */
	public void modify(Account account);
	/**
	 * @Title: find
	 * @Description: 根据编码和名称模糊查询，任意一个都可为空
	 * @author: wuyouxiang 
	 * @param account
	 * @return
	 * @return: List<Account>
	 * @date 2017年3月3日 下午6:09:56
	 */
	public List<Account> find(Account account);
	/**
	 * @Title: find1
	 * @Description: 根据编码和名称模糊查询加上类型，编码和名称任意一个都可为空
	 * @author: wuyouxiang 
	 * @param account
	 * @return
	 * @return: List<Account>
	 * @date 2017年3月3日 下午6:10:18
	 */
	public List<Account> find1(Account account);
	/**
	 * @Title: find2
	 * @Description: 根据编码和名称模糊查询加上时间，编码和名称任意一个都可为空
	 * @author: wuyouxiang 
	 * @param account
	 * @return
	 * @return: List<Account>
	 * @date 2017年3月3日 下午6:12:02
	 */
	public List<Account> find2(Account account);
	/**
	 * @Title: find3
	 * @Description: 根据编码和名称模糊查询加上时间加上类型，编码和名称任意一个都可为空
	 * @author: wuyouxiang 
	 * @param account
	 * @return
	 * @return: List<Account>
	 * @date 2017年3月3日 下午6:12:12
	 */
	public List<Account> find3(Account account);
}
