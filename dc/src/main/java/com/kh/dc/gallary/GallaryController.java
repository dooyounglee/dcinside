package com.kh.dc.gallary;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gallary/{gal_name}")
public class GallaryController {

	@Autowired
	private GallaryService bService;
	
	private static final Logger logger = LoggerFactory.getLogger(GallaryController.class);
	
	@GetMapping("/list")
	public ModelAndView gotoGallary(ModelAndView mv, @PathVariable("gal_name") String gal_name) {
		System.out.println(gal_name);

		Board b=new Board();
		b.setGal_name(gal_name);
		List<Board> list=bService.getBoardList(b);
		
		mv.setViewName("gallary/list");
		mv.addObject("gal_name", gal_name);
		mv.addObject("list",list);
		return mv;
	}
	
	@GetMapping("/write")
	public ModelAndView writeGet(ModelAndView mv, @PathVariable("gal_name") String gal_name) {
		System.out.println("넘어간다");
		
		mv.setViewName("gallary/write");
		mv.addObject("gal_name", gal_name);
		return mv;
	}
	
	@PostMapping("/write")
	public ModelAndView writePost(ModelAndView mv, @PathVariable("gal_name") String gal_name, Board b) {
		System.out.println(b);
		int result=bService.writeBoard(b);
		
		mv.setViewName("redirect:/gallary/"+gal_name+"/list");
		//mv.addObject("gal_name", gal_name);
		return mv;
	}
}
