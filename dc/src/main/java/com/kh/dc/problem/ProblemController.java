package com.kh.dc.problem;

import java.util.Iterator;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProblemController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/problem")
	public ModelAndView abc(ModelAndView mv) {
		Problem p=sqlSession.selectOne("problemMapper.getProblem",null);
		String strp=p.getProblem();
		String strs=p.getSolve();
		String strsolu=p.getSolution();
		
		JSONObject jo=new JSONObject();
		jo.put("a", "3");
		jo.put("b", "4");
		jo.put("c", "5");
		
		Set<String> i=jo.keySet();
		Iterator<String> it=i.iterator();
		while(it.hasNext()){
			String temp=it.next();
			strp=strp.replaceAll(temp, (String)jo.get(temp));
			strs=strs.replaceAll(temp, (String)jo.get(temp));
			strsolu=strsolu.replaceAll(temp, (String)jo.get(temp));
		}
		
		p.setProblem(strp);
		p.setSolve(strs);
		p.setSolution(strsolu);
		
		mv.addObject("p", p);
		mv.setViewName("pro");
		return mv;
	}
	
	@RequestMapping("/preview")
	public ModelAndView preview(String math, ModelAndView mv) {
		mv.setViewName("preview");
		mv.addObject("math", math);
		return mv;
	}
}
