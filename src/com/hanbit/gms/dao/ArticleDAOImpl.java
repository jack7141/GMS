package com.hanbit.gms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanbit.gms.constant.DB;
import com.hanbit.gms.constant.SQL;
import com.hanbit.gms.constant.Vendor;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.factory.DatabaseFactory;

public class ArticleDAOImpl implements ArticleDAO {
	public static ArticleDAOImpl instance=new ArticleDAOImpl();
	public static ArticleDAOImpl getInstance() {
		return instance;
	}
	
	private ArticleDAOImpl() {}
	
	@Override
	public String insert(ArticleBean bean) {
		String  rs = null;
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID,DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_INSERT);
				pstmt.setString(1, bean.getId());
				pstmt.setString(2, bean.getTitle());
				pstmt.setString(3, bean.getContent());
				rs=String.valueOf( pstmt.executeUpdate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public List<ArticleBean> selectAll() {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID,DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_LIST);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new ArticleBean();
				bean. setArtcle_seq(Integer.parseInt(rs.getString(DB.ARTICLE_SEQ)));
				bean. setId(rs.getString(DB.BOARD_ID));
				bean. setTitle(rs.getString(DB.BOARD_TITLE));
				bean. setContent(rs.getString(DB.BOARD_CONTENT));
				bean. setHitcount(Integer.parseInt(rs.getString(DB.BOARD_HITECOUNT)));
				bean. setRegdate(rs.getString(DB.BOARD_REGDATE));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<ArticleBean> selectById(String id) {
		List<ArticleBean> list = new ArrayList<>();
		ArticleBean bean = null;
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID,DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_FINDBYBYID);
			pstmt.setString(1, id);	
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				bean=new ArticleBean();
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setTitle(rs.getString(DB.BOARD_TITLE));
				list.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArticleBean selectBySeq(String seq) {
		ArticleBean bean=new ArticleBean();
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID,DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_FINDBYSEQ);
			pstmt.setString(1,seq);
			ResultSet rs=pstmt.executeQuery();
			while (rs.next()) {
				bean=new ArticleBean();
				bean.setId(rs.getString(DB.BOARD_ID));
				bean.setContent(rs.getString(DB.BOARD_CONTENT));
				bean.setRegdate(rs.getString(DB.BOARD_REGDATE));
				bean.setArtcle_seq(rs.getShort(DB.ARTICLE_SEQ));
				bean.setTitle(rs.getString(DB.BOARD_TITLE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Override
	public String count() {
			String count="";
		try {
			ResultSet  rs=( DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID,DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_COUNT).executeQuery());
				if(rs.next()){
					count=rs.getString("count");
				}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public String update(ArticleBean bean) {
		String rs="";
		try {
			
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID,DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_MODIFY);
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, String.valueOf(bean.getArtcle_seq()));
			rs=String.valueOf(pstmt.executeUpdate());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String delete(String seq) {
		String rs="";
		try {
			PreparedStatement pstmt= DatabaseFactory.createDatabase(Vendor.ORACLE, DB.USERID,DB.PASSWORD).getConnection().prepareStatement(SQL.ARTICLE_REMOVE);
			pstmt.setString(1, seq);
			rs=String.valueOf(pstmt.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
