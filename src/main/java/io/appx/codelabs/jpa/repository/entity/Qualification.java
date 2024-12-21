package io.appx.codelabs.jpa.repository.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Qualification {

    @AttributeOverride(name = "gpa", column = @Column(name = "gpa"))
    private float gpa;

    @AttributeOverride(name = "mathScore", column = @Column(name = "score_math", nullable = false))
    private float mathScore;

    @AttributeOverride(name = "scienceScore", column = @Column(name = "score_science", nullable = false))
    private float scienceScore;

    @AttributeOverride(name = "distinction", column = @Column(name = "distinction"))
    private boolean distinction;
}
