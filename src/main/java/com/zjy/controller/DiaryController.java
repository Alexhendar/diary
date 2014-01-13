package com.zjy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjy.domain.Diary;
import com.zjy.service.DiaryService;

@Controller
public class DiaryController {
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping(value="/recordDiary",method=RequestMethod.POST)
	public String recordDiary(@ModelAttribute Diary diary){
		if(diary != null){
			diaryService.save(diary);
		}
		return "redirect:/";
	}
}
