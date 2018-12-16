package kr.ac.hansung.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	
	@NotEmpty(message="The subjectcode cannot be empty")
	private String subjectcode;

	@NotNull(message="The year cannot be empty")
	private int year;
	
	@NotNull(message="The semester cannot be empty")
	private int semester;
	
	@NotEmpty(message="The subject cannot be empty")
	private String subject;
	
	@NotEmpty(message="The division cannot be empty")
	private String division;
	
	@NotNull(message="The credit cannot be empty")
	private int credit;
}

