package com.hanbit.gms.service;

import java.util.List;

import com.hanbit.gms.domain.ArticleBean;

public interface ArticleSerivce {
	   public String write(ArticleBean bean);
	   public List<ArticleBean> list();
	   public List<ArticleBean> findByID(String ID); // 한 아이디로 여러개의 글을 쓸 수 있기 때문에 리스트로 받는다. 1 대 다의 구도
	   public ArticleBean findBySeq(int seq);
	   public String count();
	   public String modify(ArticleBean bean);
	   public String remove(int seq);
	}

