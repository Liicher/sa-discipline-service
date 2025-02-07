package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.dto.DisciplineDTO;
import ru.nnov.nntu.vst.demo.mapper.DisciplineMapper;
import ru.nnov.nntu.vst.demo.models.AssessmentType;
import ru.nnov.nntu.vst.demo.models.Discipline;
import ru.nnov.nntu.vst.demo.models.Skill;
import ru.nnov.nntu.vst.demo.models.WorkType;
import ru.nnov.nntu.vst.demo.repository.AssessmentTypeRepository;
import ru.nnov.nntu.vst.demo.repository.DisciplineRepository;
import ru.nnov.nntu.vst.demo.repository.SkillRepository;
import ru.nnov.nntu.vst.demo.repository.WorkTypeRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
	@Autowired
	private DisciplineMapper disciplineMapper;

	public Discipline createDiscipline(Discipline discipline) {
		return disciplineRepository.save(discipline);
	}

	public Discipline getDisciplineById(Long id) {
		return disciplineRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Дисциплина с ID = " + id + " не найдена"));
	}

	public Discipline createDisciplineFromDTO(DisciplineDTO disciplineDTO) {
		Discipline discipline = disciplineMapper.mapToDiscipline(disciplineDTO);
		discipline = fillDiscipline(discipline, disciplineDTO);
		return disciplineRepository.save(discipline);
	}

	public List<Discipline> getAllDisciplines() {
		return disciplineRepository.findAll();
	}

	public Discipline updateDiscipline(Long id, DisciplineDTO updatedDisciplineDTO) {
		Discipline discipline = getDisciplineById(id);
		discipline.setName(updatedDisciplineDTO.getName());
		discipline.setDescription(updatedDisciplineDTO.getDescription());
		discipline = fillDiscipline(discipline, updatedDisciplineDTO);
		return disciplineRepository.save(discipline);
	}

	public void deleteDiscipline(Long id) {
		disciplineRepository.deleteById(id);
	}

	private Discipline fillDiscipline(Discipline discipline, DisciplineDTO disciplineDTO) {
		Set<Skill> requiredSkills = disciplineDTO.getRequiredSkillIds().stream()
				.map(skillRepository::findById)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toSet());
		discipline.setRequiredSkills(requiredSkills);

		Set<Skill> outcomes = disciplineDTO.getOutcomeIds().stream()
				.map(skillRepository::findById)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toSet());
		discipline.setOutcomes(outcomes);

		Set<WorkType> workTypes = disciplineDTO.getWorkTypeIds().stream()
				.map(workTypeRepository::findById)
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toSet());
		discipline.setWorkTypes(workTypes);

		if (disciplineDTO.getAssessmentTypeId() != null) {
			AssessmentType assessmentType = assessmentTypeRepository.findById(disciplineDTO.getAssessmentTypeId())
					.orElseThrow(() -> new RuntimeException("AssessmentType с ID = " + disciplineDTO.getAssessmentTypeId() + " не найден"));
			discipline.setAssessment(assessmentType);
		}

		return discipline;
	}
}
