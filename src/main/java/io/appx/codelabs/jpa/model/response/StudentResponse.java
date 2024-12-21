package io.appx.codelabs.jpa.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"roll_no", "first_name", "last_name", "email_address", "date_of_birth"})
public class StudentResponse {

    @JsonProperty("active")
    private boolean active;

    @JsonProperty("distinction")
    private boolean distinction;

    @JsonProperty("roll_no")
    private String rollNo;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonProperty("score_math")
    private float mathScore;

    @JsonProperty("score_science")
    private float scienceScore;

    private int age;

    private float gpa;
}
