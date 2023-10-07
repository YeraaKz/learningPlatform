package com.example.learningplatform.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class CourseDTO {

    private Long id;
    private String name;
    private String description;
    private int levelDifficulty;
    private Date dateCreated;
}
