package ru.nnov.nntu.vst.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nnov.nntu.vst.demo.models.AssessmentType;
import ru.nnov.nntu.vst.demo.services.AssessmentTypeService;

import java.util.List;

@RestController
@RequestMapping("/api/assessment-types")
public class AssessmentTypeController {
	@Autowired
	private AssessmentTypeService assessmentTypeService;

	@PostMapping
	public ResponseEntity<AssessmentType> createAssessmentType(@RequestBody AssessmentType assessmentType) {
		AssessmentType createdAssessmentType = assessmentTypeService.createAssessmentType(assessmentType);
		return ResponseEntity.ok(createdAssessmentType);
	}

	@GetMapping("/{id}")
	public ResponseEntity<AssessmentType> getAssessmentTypeById(@PathVariable Long id) {
		AssessmentType assessmentType = assessmentTypeService.getAssessmentTypeById(id);
		return ResponseEntity.ok(assessmentType);
	}

	@GetMapping
	public ResponseEntity<List<AssessmentType>> getAllAssessmentTypes() {
		List<AssessmentType> assessmentTypes = assessmentTypeService.getAllAssessmentTypes();
		return ResponseEntity.ok(assessmentTypes);
	}

	@PutMapping("/{id}")
	public ResponseEntity<AssessmentType> updateAssessmentType(@PathVariable Long id, @RequestBody AssessmentType updatedAssessmentType) {
		AssessmentType assessmentType = assessmentTypeService.updateAssessmentType(id, updatedAssessmentType);
		return ResponseEntity.ok(assessmentType);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAssessmentType(@PathVariable Long id) {
		assessmentTypeService.deleteAssessmentType(id);
		return ResponseEntity.ok("Контроль с ID = " + id + " успешно удален");
	}
}
