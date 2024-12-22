package io.appx.codelabs.jpa.model.request.builder;

import org.springframework.stereotype.Component;

import io.appx.codelabs.jpa.model.request.StudentRequest;
import io.appx.codelabs.jpa.repository.entity.Qualification;
import io.appx.codelabs.jpa.repository.entity.StudentEntity;
import io.appx.codelabs.jpa.util.RollNoGenerator;

@Component
public class StudentCreateRequesttBuilder implements RequestBuilder<StudentRequest, StudentEntity> {

    private static final float DISTINCTION_CUTOFF = 150.0f;

    @Override
    public StudentEntity build(StudentRequest request) {
        StudentEntity studentEntity = new StudentEntity();
        Qualification qualification = new Qualification();

        studentEntity.setActive(true);
        studentEntity.setAge(request.getAge());
        studentEntity.setLastName(request.getLastName());
        studentEntity.setFirstName(request.getFirstName());
        studentEntity.setEmail(request.getEmailAddress());
        studentEntity.setDateOfBirth(request.getDateOfBirth());
        studentEntity.setRollNo(RollNoGenerator.generateId());

        qualification.setGpa(request.getGpa());
        qualification.setMathScore(request.getMathScore());
        qualification.setScienceScore(request.getScienceScore());
        qualification.setDistinction(isDistinction(request.getMathScore(), request.getScienceScore()));

        studentEntity.setQualification(qualification);
        return studentEntity;
    }

    private boolean isDistinction(float mathScore, float scienceScore) {
        return !(DISTINCTION_CUTOFF > (mathScore + scienceScore));
    }
}
