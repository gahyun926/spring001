package com.human.cafe;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserLogin {

	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(HttpSession session,
						@RequestParam("id") String id,
						@RequestParam("pass") String pass)  {
		
		//�α�������
		//1.�Ķ���� �޴´�. 2.���� ���� �� ������� �����Ѵ�.. ���񽺴��� �ʿ�
		//�׽�Ʈ��
		
		if(id.equals("ttt")) { //�������� �� ���̵�� �ФĽ����� �������ΰ�� ���Ϲ޴°����� ����
			//�α��� ������ ��� 
			
			if(session.getAttribute("login")!= null){
				session.removeAttribute("login");	
			}
			session.setAttribute("login", id); //����ó��
			session.setAttribute("grade", "vip"); //ó���ϰ� ���� ������ ��� , ��ü�� ����
		}else {
			//�α��� �����ΰ��
		}
		//������� �׽�Ʈ�� ���߿� ��񿬵�
		
		
		System.out.println("������");
		return "home";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();//������ ����ȭ
		return "home";
	}
	
	
}
