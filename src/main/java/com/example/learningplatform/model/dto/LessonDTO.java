package com.example.learningplatform.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LessonDTO {

    private Long id;
    private String title;
    private String description;
    private String content;
    private String lesson_order;
    private String videoUrl;
}
