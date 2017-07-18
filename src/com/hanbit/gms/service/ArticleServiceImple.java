package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;

public class ArticleServiceImple implements ArticleSerivce{
	public static ArticleServiceImple instance=new ArticleServiceImple();
	public static ArticleServiceImple getInstance() {
		return instance;
	}
	private  ArticleServiceImple(){}
	@Override
	public String write(ArticleBean bean) {
		return (ArticleDAOImpl.getInstance().insert(bean).equals("1"))? "성공":"실패";
	}

	@Override
	public List<ArticleBean> list() {
		return ArticleDAOImpl.getInstance().selectAll();
	}

	@Override
	public List<ArticleBean> findByID(String id) {
		return ArticleDAOImpl.getInstance().selectById(id);
	}

	@Override
	public ArticleBean findBySeq(int seq) {
		return null;
	}

	@Override
	public String count() {
		return ArticleDAOImpl.getInstance().count();
	}

	@Override
	public String modify(ArticleBean bean) {
		return null;
	}

	@Override
	public String remove(int seq) {
		return ArticleDAOImpl.getInstance().delete(String.valueOf(seq));
	}

	
	
}
