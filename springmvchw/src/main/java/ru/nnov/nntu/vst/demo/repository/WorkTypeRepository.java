package ru.nnov.nntu.vst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nnov.nntu.vst.demo.models.WorkType;

public interface WorkTypeRepository extends JpaRepository<WorkType, Long> {}
