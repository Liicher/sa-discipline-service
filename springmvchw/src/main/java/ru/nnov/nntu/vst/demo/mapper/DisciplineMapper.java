package ru.nnov.nntu.vst.demo.mapper;

import org.springframework.stereotype.Component;
import ru.nnov.nntu.vst.demo.dto.DisciplineDTO;
import ru.nnov.nntu.vst.demo.models.Discipline;

@Component
public class DisciplineMapper {
	public DisciplineDTO mapToDisciplineDTO(Discipline discipline) {
		DisciplineDTO disciplineDTO = new DisciplineDTO();
		disciplineDTO.setId(discipline.getId());
		disciplineDTO.setName(discipline.getName());
		disciplineDTO.setDescription(discipline.getDescription());
		disciplineDTO.setRequiredSkills(discipline.getRequiredSkills());
		disciplineDTO.setOutcomes(discipline.getOutcomes());
		disciplineDTO.setWorkTypes(discipline.getWorkTypes());
		disciplineDTO.setAssessment(discipline.getAssessment());
		return disciplineDTO;
	}

	public Discipline mapToDiscipline(DisciplineDTO disciplineDTO) {
		Discipline discipline = new Discipline();
		discipline.setId(disciplineDTO.getId());
		discipline.setName(disciplineDTO.getName());
		discipline.setDescription(disciplineDTO.getDescription());
		discipline.setRequiredSkills(disciplineDTO.getRequiredSkills());
		discipline.setOutcomes(disciplineDTO.getOutcomes());
		discipline.setWorkTypes(disciplineDTO.getWorkTypes());
		discipline.setAssessment(disciplineDTO.getAssessment());
		return discipline;
	}
}
