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

    @AttributeOverride(name = "hscGPA", column = @Column(name = "hsc_gpa"))
    private float hscGPA;

    @AttributeOverride(name = "sscGPA", column = @Column(name = "ssc_gpa"))
    private float sscGPA;

    @AttributeOverride(name = "sscMaths", column = @Column(name = "ssc_maths", nullable = false))
    private float sscMaths;

    @AttributeOverride(name = "sscScience", column = @Column(name = "ssc_science", nullable = false))
    private float sscScience;

    @AttributeOverride(name = "sscEnglish", column = @Column(name = "ssc_english", nullable = false))
    private float sscEnglish;

    @AttributeOverride(name = "distinction", column = @Column(name = "distinction"))
    private boolean distinction;
}
