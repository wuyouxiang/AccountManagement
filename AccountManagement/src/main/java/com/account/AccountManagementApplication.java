package com.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
 * @ClassName: AccountManagementApplication.java
 * @Description: 启动类
 * @author wuyouxiang 
 * @data 2017年3月3日 下午6:15:54
 */ 
@SpringBootApplication
@MapperScan("com.account.mapper")
public class AccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagementApplication.class, args);
	}
}
