package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.dto.AssessmentTypeDTO;
import ru.nnov.nntu.vst.demo.models.AssessmentType;
import ru.nnov.nntu.vst.demo.repository.AssessmentTypeRepository;

import java.util.List;

@Service
public class AssessmentTypeService {
	@Autowired
	private AssessmentTypeRepository assessmentTypeRepository;

	public AssessmentType createAssessmentTypeFromDTO(AssessmentTypeDTO assessmentTypeDTO) {
		AssessmentType assessmentType = new AssessmentType();
		assessmentType.setName(assessmentTypeDTO.getName());
		return assessmentTypeRepository.save(assessmentType);
	}

	public AssessmentType getAssessmentTypeById(Long id) {
		return assessmentTypeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Дисциплина с ID = " + id + " не найдена"));
	}

	public List<AssessmentType> getAllAssessmentTypes() {
		return assessmentTypeRepository.findAll();
	}

	public AssessmentType updateAssessmentType(Long id, AssessmentType updatedAssessmentType) {
		AssessmentType assessmentType = getAssessmentTypeById(id);
		assessmentType.setName(updatedAssessmentType.getName());
		return assessmentTypeRepository.save(assessmentType);
	}

	public void deleteAssessmentType(Long id) {
		assessmentTypeRepository.deleteById(id);
	}
}
