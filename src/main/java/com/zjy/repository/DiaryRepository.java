package com.zjy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.zjy.domain.Diary;

@Repository
public interface DiaryRepository extends JpaSpecificationExecutor<Diary>, JpaRepository<Diary, Long> {
}
