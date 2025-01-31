package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.models.AssessmentType;
import ru.nnov.nntu.vst.demo.models.WorkType;
import ru.nnov.nntu.vst.demo.repository.WorkTypeRepository;

import java.util.List;

@Service
public class WorkTypeService {
	@Autowired
	private WorkTypeRepository workTypeRepository;

	public WorkType createDiscipline(WorkType workType) {
		return workTypeRepository.save(workType);
	}

	public WorkType getDisciplineById(Long id) {
		return workTypeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Дисциплина с ID = " + id + " не найдена"));
	}

	public List<WorkType> getAllDisciplines() {
		return workTypeRepository.findAll();
	}

	public WorkType updateDiscipline(Long id, WorkType updatedWorkType) {
		WorkType workType = getDisciplineById(id);
		workType.setName(updatedWorkType.getName());
		return workTypeRepository.save(workType);
	}

	public void deleteDiscipline(Long id) {
		workTypeRepository.deleteById(id);
	}
}
