package com.kh.dc.gallary;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gallary")
public class GallaryController {

	@Autowired
	private GallaryService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(GallaryController.class);
	
	@GetMapping("/{gal_name}/list")
	public ModelAndView gotoGallary(ModelAndView mv, @PathVariable("gal_name") String gal_name) {

		Board b=new Board();
		b.setGal_name(gal_name);
		List<Board> list=bService.getBoardList(b);
		
		mv.setViewName("gallary/list");
		mv.addObject("gal_name", gal_name);
		mv.addObject("list",list);
		
		return mv;
	}
	
	@GetMapping("/{gal_name}/write")
	public ModelAndView writeGet(ModelAndView mv, @PathVariable("gal_name") String gal_name) {
		
		mv.setViewName("gallary/write");
		mv.addObject("gal_name", gal_name);
		return mv;
	}
	
	@PostMapping("/{gal_name}/write")
	public ModelAndView writePost(ModelAndView mv, @PathVariable("gal_name") String gal_name, Board b) {
		System.out.println(b);
		int result=bService.writeBoard(b);
		
		mv.setViewName("redirect:/gallary/"+gal_name+"/list");
		return mv;
	}
	
	@GetMapping("/{gal_name}/get")
	public ModelAndView getGet(ModelAndView mv, @PathVariable("gal_name") String gal_name, Board b) {
		System.out.println("넘어간다"+gal_name+b);
		b.setGal_name(gal_name);
		System.out.println(b+"-");
		Board getb=bService.getBoard(b);
		System.out.println(b+"--");
		List<Reply> rlist=bService.getReplyList(b);
		
		mv.setViewName("gallary/get");
		mv.addObject("b", getb);
		mv.addObject("rlist",rlist);
		return mv;
	}
	
	@GetMapping("/{gal_name}/edit")
	public ModelAndView editGet(ModelAndView mv, @PathVariable("gal_name") String gal_name, Board b) {
		System.out.println("넘어간다"+gal_name+b);
		b.setGal_name(gal_name);
		
		b=bService.getBoard(b);
		mv.setViewName("gallary/write");
		mv.addObject("b", b);
		return mv;
	}
	
	@PostMapping("/{gal_name}/edit")
	public ModelAndView editPost(ModelAndView mv, @PathVariable("gal_name") String gal_name, Board b) {
		b.setGal_name(gal_name);
		
		int result=bService.editBoard(b);
		if(result>0) {
			b=bService.getBoard(b);
		}else {
		}
		mv.setViewName("redirect:/gallary/"+gal_name+"/get?b_no="+b.getB_no());
		mv.addObject("b", b);
		return mv;
	}
	
	@PostMapping("/upload")
	public void upload(MultipartHttpServletRequest req,HttpServletResponse res) {
		MultipartFile file=req.getFile("uploadFile");
		String savePath=req.getSession().getServletContext().getRealPath("resources");
		String filePath=savePath+"\\upload\\"+file.getOriginalFilename();
		try {
			file.transferTo(new File(filePath));
			res.getWriter().println(file.getOriginalFilename());
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/make.gal")
	public ModelAndView makeGet(ModelAndView mv) {
		mv.setViewName("gallary/make");
		return mv;
	}
	
	@PostMapping("/make.gal")
	public ModelAndView makePost(ModelAndView mv, Board b) {
		int result=bService.makeGallary(b);
		if(result>0) {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@PostMapping("/drop.gal")
	public ModelAndView dropPost(ModelAndView mv, Board b) {
		int result=bService.dropGallary(b);
		if(result>0) {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	//reply
	@PostMapping("/{gal_name}/write.reply")
	public ModelAndView writeReplyPost(ModelAndView mv, @PathVariable("gal_name") String gal_name, Reply r) {
		System.out.println(r);
		int result=bService.writeReply(r);
		System.out.println(result);
//		if(result>0) {
//			mv.setViewName("redirect:/");
//		}
		mv.setViewName("redirect:/gallary/"+gal_name+"/get?b_no="+r.getB_no());
		return mv;
	}
}
