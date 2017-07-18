package com.hanbit.gms.domain;

public class ArticleBean {
	
	private String title,content,regdate,id;
	private int artcle_seq,hitcount;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getArtcle_seq() {
		return artcle_seq;
	}
	public void setArtcle_seq(int artcle_seq) {
		this.artcle_seq = artcle_seq;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	@Override
	public String toString() {
		return "ArticleBean [title=" + title + ", content=" + content + ", regdate=" + regdate + ", artcle_seq="
				+ artcle_seq + ", hitcount=" + hitcount + "\n]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

		

}
