package com.human.cafe;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.human.service.IF_boardService;
import com.human.util.FileDataUtil;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Controller
public class BbsController {
	@Inject
	private IF_boardService bsrv;
	@Inject
	private FileDataUtil fileDataUtil;
	
	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String WrAction(Locale locale, Model model, BoardVO bvo, MultipartFile[] file) throws Exception{
		
		System.out.println(bvo.getName() +" --디버깅용도");
		String[] fileNames = fileDataUtil.fileUpload(file);
		//System.out.println(fileNames[0]+"/"+fileNames[1]);
		bvo.setFiles(fileNames);
		//System.out.println(file.getOriginalFilename() +" -- 첨부파일 디버깅");
		//filedatautil 객체의  fileupload메서드를 호풀 .. 매개변수로 file을 넘긴다.<지정한파일로 첨부파일 복사>
		
		//String[] fileNames = fileDataUtil.fileUpload(file);
		//System.out.println(fileNames[0]+"aaaaaa");
		
		//넘겨받은 파일명을 boardVO file 변수에  저장한다. 
		//디비작업
		bvo.setFiles(fileNames);
		bsrv.insertOne(bvo);		
		return "redirect:/bbsList"; 
	}
	@RequestMapping(value = "/wrForm", method = RequestMethod.GET)
	public String WrAction1(Locale locale, Model model) {
		return "bbs/wrForm";
	}
	
	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public String bbsList(Locale locale, Model model,@ModelAttribute("PageVO") PageVO pageVO) throws Exception {
		if(pageVO.getPage()==null) {
			pageVO.setPage(1);
		}
		
		System.out.println("현재페이지 정보 : " +pageVO.getPage() );
		int totalpagrCnt = bsrv.countBoard();
		System.out.println( totalpagrCnt +" 건 등록됨");
		pageVO.setTotalCount(totalpagrCnt);
		
		System.out.println(pageVO.getStartNo() + "/" + pageVO.getEndNo());
		
		List<BoardVO> list = bsrv.selectAll(pageVO);
		//System.out.println(list.size() +"-------건 가져옴 디버깅용");
		model.addAttribute("bList",list);
		model.addAttribute("pageVO",pageVO);
		return "bbs/bbsList";
	}
	
	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String BBsView(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception  {
		
		bsrv.updateCnt(vno);
		
		BoardVO tempvo = bsrv.selectOne(vno);
		model.addAttribute("boardVO",tempvo);
		List<String> attachList =bsrv.selectAttach(vno);
		model.addAttribute("attachList", attachList);
		return "bbs/bbsView";
	}
	@RequestMapping(value = "/bbsDel", method = RequestMethod.GET)
	public String BBsDel(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception  {
		
		bsrv.boardDel(vno);
	
		return "redirect:bbsList";
	}
	
	@RequestMapping(value = "/bbsMod", method = RequestMethod.GET)
	public String BBsMod(Locale locale, Model model,@RequestParam("vno") String vno) throws Exception  {
		
		BoardVO tempvo = bsrv.selectOne(vno);
		model.addAttribute("boardVO",tempvo);
		
		return "bbs/bbsmod";
	}
	
	@RequestMapping(value = "/bbsModAction", method = RequestMethod.POST)
	public String bbsModAction(Locale locale, Model model, BoardVO bvo, MultipartFile[] file) throws Exception{
		
		bsrv.updateBoard(bvo);	
		
		return "redirect:/bbsView?vno="+bvo.getNum(); 
	}

}
