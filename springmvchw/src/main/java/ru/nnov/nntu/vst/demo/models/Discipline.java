package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "disciplines")
@Getter
@Setter
public class Discipline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name; // Название дисциплины

	@Column(name = "description")
	private String description; // Описание дисциплины

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

	// Связь с таблицей Discipline_Assessments (типы контроля)
	@ManyToMany
	@JoinTable(
			name = "discipline_assessments",
			joinColumns = @JoinColumn(name = "discipline_id"),
			inverseJoinColumns = @JoinColumn(name = "assessment_type_id")
	)

	private Set<AssessmentType> assessments = new HashSet<>();

	public Discipline() {}

	public Discipline(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Discipline{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}