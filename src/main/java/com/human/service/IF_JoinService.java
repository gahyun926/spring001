package com.human.service;

import com.human.vo.JoinVO;

public interface IF_JoinService {
	public void insertOne(JoinVO joinvo) throws Exception;  //컨트롤러에서 호출할 메서드
}
