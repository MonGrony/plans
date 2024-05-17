package com.sparta.planner.controller;

import com.sparta.planner.dto.PlanRequestDto;
import com.sparta.planner.dto.PlanResponseDto;
import com.sparta.planner.entity.Plan;
import com.sparta.planner.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/plans")
    public PlanResponseDto createPlan(@RequestBody PlanRequestDto requestDto) {
        return planService.createPlan(requestDto);
    }

    //선택한 일정 정보 조회 (response 정보에 비밀번호 제외 = 내용)
    // 수정, 삭제시 선택한 일정의 비밀번호와 요청할 때 함께 보낸 비밀번호가 일치할 경우에만 가능합니다.
    @ExceptionHandler
    @GetMapping("plans/{id}")
    public PlanResponseDto findPlan(@RequestBody Long id) { //restfulApI 공부할 것!!
        return planService.findPlan(id); //contents 제외해야 하는데
    }

    //등록된 일정 전체 조회 (비밀번호 제외, 내림차순 정렬)
    @ExceptionHandler
    @GetMapping("plans/list")
    public List<PlanResponseDto> getPlans(String password) {
        return planService.getPlans(password);
    }

    //선택한 일정을 수정 (비밀번호 필요)//(수정된 일정 정보를 반환 받아 확인)
    @ExceptionHandler
    @PutMapping("plans/update/{id}")
    public Long updatePlan(@PathVariable Long id, @RequestBody PlanRequestDto requestDto){
        return id; //id 만 넘겨주기
    }

    //선택 일정 삭제
    @ExceptionHandler
    @DeleteMapping("/deleteplans/{id}")
    public Long deletePlan(@PathVariable Long id, @RequestBody PlanRequestDto requestDto) {
        return id;
    }

}
