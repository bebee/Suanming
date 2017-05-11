package com.suanming.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.suanming.bazi.BaZi;
import com.suanming.entity.Gu_info;
import com.suanming.entity.Ren;
import com.suanming.entity.Ren_info;
import com.suanming.service.GuService;
import com.suanming.service.RenService;

@Controller
public class MingController {
	@Autowired
	private GuService guService;
	@Autowired
	private RenService renService;
	
	private Gu_info gu_info;
	private Ren_info ren_info;
	
	@RequestMapping("/")
	public String index() {
		System.out.println("test已进入...");
		return "suanming";
	}
	
	@RequestMapping(value = "/testv")
	public void Test(HttpServletResponse response, HttpSession session,Model model,String xing,String ming,String time,String date) {
		
		response.setCharacterEncoding("utf-8");
		System.out.println("user"+":"+xing+" "+ming+" "+time+" "+date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaZi lunar = new BaZi(cal, Integer.parseInt(time));
		
		System.out.println(lunar.toString()+""+lunar.getYearGanZhi()+""+lunar.animalsYear()+""+lunar.toZong());
		gu_info=guService.findByNo(lunar.toZongLiang());
		if (gu_info != null) {
			System.out.println("chadaole"+gu_info.getGu_content());
////			session.setAttribute("gu_info",gu_info);
//			model.addAttribute("gu_info",gu_info);
			}
			else{
				System.out.println("空了");
		}
		Ren renc=new Ren(xing,ming,date,time,lunar.toString(),lunar.getYearGanZhi(),lunar.animalsYear(),lunar.toZong(),gu_info.getGu_content());
		
		Gson gson =new Gson();
		String ren = null;
		ren=gson.toJson(renc,Ren.class);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		out.print(ren);
		
		renService.addRen(xing,ming,date,time,lunar.toString(),lunar.getYearGanZhi(),lunar.animalsYear(),lunar.toZong());
//		if()){
//			System.out.println("存了");
//		}else{
//			System.out.println("没存进去");
//		}
		
	}
}
