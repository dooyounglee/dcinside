package com.kh.dc.problem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProblemController {

	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("/list.pro")
	public ModelAndView problemList(ModelAndView mv) {
		List<Problem> plist=sqlSession.selectList("problemMapper.getProblemList",null);
		mv.addObject("plist", plist);
		mv.setViewName("problem/problemList");
		return mv;
	}
	
	@GetMapping("/make.pro")
	public ModelAndView makeGet(ModelAndView mv) {
		mv.setViewName("problem/make");
		return mv;
	}
	
	@PostMapping("/make.pro")
	public ModelAndView makePost(Problem p, ModelAndView mv) {
		System.out.println(p);
		sqlSession.insert("problemMapper.insertProblem",p);
		Problem newp=p;
		System.out.println(newp);
		
		//ArrayList<Variables> vlist=new ArrayList<Variables>();
//		for(String v : val) {
//			Variables vv=new Variables();
//			vv.setP_no(p.getP_no());
//			vv.setVal(v);
//			sqlSession.insert("problemMapper.insertVariables",vv);
//		}
		mv.setViewName("redirect:/get.pro?p_no="+p.getP_no());
		return mv;
	}
	
	@GetMapping("/get.pro")
	public ModelAndView get(int p_no, ModelAndView mv) {
		Problem p=sqlSession.selectOne("problemMapper.getProblem",p_no);
		//List<Variables> vlist=sqlSession.selectList("problemMapper.getVariables",p_no);
		mv=abc(p,mv);
		//mv.addObject("vlist", vlist);
		mv.addObject("p", p);
		mv.setViewName("problem/get");
		return mv;
	}
	
	@GetMapping("/edit.pro")
	public ModelAndView editGet(int p_no, ModelAndView mv) {
		Problem p=sqlSession.selectOne("problemMapper.getProblem",p_no);
		List<Variables> vlist=sqlSession.selectList("problemMapper.getVariables",p_no);
		
		mv.addObject("vlist", vlist);
		mv.addObject("p", p);
		mv.setViewName("problem/make");
		return mv;
	}
	
	@PostMapping("/edit.pro")
	public ModelAndView editPost(Problem p, ModelAndView mv) {
		System.out.println(p);
		sqlSession.update("problemMapper.updateProblem",p);
		
		mv.setViewName("redirect:/get.pro?p_no="+p.getP_no());
		return mv;
	}
	
//	@RequestMapping("/problem")
//	public ModelAndView abc(ModelAndView mv) {
//		Problem p=sqlSession.selectOne("problemMapper.getProblem",null);
//		List<Variables> vlist=sqlSession.selectList("problemMapper.getVariables",null);
//		int random=(int)(Math.random()*vlist.size());
//		Variables v=vlist.get(random);
//		
//		System.out.println(p);
//		System.out.println(v);
//		String strp=p.getProblem();
//		String strs=p.getSolve();
//		String strsolu=p.getSolution();
//		String[] keyval=p.getKeyval().split(",");
//		String[] val=v.getVal().split(",");
//		
//		JSONObject jo=new JSONObject();
//		for(int i=0;i<keyval.length;i++) {
//			jo.put(keyval[i], val[i]);
//		}
//		
//		Set<String> i=jo.keySet();
//		Iterator<String> it=i.iterator();
//		while(it.hasNext()){
//			String temp=it.next();
//			strp=strp.replaceAll(temp, (String)jo.get(temp));
//			strs=strs.replaceAll(temp, (String)jo.get(temp));
//			strsolu=strsolu.replaceAll(temp, (String)jo.get(temp));
//		}
//		
//		p.setProblem(strp);
//		p.setSolve(strs);
//		p.setSolution(strsolu);
//		
//		mv.addObject("p", p);
//		mv.addObject("v", v);
//		mv.setViewName("pro");
//		return mv;
//	}
	
	@RequestMapping("/preview")
	public ModelAndView preview(String math, ModelAndView mv) {
		mv.setViewName("preview");
		mv.addObject("math", math);
		return mv;
	}
	
	@ResponseBody
	@PostMapping("/ok.val")
	public String okVariables(Variables v) {
		int result=sqlSession.insert("problemMapper.okVariables",v);
		return "success";
	}
	
	@ResponseBody
	@PostMapping("/del.val")
	public String delVariables(Variables v) {
		int result=sqlSession.delete("problemMapper.delVariables",v);
		return "success";
	}
	
	@ResponseBody
	@PostMapping("/edit.val")
	public String editVariables(Variables v) {
		int result=sqlSession.update("problemMapper.editVariables",v);
		return "success";
	}
	
	
	
	
	
	
	
	public ModelAndView abc(Problem p, ModelAndView mv) {
		//Problem p=sqlSession.selectOne("problemMapper.getProblem",p_no);
		List<Variables> vlist=sqlSession.selectList("problemMapper.getVariables",p.getP_no());
		if(vlist.size()>0) {
			int random=(int)(Math.random()*vlist.size());
			Variables v=vlist.get(random);
			
			System.out.println(p);
			System.out.println(v);
			String strp=p.getProblem();
			String strs=p.getSolve();
			String strsolu=p.getSolution();
			String[] keyval=p.getKeyval().split(",");
			String[] val=v.getVal().split(",");
			
			JSONObject jo=new JSONObject();
			for(int i=0;i<keyval.length;i++) {
				jo.put(keyval[i], val[i]);
			}
			
			Set<String> i=jo.keySet();
			Iterator<String> it=i.iterator();
			while(it.hasNext()){
				String temp=it.next();
				strp=strp.replaceAll(temp, (String)jo.get(temp));
				strs=strs.replaceAll(temp, (String)jo.get(temp));
				strsolu=strsolu.replaceAll(temp, (String)jo.get(temp));
			}
			
			Problem ranp=new Problem();
			ranp.setProblem(strp);
			ranp.setSolve(strs);
			ranp.setSolution(strsolu);
			
			mv.addObject("ranp", ranp);
			//mv.addObject("v", v);
		}
		
		return mv;
	}
}
