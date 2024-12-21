package io.appx.codelabs.jpa.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
    private int id;
    private int minimumAge;
    private int courseSerielNo;
    private int courseDuration;
    
    private String startDate;
    private String courseName;
    private String courseDescription;

    private boolean active;
}
