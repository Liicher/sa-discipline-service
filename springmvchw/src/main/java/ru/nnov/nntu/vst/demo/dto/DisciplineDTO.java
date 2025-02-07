package ru.nnov.nntu.vst.demo.dto;

import java.util.Set;

public class DisciplineDTO {
	private Long id;
	private String name;
	private String description;
	private Set<Long> requiredSkillIds;
	private Set<Long> outcomeIds;
	private Set<Long> workTypeIds;
	private Long assessmentTypeId;

	public DisciplineDTO() {
	}

	public DisciplineDTO(Long id, String name, String description, Set<Long> requiredSkillIds, Set<Long> outcomeIds, Set<Long> workTypeIds, Long assessmentTypeId) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.requiredSkillIds = requiredSkillIds;
		this.outcomeIds = outcomeIds;
		this.workTypeIds = workTypeIds;
		this.assessmentTypeId = assessmentTypeId;
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

	public Set<Long> getRequiredSkillIds() {
		return requiredSkillIds;
	}

	public void setRequiredSkillIds(Set<Long> requiredSkillIds) {
		this.requiredSkillIds = requiredSkillIds;
	}

	public Set<Long> getOutcomeIds() {
		return outcomeIds;
	}

	public void setOutcomeIds(Set<Long> outcomeIds) {
		this.outcomeIds = outcomeIds;
	}

	public Set<Long> getWorkTypeIds() {
		return workTypeIds;
	}

	public void setWorkTypeIds(Set<Long> workTypeIds) {
		this.workTypeIds = workTypeIds;
	}

	public Long getAssessmentTypeId() {
		return assessmentTypeId;
	}

	public void setAssessmentTypeId(Long assessmentTypeId) {
		this.assessmentTypeId = assessmentTypeId;
	}
}
