package com.human.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.JoinVO;

@Repository //dao단임을 알려준다.
public class JoinDAOImpl implements IF_joinDAO{
	//Spring의 dao와  Mybatis의  sqlsession을 연결하는 객체
	
	private static String mapperQuery = "com.pension.dao.IF_joinDAO"; //매핑 인터페이스 경로설정
	
	//MYbatis의 sqlSession객체가 필요
	@Inject //컨테이너에서 가져와야 한다. 컨테이너에서 자료형과 맞는 객체의 주소를 주입해준다.
	private SqlSession sqlSession;    //SqlSession 타입의 객체는 스프링 컨테이너에 있다.
										//여기서 이 객체가 필요하다. 그런데 컨테이너에서 가져와야 한다. 스프링은 DI개념

	@Override
	public void insertOne(JoinVO joinvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuery+".insertOne", joinvo);  
	}
}

