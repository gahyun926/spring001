package com.human.cafe;

import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.human.service.IF_JoinService;
import com.human.vo.JoinVO;

@Controller
public class JoinController {
	@Inject
	private IF_JoinService jsrv;
	
	@RequestMapping(value = "/joinAction", method = RequestMethod.POST)
	public String WrAction(Locale locale, Model model, JoinVO jvo) throws Exception {
		//객체로 받을때는 파라미터이름과 객체의 변수이름이 일치하고 getter,setter가 있어야 한다. >자동매
		jsrv.insertOne(jvo);
		System.out.println(jvo.getName() + "-------------디버깅 용도");
		
		return "home";
	}
	
	@RequestMapping(value = "/joinForm", method = RequestMethod.GET)
	public String WrAction1(Locale locale, Model model) {
		
		return "joinForm";
	}

	
}
