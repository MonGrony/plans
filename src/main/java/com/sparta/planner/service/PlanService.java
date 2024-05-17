package com.sparta.planner.service;

import com.sparta.planner.dto.PlanRequestDto;
import com.sparta.planner.dto.PlanResponseDto;
import com.sparta.planner.entity.Plan;
import com.sparta.planner.repository.PlanRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {
    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) { //생성자 초기화
        this.planRepository = planRepository;

    }
    public PlanResponseDto createPlan(PlanRequestDto requestDto) {

        Plan plan = new Plan(requestDto);
        Plan savePlan = planRepository.save(plan); //JPA 기본 메서드 save
        PlanResponseDto planResponseDto = new PlanResponseDto(savePlan);
        return planResponseDto;
    }

    //선택 일정 조회 메서드
    public PlanResponseDto findPlan(Long id) {
        Plan plan = findById(id);//optional 공부
        PlanResponseDto planResponseDto = new PlanResponseDto(plan);
        return planResponseDto;
    }

    //전체 일정 조회 메서드//비밀번호 제외시켜야 함
    public List<PlanResponseDto> getPlans(String password) {
        return planRepository.findAllByOrderByCreatedAtDesc().stream().map(PlanResponseDto::new).toList();
    }

    //선택한 일정 수정(비밀번호 필요)
    @Transactional
    public Long updatePlan(Long id, PlanRequestDto requestDto) {
        // 해당 plan이 DB에 존재하는지 확인 // plan 내용 수정
        Plan plan = findById(id);
        if (requestDto.getPassword().equals(plan.getPassword())) {
            plan.update(requestDto);
        }
        return id;
    }

    //선택한 일정 삭제 (비밀번호 필요)
    public Long deletePlan(Long id, PlanRequestDto requestDto) {
        // 해당 plan 이 DB에 존재하는지 확인
        Plan plan = findById(id);
        // plan 삭제
        if (plan.getPassword().equals(requestDto.getPassword())) {

            planRepository.delete(plan);
        }
        return id;
    }

    private Plan findById(Long id) {
        return planRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 메모는 존재하지 않습니다.")
        );
    }


}
