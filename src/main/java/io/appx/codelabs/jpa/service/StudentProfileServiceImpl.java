package io.appx.codelabs.jpa.service;

import org.springframework.stereotype.Service;

import io.appx.codelabs.jpa.model.request.StudentRequest;
import io.appx.codelabs.jpa.model.request.builder.RequestBuilder;
import io.appx.codelabs.jpa.model.response.StudentResponse;
import io.appx.codelabs.jpa.model.response.builder.ResponseBuilder;
import io.appx.codelabs.jpa.repository.dao.StudentRepository;
import io.appx.codelabs.jpa.repository.entity.StudentEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentRepository repository;

    private final RequestBuilder<StudentRequest, StudentEntity> requestBuilder;

    private final ResponseBuilder<StudentEntity, StudentResponse> responseBuilder;

    public StudentProfileServiceImpl(StudentRepository repository,
            RequestBuilder<StudentRequest, StudentEntity> requestBuilder,
            ResponseBuilder<StudentEntity, StudentResponse> responseBuilder) {
        this.repository = repository;
        this.requestBuilder = requestBuilder;
        this.responseBuilder = responseBuilder;
    }

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        log.info("Creating student profile for : {}", request.getFirstName());
        StudentEntity studentEntity = requestBuilder.build(request);

        log.info("Saving profile with Roll No. : {}", studentEntity.getRollNo());
        StudentEntity savedData = repository.save(studentEntity);
        return responseBuilder.build(savedData);
    }

}
