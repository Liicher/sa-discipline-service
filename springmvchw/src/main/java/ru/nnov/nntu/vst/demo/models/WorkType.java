package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "work_types")
@Getter
@Setter
public class WorkType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name; // Название типа работы

	public WorkType() {}

	public WorkType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "WorkType{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
