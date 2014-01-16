package com.zjy.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjy.domain.Diary;
import com.zjy.service.DiaryService;

@Controller
public class HistoryController {
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping(value="/history",method=RequestMethod.GET)
	public String history(Integer page,ModelMap model){
		if(page == null){
			page = 0;
		}
		Page<Diary> pageDiary = diaryService.listDiaryByPage(page, 20);
		model.addAttribute("page", pageDiary);
		return "history";
	}
	@RequestMapping(value="/history",method=RequestMethod.POST)
	public String history(Date startDate,Date endDate,ModelMap model){
		Page<Diary> pageDiary = diaryService.listDiaryByPage(startDate,endDate,0, 20);
		model.addAttribute("page", pageDiary);
		return "history";
	}
}
