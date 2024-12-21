package io.appx.codelabs.jpa.repository.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_tb0")
public class StudentEntity {

    @Id
    @Column(name = "0id")
    @SequenceGenerator(name = "student_seq0", sequenceName = "student_seq0", initialValue = 10000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq0")
    private int id;

    @Column(name = "0roll_no", unique = true)
    private String rollNo;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", unique = true)
    private String email;

    @Column(name = "graduation", nullable = false)
    private String graduation;

    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @Column(name = "age", nullable = false)
    private int age;

    @Column(name = "active")
    private boolean active;

    @Embedded
    private Qualification qualification;

    /* private CourseEntity course; */
}
