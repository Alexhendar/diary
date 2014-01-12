package com.zjy.service;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjy.domain.Diary;
import com.zjy.repository.DiaryRepository;

@Service
public class DiaryService {
	@Autowired
	private DiaryRepository diaryRepository;
	
	@Transactional
	public void save(Diary diary){
		diary.setDate(Calendar.getInstance().getTime());
		diaryRepository.save(diary);
	}
}
