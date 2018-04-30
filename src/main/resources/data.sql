
/*******************************************************************************
   Insert Some Data
********************************************************************************/


INSERT INTO BATCH (batch_id, GOOD_GRADE_THRESHOLD, ADDRESS_ID, BORDERLINE_GRADE_THRESHOLD, WEEK, resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
VALUES (NEXTVAL('BATCH_ID_SEQ'), 80, 1, 70, 1, 1, '1802JavaNick', 1, 2, 6, 'Java', PARSEDATETIME('2017-10-02','yyyy-mm-dd'), PARSEDATETIME('2017-12-06', 'yyyy-mm-dd'), 'Reston');


-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (2, '1803JavaNick', 1, 2, 'Java', 'Java', DATE '2017-12-12', DATE '2018-02-12', 'Reston');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (2, '1804JavaNick', 1, 2, 'Java', 'Java', DATE '2018-02-16', DATE '2018-03-20', 'Reston');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (5, '1805JavaNick', 1, 2, 'Java', 'Java', DATE '2018-03-26', DATE '2018-05-10', 'Reston');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (2, '1806JavaAugust', 2, 1, 'Java', 'Java', DATE '2017-10-28', DATE '2018-01-01', 'Reston');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (9, '1807JavaAugust', 2, 1, 'Java', 'Java', DATE '2018-01-12', DATE '2018-03-10', 'Reston');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (9, '1808JavaAugust', 2, 1, 'Java', 'Java', DATE '2018-03-22', DATE '2018-05-02', 'Tampa');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (9, '01PegaNick', 1, 2, 'Pega', 'Pega', DATE '2016-02-12', DATE '2016-04-08', 'Tampa');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (12, '02PegaNick', 1, 2, 'Pega', 'Pega', DATE '2016-05-02', DATE '2016-07-02', 'Tampa');
--
-- INSERT INTO BATCH (resource_id, training_name, trainer_id, cotrainer_id, skill_type, training_type, start_date, end_date, location)
-- VALUES (10, '03JavaTestAugust', 2, 1, 'JTA', 'JTA', DATE '2017-02-12', DATE '2017-04-12', 'New York');
--
--
