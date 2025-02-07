package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "work_types")
public class WorkType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	public WorkType() {}

	public WorkType(String name) {
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
		return "WorkType{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
