package ru.nnov.nntu.vst.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name; // Название навыка

	@Column(name = "type", nullable = false)
	private String type; // Тип навыка (знание, умение, навык)

	public Skill() {}

	public Skill(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Skill{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				'}';
	}
}
