package com.hanbit.gms.constant;
public class SQL {
			
			public static final String MEMBER_INSERT= String.format("INSERT INTO %s(%s,%s,%s,%s,%s)VALUES(?, ?, ?, ?, SYSDATE)",DB.TABLE_MEMBER,DB.MEMBER_ID,DB.MEMBER_NAME,DB.MEMBER_PASS,DB.MEMBER_REGDATE,DB.MEMBER_SSN);
			public static final String MEMBER_LIST="SELECT * FROM Member";
			public static final String  SELECTBYID=String.format("SELECT * FROM %s WHERE %s=?",  DB.TABLE_MEMBER,DB.MEMBER_NAME);
			public static final String FINDBYNAME=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_ID);
			public static final String MEMBER_UPDATE=String.format("UPDATE %s SET %s=? WHERE %s=?", DB.TABLE_MEMBER,DB.PASSWORD,DB.MEMBER_ID);
			public static final String MEMBER_DELETE=String.format("DELETE FROM  %s WHERE %s=?", DB.TABLE_MEMBER,DB.MEMBER_ID);
			public static final String MEMBER_COUNT=String.format("SELECT COUNT(*) AS	%s FROM %s","count",DB.TABLE_MEMBER);
			public static final String ARTICLE_INSERT=String.format(	"INSERT INTO %s(%s,%s,%s,%s,%s,%s)VALUES(article_seq.nextval,?,?,?,0,SYSDATE)",DB.TABLE_BOARD, DB.ARTICLE_SEQ, DB.BOARD_ID, DB.BOARD_TITLE, DB.BOARD_CONTENT,	DB.BOARD_HITECOUNT, DB.BOARD_REGDATE);
			public static final String ARTICLE_LIST="SELECT * FROM board";
			public static final String  ARTICLE_FINDBYBYID=String.format("SELECT * FROM %s WHERE %s=?",  DB.TABLE_BOARD,DB.BOARD_ID);
			public static final String ARTICLE_FINDBYSEQ=String.format("SELECT * FROM %s WHERE %s=?", DB.TABLE_BOARD,DB.ARTICLE_SEQ);
			public static final String ARTICLE_MODIFY=String.format("UPDATE %s SET %s=? WHERE %s=?", DB.TABLE_BOARD,DB.BOARD_TITLE,DB.ARTICLE_SEQ);
			public static final String ARTICLE_REMOVE=String.format("DELETE FROM  %s WHERE %s=?", DB.TABLE_BOARD,DB.ARTICLE_SEQ);
			public static final String ARTICLE_COUNT=String.format("SELECT COUNT(*) AS	%s FROM %s","count",DB.TABLE_BOARD);











}



