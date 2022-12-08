package com.human.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.human.dao.IF_joinDAO;
import com.human.vo.JoinVO;

@Service
public class JoinServiceImpl implements IF_JoinService{
	@Inject
	private IF_joinDAO joindao;
	
	@Override
	public void insertOne(JoinVO joinvo) throws Exception {
		// TODO Auto-generated method stub
		joindao.insertOne(joinvo);
	}

}
