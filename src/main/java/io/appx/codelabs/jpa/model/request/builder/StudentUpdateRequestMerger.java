package io.appx.codelabs.jpa.model.request.builder;

import org.springframework.stereotype.Component;

import io.appx.codelabs.jpa.model.request.StudentRequest;
import io.appx.codelabs.jpa.repository.entity.StudentEntity;
import io.micrometer.common.util.StringUtils;

@Component
public class StudentUpdateRequestMerger implements RequestMerger<StudentRequest, StudentEntity, StudentEntity> {

    private static final float DISTINCTION_CUTOFF = 150.0f;

    @Override
    public StudentEntity merge(StudentRequest req1, StudentEntity req2) {

        if (StringUtils.isNotEmpty(req1.getFirstName()))
            req2.setFirstName(req1.getFirstName());

        if (StringUtils.isNotEmpty(req1.getLastName()))
            req2.setLastName(req1.getLastName());

        if (StringUtils.isNotEmpty(req1.getEmailAddress()))
            req2.setEmail(req1.getEmailAddress());

        if (StringUtils.isNotEmpty(req1.getDateOfBirth()))
            req2.setDateOfBirth(req1.getDateOfBirth());

        if (0 != req1.getAge())
            req2.setAge(req1.getAge());

        if (0f != req1.getGpa())
            req2.getQualification().setGpa(req1.getGpa());

        if (0f != req1.getMathScore())
            req2.getQualification().setMathScore(req1.getMathScore());

        if (0f != req1.getScienceScore())
            req2.getQualification().setScienceScore(req1.getScienceScore());

        req2.getQualification().setDistinction(
                isDistinction(req2.getQualification().getMathScore(), req2.getQualification().getScienceScore()));

        return req2;
    }

    private boolean isDistinction(float mathScore, float scienceScore) {
        return !(DISTINCTION_CUTOFF > (mathScore + scienceScore));
    }

}
