package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "assessment_types")
public class AssessmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	public AssessmentType() {}

	public AssessmentType(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "AssessmentType{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
