package ru.nnov.nntu.vst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nnov.nntu.vst.demo.models.AssessmentType;

public interface AssessmentTypeRepository extends JpaRepository<AssessmentType, Long> {}
