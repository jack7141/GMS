package com.hanbit.gms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.constant.SQL;
import com.hanbit.gms.constant.Vendor;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO {
	public static MemberDAOImpl instance = new MemberDAOImpl();
	public static MemberDAOImpl getInstance() {
		return instance;
	}
	private MemberDAOImpl() {
	}// Class.forName을 공유한다. connection은 공유하지 않는다.
	// 실제로는 finally close 하지 말것->GC
	@Override
	public String insert(MemberBean member) {
		String rs = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_INSERT);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getregdate());
			rs = String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}

	@Override
	public List<MemberBean> selectAll() {
		List<MemberBean> list = new ArrayList<>();
		try {
			ResultSet rs =DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_LIST).executeQuery();
			MemberBean member = null; // 지역변수는 반드시 초기화
			while (rs.next()) { // 여러개 호출하기 때문에 while loop
				member = new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				list.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberBean selectById(String id) {
		MemberBean member = new MemberBean();
		try {
			PreparedStatement pstmt=DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID, DB.PASSWORD).getConnection().prepareStatement(SQL.SELECTBYID);
			pstmt.setString(1 , id);
			ResultSet rs= pstmt.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}
	@Override
	public List<MemberBean> selectByName(String name) {
		List<MemberBean> nameList = new ArrayList<>();
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID, DB.PASSWORD).getConnection().prepareStatement(SQL.FINDBYNAME);
			MemberBean member = null;
			pstmt.setString(1, name);
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				member = new MemberBean();
				member.setId(rs.getString(DB.MEMBER_ID));
				member.setName(rs.getString(DB.MEMBER_NAME));
				member.setSsn(rs.getString(DB.MEMBER_SSN));
				nameList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nameList;
	}

	@Override
	public String updatePass(MemberBean member) {
		String rs = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_UPDATE);
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPassword());
			rs=String.valueOf(pstmt.executeQuery());//인트값음 스트링으로 변환
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String count() {
		String rs = null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_COUNT);
			pstmt.setString(1,"");
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String id) {
	String rs=null;
		try {
			PreparedStatement pstmt = DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID, DB.PASSWORD).getConnection().prepareStatement(SQL.MEMBER_DELETE);
			pstmt.setString(1, id);
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;}
	
	}	
