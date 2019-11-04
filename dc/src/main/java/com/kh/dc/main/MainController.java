package com.kh.dc.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.dc.gallary.Gallary;
import com.kh.dc.gallary.GallaryService;

@Controller
public class MainController {

	@Autowired
	private GallaryService gs;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		List<Gallary> list=gs.getGallaryList();
		
		mv.setViewName("index");
		mv.addObject("list",list);
		return mv;
	}
}
