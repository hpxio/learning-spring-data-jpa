package io.appx.codelabs.jpa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.appx.codelabs.jpa.model.request.StudentRequest;
import io.appx.codelabs.jpa.model.response.StudentResponse;
import io.appx.codelabs.jpa.service.StudentProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentProfileService service;

    public StudentController(StudentProfileService service) {
        this.service = service;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createStudent(@RequestBody StudentRequest request) {
        log.info("Create student profile request received");
        StudentResponse response = service.createStudent(request);

        log.info("Student created successfully : {}", response.getRollNo());
        return response;
    }

    @PutMapping("update/{rollNo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public StudentResponse updateStudent(@PathVariable String rollNo, @RequestBody StudentRequest request) {
        log.info("Update student profile request received");
        StudentResponse response = service.updateStudent(rollNo, request);

        log.info("Student updated successfully : {}", response.getRollNo());
        return response;
    }
}
