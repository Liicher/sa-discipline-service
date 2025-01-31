package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.dto.DisciplineDTO;
import ru.nnov.nntu.vst.demo.models.AssessmentType;
import ru.nnov.nntu.vst.demo.models.Discipline;
import ru.nnov.nntu.vst.demo.models.Skill;
import ru.nnov.nntu.vst.demo.models.WorkType;
import ru.nnov.nntu.vst.demo.repository.AssessmentTypeRepository;
import ru.nnov.nntu.vst.demo.repository.DisciplineRepository;
import ru.nnov.nntu.vst.demo.repository.SkillRepository;
import ru.nnov.nntu.vst.demo.repository.WorkTypeRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DisciplineService {
	@Autowired
	private DisciplineRepository disciplineRepository;
	@Autowired
	private SkillRepository skillRepository;
	@Autowired
	private WorkTypeRepository workTypeRepository;
	@Autowired
	private AssessmentTypeRepository assessmentTypeRepository;

	public Discipline createDiscipline(Discipline discipline) {
		return disciplineRepository.save(discipline);
	}

	public Discipline getDisciplineById(Long id) {
		return disciplineRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Дисциплина с ID = " + id + " не найдена"));
	}

	/*public Discipline createDisciplineFromDTO(DisciplineDTO dto) {
		Discipline discipline = new Discipline();
		discipline.setName(dto.getName());
		discipline.setDescription(dto.getDescription());

		// Загрузка связанных сущностей по ID
		discipline.setRequiredSkills((Set<Skill>) skillRepository.findAllById(dto.getRequiredSkills()));
		discipline.setOutcomes((Set<Skill>) skillRepository.findAllById(dto.getOutcomes()));
		discipline.setWorkTypes((Set<WorkType>) workTypeRepository.findAllById(dto.getWorkTypes()));
		discipline.setAssessments((Set<AssessmentType>) assessmentTypeRepository.findAllById(dto.getAssessments()));

		return disciplineRepository.save(discipline);
	}*/

	public Discipline createDisciplineFromDTO(DisciplineDTO dto) {
		Discipline discipline = new Discipline();
		discipline.setName(dto.getName());
		discipline.setDescription(dto.getDescription());

		// Загрузка требуемых навыков по ID
		if (dto.getRequiredSkills() != null) {
			Set<Skill> requiredSkills = new HashSet<>(skillRepository.findAllById(dto.getRequiredSkills()));
			discipline.setRequiredSkills(requiredSkills);
		}

		// Загрузка формируемых навыков по ID
		if (dto.getOutcomes() != null) {
			Set<Skill> outcomes = new HashSet<>(skillRepository.findAllById(dto.getOutcomes()));
			discipline.setOutcomes(outcomes);
		}

		// Загрузка типов работ по ID
		if (dto.getWorkTypes() != null) {
			Set<WorkType> workTypes = new HashSet<>(workTypeRepository.findAllById(dto.getWorkTypes()));
			discipline.setWorkTypes(workTypes);
		}

		// Загрузка типов контроля по ID
		if (dto.getAssessments() != null) {
			Set<AssessmentType> assessments = new HashSet<>(assessmentTypeRepository.findAllById(dto.getAssessments()));
			discipline.setAssessments(assessments);
		}

		return disciplineRepository.save(discipline);
	}

	public List<Discipline> getAllDisciplines() {
		return disciplineRepository.findAll();
	}

	public Discipline updateDiscipline(Long id, Discipline updatedDiscipline) {
		Discipline discipline = getDisciplineById(id);
		discipline.setName(updatedDiscipline.getName());
		discipline.setDescription(updatedDiscipline.getDescription());
		discipline.setRequiredSkills(updatedDiscipline.getRequiredSkills());
		discipline.setOutcomes(updatedDiscipline.getOutcomes());
		discipline.setWorkTypes(updatedDiscipline.getWorkTypes());
		discipline.setAssessments(updatedDiscipline.getAssessments());
		return disciplineRepository.save(discipline);
	}

	public void deleteDiscipline(Long id) {
		disciplineRepository.deleteById(id);
	}
}
