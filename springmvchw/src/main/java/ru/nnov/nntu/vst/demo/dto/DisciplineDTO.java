package ru.nnov.nntu.vst.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class DisciplineDTO {
	private String name;
	private String description;
	private Set<Long> requiredSkills;
	private Set<Long> outcomes;
	private Set<Long> workTypes;
	private Set<Long> assessments;
}
