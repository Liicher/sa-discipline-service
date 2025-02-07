package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.models.Skill;
import ru.nnov.nntu.vst.demo.repository.SkillRepository;

import java.util.List;

@Service
public class SkillService {
	@Autowired
	private SkillRepository skillRepository;

	public List<Skill> getAllSkills() {
		return skillRepository.findAll();
	}

	public Skill getSkillById(Long id) {
		return skillRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("WorkType с ID = " + id + " не найдена"));
	}

	public Skill createSkill(Skill skill) {
		return skillRepository.save(skill);
	}

	public Skill updateSkill(Long id, Skill updatedSkill) {
		return skillRepository.findById(id).map(skill -> {
			skill.setName(updatedSkill.getName());
			skill.setType(updatedSkill.getType());
			return skillRepository.save(skill);
		}).orElseThrow(() -> new RuntimeException("Skill not found with id " + id));
	}

	public void deleteSkill(Long id) {
		skillRepository.deleteById(id);
	}
}
