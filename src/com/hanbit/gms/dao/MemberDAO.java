package com.hanbit.gms.dao;

import java.util.List;

import com.hanbit.gms.domain.MemberBean;

public interface MemberDAO {
	public String insert(MemberBean member); // 객체에 대한 setter (void, parameter 있음)
	public List<MemberBean>  selectAll(); //getter (return type 있고 parameter 없음)
	public MemberBean selectById(String id); //보안사항이 아니기때문에 public으로..
	public List<MemberBean> selectByName(String name);
	public String count(); //getter (return type 있고 parameter 없음)
	public String updatePass(MemberBean member);
	public String delete(String id) ;
}
