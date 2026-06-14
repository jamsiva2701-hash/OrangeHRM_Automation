package com.orangehrm.pojo.addemployee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddEmployee_Output_Pojo {

	private String firstName;
	private String lastName;
	private String employeeId;
	private String jobTitle;
	private String employmentStatus;
	private String id;
	private String createdAt;

}