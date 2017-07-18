package com.hanbit.gms.controller;

import javax.swing.JOptionPane;

import com.hanbit.gms.constant.Butt;
import com.hanbit.gms.dao.MemberDAOImpl;
import com.hanbit.gms.domain.MemberBean;
import com.hanbit.gms.service.MemberService;
import com.hanbit.gms.service.MemberServiceImp;

public class MemberController {
	public static void main(String[] args){
		MemberBean member=null; 
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
				member=new MemberBean(); //초기화
				String[] arr=(JOptionPane.showInputDialog("이름/ID/Password/SSN")).split("/");
				member.setName(arr[0]);
				member.setId(arr[1]);
				member.setPassword(arr[2]);
				member.setSsn(arr[3]);
				MemberDAOImpl.getInstance().insert(member);
				JOptionPane.showMessageDialog(null, "회원가입 성공");
				break flag;
			case COUNT:							
				JOptionPane.showMessageDialog(null,MemberDAOImpl.getInstance().count());
				break flag;
			case LIST:
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().selectAll());
				break flag;
			case FIND_ID:
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().selectById((JOptionPane.showInputDialog(null, "조회하려는 ID를 입력하세요"))).toString());
				break flag;
			case FIND_NAME:
				JOptionPane.showMessageDialog(null, MemberDAOImpl.getInstance().selectByName((JOptionPane.showInputDialog(null, "찾으려는 이름을 입력하세요"))).toString());
				break flag;
				
			case UPDATE:
				String updateId=JOptionPane.showInputDialog("ID를 입력하세요.");
				MemberBean mem=new MemberBean();
				mem.setId(updateId);
				String newPass=JOptionPane.showInputDialog("바꿀 비밀번호를 입력하세요");
				mem.setPassword(newPass);
				String newSsn=JOptionPane.showInputDialog("바꿀 주민등록 번호를 입력하세요");
				mem.setSsn(newSsn);
				MemberDAOImpl.getInstance().updatePass(mem);
				JOptionPane.showMessageDialog(null, "비밀번호 변경 성공");
				break flag;
			
			case DEL:
				String deleteId=JOptionPane.showInputDialog(MemberDAOImpl.getInstance().delete("지울 회원 ID를 입력하세요"));
				JOptionPane.showMessageDialog(null, "삭제 완료");
				break flag;
			}	 
		}while(true);
		
	}
}
