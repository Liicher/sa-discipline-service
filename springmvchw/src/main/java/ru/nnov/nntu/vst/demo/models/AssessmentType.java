package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "assessment_types")
@Getter
@Setter
public class AssessmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name; // Название типа контроля

	public AssessmentType() {}

	public AssessmentType(String name) {
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
