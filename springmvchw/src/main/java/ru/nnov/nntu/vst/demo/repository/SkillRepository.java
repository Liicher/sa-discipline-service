package ru.nnov.nntu.vst.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nnov.nntu.vst.demo.models.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {}