package io.appx.codelabs.jpa.repository.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.appx.codelabs.jpa.repository.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
    /*
     * See more examples here :
     * https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.
     * sample-app.finders.strategies
     */

    StudentEntity findByRollNo(String rollNo);

    List<StudentEntity> findByActiveTrue();

    // find-student by first-name
    List<StudentEntity> findByFirstName(String name);

    // find-student by last-name
    List<StudentEntity> findByLastName(String name);

    // find-student by first-name + last-name pair
    List<StudentEntity> findByFirstNameAndLastName(String firstName, String lastName);

    // find-student greater than given age
    List<StudentEntity> findByAgeGreaterThan(int age);

    // find-student by email-address
    List<StudentEntity> findByEmail(String email);

    // find-student with first-name starting with
    List<StudentEntity> findByFirstNameStartingWith(String term);

    // find-student with email-address containing
    List<StudentEntity> findByEmailContaining(String term);

    /* // find student with qualifying hsc-gpa (input from prop in service)
    @Query(value = "SELECT s FROM StudentEntity s WHERE s.qualification.hscGPA >= 3.5")
    List<StudentEntity> findStudentWithQualifyingHscGpa();

    // find student with qualifying ssc-gpa (input from prop in service)
    @Query(value = "SELECT s FROM StudentEntity s WHERE s.qualification.sscGPA >= 3.5")
    List<StudentEntity> findStudentWithQualifyingSscGpa();

    // find student with qualifying maths+science scores
    @Query(value = "SELECT * FROM student_tb0 s WHERE (s.ssc_maths + s.ssc_science) > 140", nativeQuery = true)
    List<StudentEntity> findStudentWithQualifyingMathsAndScienceScore(); */
}
