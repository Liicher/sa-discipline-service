-- Вставка данных в таблицу AssessmentType
INSERT INTO assessment_types (name) VALUES ('Экзамен');
INSERT INTO assessment_types (name) VALUES ('Зачет');
INSERT INTO assessment_types (name) VALUES ('Зачет с оценкой');
INSERT INTO assessment_types (name) VALUES ('Диплом');

-- Вставка данных в таблицу Skill
INSERT INTO skills (name, type) VALUES ('Java Programming', 'Skill');
INSERT INTO skills (name, type) VALUES ('Algorithm Design', 'Knowledge');
INSERT INTO skills (name, type) VALUES ('Data Structures', 'Knowledge');
INSERT INTO skills (name, type) VALUES ('Database Management', 'Skill');
INSERT INTO skills (name, type) VALUES ('Software Engineering', 'Knowledge');

-- Вставка данных в таблицу WorkType
INSERT INTO work_types (name) VALUES ('Лекции');
INSERT INTO work_types (name) VALUES ('Лабораторные работы');
INSERT INTO work_types (name) VALUES ('Практические работы');
INSERT INTO work_types (name) VALUES ('Курсовые работы');

-- Вставка данных в таблицу Discipline
INSERT INTO disciplines (name, description, assessment_type_id) VALUES ('Информационные технологии', 'Обзор современных информационных технологий и их применения.', 1);
INSERT INTO disciplines (name, description, assessment_type_id) VALUES ('Математический анализ', 'Изучение математического анализа.', 2);
INSERT INTO disciplines (name, description, assessment_type_id) VALUES ('Физика', 'Основы физики.', 3);
INSERT INTO disciplines (name, description, assessment_type_id) VALUES ('История', 'История человечества.', 4);

-- Вставка данных в таблицу Discipline_Requirements (требуемые навыки)
INSERT INTO discipline_requirements (discipline_id, skill_id) VALUES (1, 1); -- Информационные технологии требуют Java Programming
INSERT INTO discipline_requirements (discipline_id, skill_id) VALUES (1, 2); -- Информационные технологии требуют Algorithm Design
INSERT INTO discipline_requirements (discipline_id, skill_id) VALUES (2, 3); -- Математический анализ требует Data Structures
INSERT INTO discipline_requirements (discipline_id, skill_id) VALUES (3, 4); -- Физика требует Database Management
INSERT INTO discipline_requirements (discipline_id, skill_id) VALUES (4, 5); -- История требует Software Engineering

-- Вставка данных в таблицу Discipline_Outcomes (формируемые навыки)
INSERT INTO discipline_outcomes (discipline_id, skill_id) VALUES (1, 2); -- Информационные технологии формируют Algorithm Design
INSERT INTO discipline_outcomes (discipline_id, skill_id) VALUES (1, 3); -- Информационные технологии формируют Data Structures
INSERT INTO discipline_outcomes (discipline_id, skill_id) VALUES (2, 4); -- Математический анализ формирует Database Management
INSERT INTO discipline_outcomes (discipline_id, skill_id) VALUES (3, 5); -- Физика формирует Software Engineering
INSERT INTO discipline_outcomes (discipline_id, skill_id) VALUES (4, 1); -- История формирует Java Programming

-- Вставка данных в таблицу Discipline_Work_Types (виды работ)
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (1, 1); -- Информационные технологии: Лекции
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (1, 2); -- Информационные технологии: Лабораторные работы
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (1, 3); -- Информационные технологии: Практические работы
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (1, 4); -- Информационные технологии: Курсовые работы

INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (2, 1); -- Математический анализ: Лекции
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (2, 2); -- Математический анализ: Лабораторные работы

INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (3, 1); -- Физика: Лекции
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (3, 2); -- Физика: Лабораторные работы
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (3, 3); -- Физика: Практические работы

INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (4, 1); -- История: Лекции
INSERT INTO discipline_work_types (discipline_id, work_type_id) VALUES (4, 4); -- История: Курсовые работы