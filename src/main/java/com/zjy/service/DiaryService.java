package com.zjy.service;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zjy.domain.Diary;
import com.zjy.repository.DiaryRepository;

@Service
public class DiaryService {
	@Autowired
	private DiaryRepository diaryRepository;

	@Transactional
	public void save(Diary diary) {
		diary.setDate(Calendar.getInstance().getTime());
		diaryRepository.save(diary);
	}

	/**
	 * 
	 * \brief listDiaryByPage根据条件分页查询日记
	 * @param startTime
	 * @param endTime
	 * @param start
	 * @param size
	 * @return
	 * @attention 方法的使用注意事项 
	 * @author zhangjunyong
	 * @date 2014年1月13日 
	 */
	public Page<Diary> listDiaryByPage(final Date startTime,final Date endTime,int start,int size){
		
		 
		return diaryRepository.findAll(new Specification<Diary>() {
			@Override
			public Predicate toPredicate(Root<Diary> root, CriteriaQuery<?> query,
					CriteriaBuilder cb) {
				root = query.from(Diary.class);
				Path<Date> date = root.get("date");
				return cb.between(date, startTime, endTime);
			}
		},  new PageRequest(start, size, new Sort(Direction.DESC, new String[] { "date" })));
	}
	/**
	 * 
	 * \brief listDiaryByPage 分页查询日记  
	 * @param start
	 * @param size
	 * @return
	 * @attention 方法的使用注意事项 
	 * @author zhangjunyong
	 * @date 2014年1月13日 
	 * @note  begin modify by 修改人 修改时间   修改内容摘要说明
	 */
	public Page<Diary> listDiaryByPage(int start,int size){
		return diaryRepository.findAll(new PageRequest(start, size, new Sort(Direction.DESC, new String[] { "date" })));
	}
}
