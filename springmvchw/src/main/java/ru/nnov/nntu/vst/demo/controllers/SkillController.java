package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.vst.demo.models.Skill;
import ru.nnov.nntu.vst.demo.services.SkillService;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {
	@Autowired
	private SkillService skillService;

	@GetMapping
	public List<Skill> getAllSkills() {
		return skillService.getAllSkills();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Skill> getSkillById(@PathVariable Long id) {
		return skillService.getSkillById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping
	public Skill createSkill(@RequestBody Skill skill) {
		return skillService.createSkill(skill);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Skill> updateSkill(@PathVariable Long id, @RequestBody Skill updatedSkill) {
		try {
			Skill skill = skillService.updateSkill(id, updatedSkill);
			return ResponseEntity.ok(skill);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSkill(@PathVariable Long id) {
		skillService.deleteSkill(id);
		return ResponseEntity.noContent().build();
	}
}
