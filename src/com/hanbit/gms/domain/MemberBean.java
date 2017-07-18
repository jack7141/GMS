package com.hanbit.gms.domain;

import java.io.Serializable;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id, password, name, ssn, regdate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setregdate(String regdate) {
		this.regdate = regdate;
	}

	public String getregdate() {
		return regdate;
	}

	public String toString() {
		return "회원 [id=" + id + " name=" + name + " password=" + password + "SSN" + ssn + "날짜" + regdate + "\n]";

	}
}
