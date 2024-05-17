package com.sparta.planner.repository;

import com.sparta.planner.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {


    //선택

    //내림차순 전체리스트
    List<Plan> findAllByOrderByCreatedAtDesc();
}
