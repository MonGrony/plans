package com.sparta.planner.dto;

import com.sparta.planner.entity.Plan;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PlanResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String manager;

    private LocalDateTime createdAt;

    public PlanResponseDto(Plan plan) {
        this.id = plan.getId();
        this.title = plan.getTitle();
        this.contents = plan.getContents();
        this.manager = plan.getManager();

        this.createdAt = plan.getCreatedAt();
    }
}
