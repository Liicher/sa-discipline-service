package ru.nnov.nntu.vst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nnov.nntu.vst.demo.models.Discipline;

public interface DisciplineRepository extends JpaRepository<Discipline, Long> {}
