package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.models.WorkType;
import ru.nnov.nntu.vst.demo.repository.WorkTypeRepository;

import java.util.List;

@Service
public class WorkTypeService {
	@Autowired
	private WorkTypeRepository workTypeRepository;

	public WorkType createWorkType(WorkType workType) {
		return workTypeRepository.save(workType);
	}

	public WorkType getWorkTypeById(Long id) {
		return workTypeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("WorkType с ID = " + id + " не найдена"));
	}

	public List<WorkType> getAllWorkTypes() {
		return workTypeRepository.findAll();
	}

	public WorkType updateWorkType(Long id, WorkType updatedWorkType) {
		WorkType workType = getWorkTypeById(id);
		workType.setName(updatedWorkType.getName());
		return workTypeRepository.save(workType);
	}

	public void deleteWorkType(Long id) {
		workTypeRepository.deleteById(id);
	}
}
