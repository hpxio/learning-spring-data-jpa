package io.appx.codelabs.jpa.model.response.builder;

import org.springframework.stereotype.Component;

import io.appx.codelabs.jpa.model.response.StudentResponse;
import io.appx.codelabs.jpa.repository.entity.Qualification;
import io.appx.codelabs.jpa.repository.entity.StudentEntity;

@Component
public class StudentResponseBuilder implements ResponseBuilder<StudentEntity, StudentResponse> {

    @Override
    public StudentResponse build(StudentEntity request) {
        StudentResponse studentResponse = new StudentResponse();
        Qualification qualification = request.getQualification();

        studentResponse.setAge(request.getAge());
        studentResponse.setActive(request.isActive());
        studentResponse.setRollNo(request.getRollNo());
        studentResponse.setLastName(request.getLastName());
        studentResponse.setFirstName(request.getFirstName());
        studentResponse.setEmailAddress(request.getEmail());
        studentResponse.setDateOfBirth(request.getDateOfBirth());
        
        studentResponse.setGpa(qualification.getGpa());
        studentResponse.setMathScore(qualification.getMathScore());
        studentResponse.setScienceScore(qualification.getScienceScore());
        studentResponse.setDistinction(qualification.isDistinction());
        
        return studentResponse;
    }
    
}
