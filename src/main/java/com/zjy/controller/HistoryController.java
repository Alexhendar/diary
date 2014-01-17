package com.zjy.controller;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjy.controller.binder.DateEditor;
import com.zjy.domain.Diary;
import com.zjy.service.DiaryService;
import com.zjy.utils.DateUtils;

@Controller
public class HistoryController {
	final Logger logger = LoggerFactory.getLogger(HistoryController.class);
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping(value="/history",method=RequestMethod.GET)
	public String history(Integer page,ModelMap model){
		if(page == null){
			page = 0;
		}
		Page<Diary> pageDiary = diaryService.listDiaryByPage(page, 20);
		// 初始化开始时间和结束时间为当前日期
		String startDate = "";
		String endDate = startDate;
		Calendar date =Calendar.getInstance();
		try {
			endDate = DateUtils.format(date.getTime(), DateUtils.DateFormat);
			date.set(Calendar.DATE, date.get(Calendar.DATE) -7);
			startDate = DateUtils.format(date.getTime(), DateUtils.DateFormat);
		} catch (ParseException e) {
			logger.error("日期格式转换错误{}",e);
		}
		model.addAttribute("startDate", startDate);
		model.addAttribute("endDate", endDate);
		
		model.addAttribute("page", pageDiary);
		return "history";
	}
	@RequestMapping(value="/history",method=RequestMethod.POST)
	public String history(Date startDate,Date endDate,ModelMap model){
		Page<Diary> pageDiary = diaryService.listDiaryByPage(startDate,endDate,0, 20);
		for(Diary diary:pageDiary.getContent()){
			logger.info("日记标题是{}", diary.getTitle());
		}
		try {
			model.addAttribute("startDate", DateUtils.format(startDate, DateUtils.DateFormat));
			model.addAttribute("endDate", DateUtils.format(endDate, DateUtils.DateFormat));
		} catch (ParseException e) {
			logger.error("日期格式转换错误{}",e);
		}
		model.addAttribute("page", pageDiary);
		return "history";
	}
	@InitBinder
	protected void initBinder(HttpServletRequest request,  
	                              ServletRequestDataBinder binder) throws Exception {  
	    //对于需要转换为Date类型的属性，使用DateEditor进行处理  
	    binder.registerCustomEditor(Date.class, new DateEditor());  
	} 
}
