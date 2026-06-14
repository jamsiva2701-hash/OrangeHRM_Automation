package com.orangehrm.pojo.addemployee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployee_Input_Pojo {
	private String firstName;
	private String lastName;
	private String employeeId;
	private String jobTitle;
	private String employmentStatus;

}