package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.models.AssessmentType;
import ru.nnov.nntu.vst.demo.repository.AssessmentTypeRepository;

import java.util.List;

@Service
public class AssessmentTypeService {
	@Autowired
	private AssessmentTypeRepository assessmentTypeRepository;

	public AssessmentType createDiscipline(AssessmentType assessmentType) {
		return assessmentTypeRepository.save(assessmentType);
	}

	public AssessmentType getDisciplineById(Long id) {
		return assessmentTypeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Дисциплина с ID = " + id + " не найдена"));
	}

	public List<AssessmentType> getAllDisciplines() {
		return assessmentTypeRepository.findAll();
	}

	public AssessmentType updateDiscipline(Long id, AssessmentType updatedAssessmentType) {
		AssessmentType assessmentType = getDisciplineById(id);
		assessmentType.setName(updatedAssessmentType.getName());
		return assessmentTypeRepository.save(assessmentType);
	}

	public void deleteDiscipline(Long id) {
		assessmentTypeRepository.deleteById(id);
	}
}
