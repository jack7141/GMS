package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.MemberDAO;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;

public class MemberServiceImp implements MemberService {
	public static MemberServiceImp instance=new MemberServiceImp();
	public static MemberServiceImp getInstance() {
		return instance;
	}
	private MemberServiceImp(){}
	@Override
	public String addMember(MemberBean member) {
		return (MemberDAOImpl.getInstance().insert(member).equals("1"))? "성공":"실패";
	}
		
	@Override
	public List<MemberBean> getMembers() {		
		return (MemberDAOImpl.getInstance().selectAll());
	}
	
	@Override
	public String countMembers() {
		return MemberDAOImpl.getInstance().count();
	}
	
	@Override
	public MemberBean findById(String id) {	
		MemberBean member=new MemberBean();
		MemberDAO dao=MemberDAOImpl.getInstance();
		member=dao.selectById(id);
		for(MemberBean mem:list){
			if(id.equals(mem.getId())){
				member=mem;
				break;
			}
		}
		return member;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		return MemberDAOImpl.getInstance().selectByName(name);
	}

	@Override
	public String modify(MemberBean member) {		
		String msg="";
		MemberDAO dao=MemberDAOImpl.getInstance();
		int rs=dao.updatePass(member);
		if(rs==1){
			msg="성공";
		}else{
			msg="실패";
		}return msg;
	}
	
	@Override
	public String remove(String id) {
		String msg="";
		MemberDAO dao=MemberDAOImpl.getInstance();
		int rs=dao.insert(member);
		if(rs==1){
			msg="성공";
		}else{
			msg="실패";
		}return msg;
	}
}
