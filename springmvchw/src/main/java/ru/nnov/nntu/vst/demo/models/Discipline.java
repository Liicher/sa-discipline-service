package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disciplines")
public class Discipline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description")
	private String description;

	// Связь с таблицей Discipline_Requirements (требуемые навыки)
	@ManyToMany
	@JoinTable(
			name = "discipline_requirements",
			joinColumns = @JoinColumn(name = "discipline_id"),
			inverseJoinColumns = @JoinColumn(name = "skill_id")
	)
	private Set<Skill> requiredSkills = new HashSet<>();

	// Связь с таблицей Discipline_Outcomes (формируемые навыки)
	@ManyToMany
	@JoinTable(
			name = "discipline_outcomes",
			joinColumns = @JoinColumn(name = "discipline_id"),
			inverseJoinColumns = @JoinColumn(name = "skill_id")
	)
	private Set<Skill> outcomes = new HashSet<>();

	// Связь с таблицей Discipline_Work_Types (виды работ)
	@ManyToMany
	@JoinTable(
			name = "discipline_work_types",
			joinColumns = @JoinColumn(name = "discipline_id"),
			inverseJoinColumns = @JoinColumn(name = "work_type_id")
	)
	private Set<WorkType> workTypes = new HashSet<>();

	// Связь с таблицей Discipline_Assessments (тип контроля)
	@ManyToOne
	@JoinColumn(name = "assessment_type_id")
	private AssessmentType assessment;

	public Discipline() {}

	public Discipline(String name, String description) {
		this.name = name;
		this.description = description;
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

	@Override
	public String toString() {
		return "Discipline{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", requiredSkills=" + requiredSkills +
				", outcomes=" + outcomes +
				", workTypes=" + workTypes +
				", assessment=" + assessment +
				'}';
	}
}