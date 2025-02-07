package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.vst.demo.dto.DisciplineDTO;
import ru.nnov.nntu.vst.demo.models.Discipline;
import ru.nnov.nntu.vst.demo.services.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api/disciplines")
public class DisciplineController {
	@Autowired
	private DisciplineService disciplineService;

	/*@PostMapping
	public ResponseEntity<Discipline> createDiscipline(@RequestBody Discipline discipline) {
		Discipline createdDiscipline = disciplineService.createDiscipline(discipline);
		return new ResponseEntity<>(createdDiscipline, HttpStatus.CREATED);
	}*/

	@PostMapping
	public ResponseEntity<Discipline> createDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
		Discipline createdDiscipline = disciplineService.createDisciplineFromDTO(disciplineDTO);
		return new ResponseEntity<>(createdDiscipline, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Discipline> getDisciplineById(@PathVariable Long id) {
		Discipline discipline = disciplineService.getDisciplineById(id);
		return ResponseEntity.ok(discipline);
	}

	@GetMapping
	public ResponseEntity<List<Discipline>> getAllDisciplines() {
		List<Discipline> disciplines = disciplineService.getAllDisciplines();
		return ResponseEntity.ok(disciplines);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Discipline> updateDiscipline(@PathVariable Long id, @RequestBody DisciplineDTO updatedDisciplineDTO) {
		Discipline discipline = disciplineService.updateDiscipline(id, updatedDisciplineDTO);
		return ResponseEntity.ok(discipline);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDiscipline(@PathVariable Long id) {
		disciplineService.deleteDiscipline(id);
		return ResponseEntity.ok("Дисциплина с ID = " + id + " успешно удалена");
	}
}
