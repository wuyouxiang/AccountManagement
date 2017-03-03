package com.account.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.domain.Account;
import com.account.mapper.AccountMapper;
import com.account.service.IAccountService;

/** 
 * @ClassName: AccountService.java
 * @Description: 服务层实现类
 * @author wuyouxiang 
 * @data 2017年3月1日 下午10:29:42
 */
@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountMapper accountMapper;
	@Override
	public List<Account> getAll() {
		return accountMapper.getAll();
	}
	@Override
	public void add(Account account) {
		accountMapper.add(account);
	}
	@Override
	public void deleteA(String id) {
		accountMapper.deleteA(id);
	}
	@Override
	public void modify(Account account) {
		accountMapper.modify(account);
	}
	@Override
	public List<Account> find(Account a,String period) throws ParseException {
		if(period.equals("") && a.getType().equals(""))//根据id和名称查找，可以为空
			return accountMapper.find(a);
		else if(period.equals(""))//根据id，名称，类型查找，id和名称可以为空
			return accountMapper.find1(a);
		else if(a.getType().equals("")){//根据id，名称，注册时间段查找，id和名称可以为空
			String[] during=period.split(" ");
			DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			format1.parse(during[0]);
			a.setStart(format1.parse(during[0]));
			a.setEnd(format1.parse(during[2]));
			return accountMapper.find2(a);
		}else if((!period.equals("") )&& (!a.getType().equals(""))){//根据id，名称，类型，注册时间段查找，id和名称可以为空
			String[] during=period.split(" ");
			DateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
			format1.parse(during[0]);
			a.setStart(format1.parse(during[0]));
			a.setEnd(format1.parse(during[2]));
			return accountMapper.find3(a);
		}else
			return null;
	}
	@Override
	public void selead(Account a) {
		accountMapper.sealed(a);
	}

}
