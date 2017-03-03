package com.account.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.account.domain.Account;
import com.account.service.IAccountService;;

/** 
 * @ClassName: AccountController.java
 * @Description:账号管理控制层
 * @author wuyouxiang 
 * @data 2017年3月1日 下午10:06:07
 */
@Controller
public class AccountController {
	
	@Autowired
	private IAccountService accountService;
	
	/**
	 * @Title: Account
	 * @Description: 跳转到账号管理页面
	 * @author: wuyouxiang 
	 * @return
	 * @return: String
	 * @date 2017年3月3日 下午6:13:16
	 */
	@RequestMapping("/account")
	public String Account(){
		return "account";
	}
	/**
	 * @Title: addForm
	 * @Description: 添加一个账号
	 * @author: wuyouxiang 
	 * @param a
	 * @return
	 * @return: String
	 * @date 2017年3月3日 下午6:14:01
	 */
	@ResponseBody
	@RequestMapping("/addForm")
	public String addForm(Account a){
		a.setCreatetime(new Date());
		a.setLastloadtime(new Date());
		accountService.add(a);
		return "success";
	}
	/**
	 * @Title: delete
	 * @Description: 删除一个账号（软删）
	 * @author: wuyouxiang 
	 * @param id
	 * @return
	 * @return: String
	 * @date 2017年3月3日 下午6:14:18
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(String id){
		accountService.deleteA(id);
		return "success";
	}
	/**
	 * @Title: modify
	 * @Description: 修改一个账号
	 * @author: wuyouxiang 
	 * @param a
	 * @return
	 * @return: String
	 * @date 2017年3月3日 下午6:14:41
	 */
	@ResponseBody
	@RequestMapping("/modify")
	public String modify(Account a){
		accountService.modify(a);
		return "success";
	}
	/**
	 * @Title: find
	 * @Description: 根据查询条件查询
	 * @author: wuyouxiang 
	 * @param a
	 * @param period
	 * @return
	 * @return: Map<String,List<Account>>
	 * @date 2017年3月3日 下午6:14:54
	 */
	@ResponseBody
	@RequestMapping("/find")
	public Map<String,List<Account>> find(Account a,String period){
		Map<String,List<Account>> result=new HashMap<String,List<Account>>();
		try {
			result.put("data", accountService.find(a,period));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * @Title: sealed
	 * @Description: 封存或解封一个账号
	 * @author: wuyouxiang 
	 * @param a
	 * @return
	 * @return: String
	 * @date 2017年3月3日 下午6:16:20
	 */
	@ResponseBody
	@RequestMapping("/sealed")
	public String sealed(Account a){
		if(a.isSealed())
			a.setSealed(false);
		else
			a.setSealed(true);
		accountService.selead(a);;
		return "success";
	}
}
