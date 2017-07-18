package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.dao.ArticleDAOImpl;
import com.hanbit.gms.domain.ArticleBean;
import com.hanbit.gms.service.ArticleServiceImple;

public class Boardcontroller {
	public static void main(String[]args){
		
		ArticleBean bean=null;
		Butt[] buttons={Butt.EXIT,Butt.ADD,Butt.COUNT,Butt.LIST,Butt.FIND_ID,Butt.FIND_NAME,Butt.UPDATE,Butt.DEL};
		do{
			flag:
				switch((Butt) JOptionPane.showInputDialog(
						 null,//frame
						 "MEMBER ADMIN",
						 "SELECT MENU",
						 JOptionPane.QUESTION_MESSAGE,
						 null,
						 buttons,
						 buttons[1]
						 )){
				case EXIT:return;
		
				case ADD:
					bean=new ArticleBean();
					String[] arr=(JOptionPane.showInputDialog("아이디/제목/콘텐츠")).split("/");
					bean.setId(arr[0]);
					bean.setTitle(arr[1]);
					bean.setContent(arr[2]);
					JOptionPane.showMessageDialog(null, ArticleDAOImpl.getInstance().insert(bean));
					break flag;
				case COUNT:							
					JOptionPane.showMessageDialog(null,ArticleDAOImpl.getInstance().count());
					break flag;
				case LIST:
					JOptionPane.showMessageDialog(null, ArticleDAOImpl.getInstance().selectAll());
					break flag;
				case FIND_ID:
					JOptionPane.showMessageDialog(null, ArticleDAOImpl.getInstance().selectById(JOptionPane.showInputDialog(null, "조회하려는 ID를 입력하세요")));
					break flag;
				case FIND_NAME:
					JOptionPane.showMessageDialog(null, ArticleDAOImpl.getInstance().selectBySeq(JOptionPane.showInputDialog("찾으실 SEQ번호를 입력하세요")));
					break flag;
					
		case UPDATE:
					ArticleBean bean2=new ArticleBean();
					bean2.setTitle(JOptionPane.showInputDialog("제목을 입력하세요"));
					bean2.setArtcle_seq(Integer.parseInt(JOptionPane.showInputDialog("seq번호를 입력하세요")));
					ArticleDAOImpl.getInstance().update(bean2);
					JOptionPane.showMessageDialog(null, "아이디,내용 수정 성공");
					break flag;

				case DEL:
					JOptionPane.showMessageDialog(null, ArticleServiceImple.getInstance().remove(Integer.parseInt(JOptionPane.showInputDialog("seq?"))));
					JOptionPane.showMessageDialog(null, "아이디,내용 삭제 성공");
					break flag;
				}
			}while(true);
		}	
	}

