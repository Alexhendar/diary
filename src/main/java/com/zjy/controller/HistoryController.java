package com.zjy.controller;

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
	public String history(ModelMap model){
		Page<Diary> page = diaryService.listDiaryByPage(0, 20);
		model.addAttribute("page", page);
		return "history";
	}
}
