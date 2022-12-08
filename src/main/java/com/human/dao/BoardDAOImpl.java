package com.human.dao;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;;

@Repository   // dao �떒�엫�쓣 �븣�젮 以��떎..
public class BoardDAOImpl implements IF_boardDAO{
	// spring�쓽 dao ��  Mybatis sqlsession�쓣 �뿰寃고븯�뒗 媛앹껜
	private static String mapperQuery = "com.pension.dao.IF_boardDAO";  //留ㅽ븨 �씤�꽣�럹�씠�뒪 寃쎈줈�꽕�젙
	//Mybatis�쓽 sqlSession媛앹껜媛� �븘�슂�빀�땲�떎.
	@Inject    // 而⑦뀒�씠�꼫�뿉�꽌 媛��졇���빞�븳�떎. 而⑦뀒�씠�꼫�뿉�꽌 �옄猷뚰삎怨� 留욌뒗 媛앹껜�쓽 二쇱냼瑜� 二쇱엯�빐 以��떎.
	private SqlSession sqlSession;  // SqlSession ���엯�쓽 媛앹껜�뒗 �뒪�봽留� 而⑦뀒�씠�꼫�뿉 �엳�떎. 
	                                  // �뿬湲곗꽌 �씠 媛앹껜媛� �븘�슂�븯�떎. 洹몃윴�뜲 而⑦뀒�씠�꼫�뿉�꽌 媛��졇���빞�븳�떎. �뒪�봽留곸� DI媛쒕뀗
	@Override
	public void insertOne(BoardVO boardvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuery+".insertOne", boardvo); // 荑쇰━瑜� 留ㅽ븨諛� �떎�뻾�븳�떎...
		       //  <insert //留ㅽ븨�젙蹂�   // id       // parameter
	}
	@Override
	public int countBoard() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuery+".countBoard");
	}
	
	
	@Override
	public List<BoardVO> selectALL(PageVO pageVO) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(mapperQuery+".selectAll", pageVO);
	}
	
	@Override
	public void insertAttach(String filename) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mapperQuery+".board_attach",filename);
	}
	@Override
	public BoardVO selectOne(String vno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mapperQuery+".selectOne",vno);
	}
	@Override
	public List<String> selectAttach(String vno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mapperQuery+".selectAttach",vno);
	}
	@Override
	public void updateCnt(String vno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(mapperQuery+".cntplus",vno);
	}
	@Override
	public void boardDel(String vno) throws Exception {
		// TODO Auto-generated method stub 
		sqlSession.delete(mapperQuery+".boardDel",vno);
	}
	@Override
	public void updateBoard(BoardVO boardvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(mapperQuery+".updateBoard", boardvo);
	}
	
	

}
