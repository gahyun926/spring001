package com.human.service;

import java.util.List;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

public interface IF_boardService {
	public void insertOne(BoardVO boardvo) throws Exception; // 而⑦듃濡ㅻ윭�뿉�꽌 �샇異쒗븷 硫붿꽌�뱶...

	public List<BoardVO> selectAll(PageVO pageVO) throws Exception;
	
	public int countBoard() throws Exception;
	
	public BoardVO selectOne(String vno) throws Exception;
	
	public List<String> selectAttach(String vno) throws Exception;
	
	public void updateCnt(String vno) throws Exception;
	
	public void boardDel(String vno) throws Exception;
	
	public void updateBoard(BoardVO boardvo) throws Exception;
}
