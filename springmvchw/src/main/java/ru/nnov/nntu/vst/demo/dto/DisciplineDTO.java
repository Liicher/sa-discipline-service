package ru.nnov.nntu.vst.demo.dto;

import ru.nnov.nntu.vst.demo.models.AssessmentType;
import ru.nnov.nntu.vst.demo.models.Skill;
import ru.nnov.nntu.vst.demo.models.WorkType;

import java.util.Set;

public class DisciplineDTO {
	private Long id;
	private String name;
	private String description;
	private Set<Skill> requiredSkills;
	private Set<Skill> outcomes;
	private Set<WorkType> workTypes;
	private AssessmentType assessment;

	public DisciplineDTO() {
	}

	public DisciplineDTO(Long id, String name, String description, Set<Skill> requiredSkills, Set<Skill> outcomes, Set<WorkType> workTypes, AssessmentType assessment) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.requiredSkills = requiredSkills;
		this.outcomes = outcomes;
		this.workTypes = workTypes;
		this.assessment = assessment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Skill> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(Set<Skill> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public Set<Skill> getOutcomes() {
		return outcomes;
	}

	public void setOutcomes(Set<Skill> outcomes) {
		this.outcomes = outcomes;
	}

	public Set<WorkType> getWorkTypes() {
		return workTypes;
	}

	public void setWorkTypes(Set<WorkType> workTypes) {
		this.workTypes = workTypes;
	}

	public AssessmentType getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentType assessment) {
		this.assessment = assessment;
	}
}
