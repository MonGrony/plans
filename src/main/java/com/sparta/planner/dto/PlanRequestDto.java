package com.sparta.planner.dto;

import com.sparta.planner.entity.Plan;
import lombok.Getter;

@Getter
public class PlanRequestDto {

    private Long id;

    private String title;
    private String contents;
    private String manager;

    private String password;

    public PlanRequestDto(Plan plan) {
        this.id = plan.getId();
        this.title = plan.getTitle();
        this.contents = plan.getContents();
        this.manager = plan.getManager();

        this.password = plan.getPassword();
    }
}
