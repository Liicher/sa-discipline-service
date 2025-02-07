package ru.nnov.nntu.vst.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nnov.nntu.vst.demo.dto.DisciplineDTO;
import ru.nnov.nntu.vst.demo.mapper.DisciplineMapper;
import ru.nnov.nntu.vst.demo.models.Discipline;
import ru.nnov.nntu.vst.demo.repository.DisciplineRepository;

import java.util.List;

@Service
public class DisciplineService {
	@Autowired
	private DisciplineRepository disciplineRepository;
	@Autowired
	private DisciplineMapper disciplineMapper;

	public Discipline createDiscipline(Discipline discipline) {
		return disciplineRepository.save(discipline);
	}

	public Discipline getDisciplineById(Long id) {
		return disciplineRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Дисциплина с ID = " + id + " не найдена"));
	}

	public Discipline createDisciplineFromDTO(DisciplineDTO dto) {
		Discipline discipline = disciplineMapper.mapToDiscipline(dto);
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
		discipline.setAssessment(updatedDiscipline.getAssessment());
		return disciplineRepository.save(discipline);
	}

	public void deleteDiscipline(Long id) {
		disciplineRepository.deleteById(id);
	}
}
