package io.appx.codelabs.jpa.service;

import io.appx.codelabs.jpa.model.request.StudentRequest;
import io.appx.codelabs.jpa.model.response.StudentResponse;

public interface StudentProfileService {
    StudentResponse createStudent(StudentRequest request);
}
