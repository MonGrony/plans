package com.sparta.planner.entity;

import com.sparta.planner.dto.PlanRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Table(name = "plan") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Plan extends TimeStamped { // 상속받았으므로 timestamped 멤버/메서드 가짐
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //할 일 제목
    @Column(name = "title", nullable = false)
    private String title;

    //할 일 내용
    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    //담당자
    @Column(name = "manager", nullable = false)
    private String manager;

    //비밀번호
    @Column(name = "password", nullable = false)
    private String password;

    //작성일 - 상속받았으므로 따로 작성할 필요 없음

    public Plan(PlanRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
        this.password = requestDto.getPassword();
    }

    public void update(PlanRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.manager = requestDto.getManager();
    }

}
