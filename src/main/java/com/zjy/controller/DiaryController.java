package com.zjy.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjy.domain.Diary;
import com.zjy.service.DiaryService;

@Controller
public class DiaryController {
	final Logger logger = LoggerFactory.getLogger(DiaryController.class);
	@Autowired
	private DiaryService diaryService;
	
	@RequestMapping(value="/recordDiary",method=RequestMethod.POST)
	public String recordDiary(@ModelAttribute Diary diary){
		if(diary != null){
			diaryService.save(diary);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/view/{diaryID}",method=RequestMethod.GET)
	public String viewDiary(@PathVariable(value="diaryID") String diaryID,ModelMap model){
		if(logger.isInfoEnabled()){
			logger.info("查找ID为：%s的日记",diaryID);
		}
		if(StringUtils.isNumeric(diaryID)){
			Long id = Long.parseLong(diaryID);
			Diary diary = diaryService.findDiaryByID(id);
			model.addAttribute("diary", diary);
			return "diary";
		}
		return "redirect:/history";
	}
}
