package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.vst.demo.models.WorkType;
import ru.nnov.nntu.vst.demo.services.WorkTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/work-types")
public class WorkTypeController {
	@Autowired
	private WorkTypeService workTypeService;

	@GetMapping
	public List<WorkType> getAllSWorkTypes() {
		return workTypeService.getAllWorkTypes();
	}

	@GetMapping("/{id}")
	public ResponseEntity<WorkType> getWorkTypeById(@PathVariable Long id) {
		try {
			WorkType workType = workTypeService.getWorkTypeById(id);
			return ResponseEntity.ok(workType);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<WorkType> createWorkType(@RequestBody WorkType workType) {
		WorkType createdWorkType = workTypeService.createWorkType(workType);
		return ResponseEntity.ok(createdWorkType);
	}

	@PutMapping("/{id}")
	public ResponseEntity<WorkType> updateWorkType(@PathVariable Long id, @RequestBody WorkType updatedWorkType) {
		try {
			WorkType workType = workTypeService.updateWorkType(id, updatedWorkType);
			return ResponseEntity.ok(workType);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteWorkType(@PathVariable Long id) {
		workTypeService.deleteWorkType(id);
		return ResponseEntity.ok("Тип работ с ID = " + id + " успешно удален");
	}
}
