package io.appx.codelabs.jpa.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import io.appx.codelabs.jpa.model.request.StudentRequest;
import io.appx.codelabs.jpa.model.request.builder.RequestBuilder;
import io.appx.codelabs.jpa.model.request.builder.RequestMerger;
import io.appx.codelabs.jpa.model.response.StudentResponse;
import io.appx.codelabs.jpa.model.response.builder.ResponseBuilder;
import io.appx.codelabs.jpa.repository.dao.StudentRepository;
import io.appx.codelabs.jpa.repository.entity.StudentEntity;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentRepository repository;

    private final RequestBuilder<StudentRequest, StudentEntity> requestBuilder;

    private final ResponseBuilder<StudentEntity, StudentResponse> responseBuilder;

    private final RequestMerger<StudentRequest, StudentEntity, StudentEntity> requestMerger;

    public StudentProfileServiceImpl(StudentRepository repository,
            RequestBuilder<StudentRequest, StudentEntity> requestBuilder,
            ResponseBuilder<StudentEntity, StudentResponse> responseBuilder,
            RequestMerger<StudentRequest, StudentEntity, StudentEntity> requestMerger) {
        this.repository = repository;
        this.requestBuilder = requestBuilder;
        this.responseBuilder = responseBuilder;
        this.requestMerger = requestMerger;
    }

    @Override
    @Transactional
    public StudentResponse createStudent(StudentRequest request) {
        log.info("Creating student profile for : {}", request.getFirstName());
        StudentEntity studentEntity = requestBuilder.build(request);

        log.info("Saving profile with Roll No. : {}", studentEntity.getRollNo());
        StudentEntity savedData = repository.save(studentEntity);
        return responseBuilder.build(savedData);
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(String rollNo, StudentRequest request) {
        /* first identify if given rollNo exists in db */
        StudentEntity exists = repository.findByRollNo(rollNo);

        if (Objects.nonNull(exists)) {
            log.info("Student profile found, updating : {}", rollNo);
            StudentEntity entity = requestMerger.merge(request, exists);

            StudentEntity savedData = repository.save(entity);
            return responseBuilder.build(savedData);
        } else {
            log.error("Roll number <{}> does not exists", rollNo);
            throw new RuntimeException("Roll number does not exist!");
        }
    }

}
