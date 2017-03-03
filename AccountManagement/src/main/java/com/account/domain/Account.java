package com.account.domain;

import java.util.Date;

/** 
 * @ClassName: Account.java
 * @Description: 存放账号属性的实体类
 * @author wuyouxiang 
 * @data 2017年3月1日 下午10:17:40
 */
public class Account {
	private String id;
	private String name;
	private String remark;
	private String state;
	private Date createtime;
	private Date lastloadtime;
	private String type;
	private Date start;
	private Date end;
	private boolean sealed;
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the createtime
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * @param createtime the createtime to set
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * @return the lastloadtime
	 */
	public Date getLastloadtime() {
		return lastloadtime;
	}
	/**
	 * @param lastloadtime the lastloadtime to set
	 */
	public void setLastloadtime(Date lastloadtime) {
		this.lastloadtime = lastloadtime;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	public boolean isSealed() {
		return sealed;
	}
	public void setSealed(boolean sealed) {
		this.sealed = sealed;
	}
}
