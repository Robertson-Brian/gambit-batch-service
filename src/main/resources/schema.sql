CREATE TABLE batch
(
    batch_id INT PRIMARY KEY,
    cotrainer_id INT,
    end_date TIMESTAMP NULL,
    location VARCHAR(200),
    resource_id INT,
    skill_type INT,
    start_date TIMESTAMP NULL,
    trainer_id INT,
    training_name VARCHAR(200),
    training_type VARCHAR(200),
);

--CREATE TABLE NOTE_IDS
--(
--  batch_id INT ,
--  note_id INT PRIMARY KEY
--);
--
--CREATE TABLE TRAINEE_IDS
--(
--  batch_id INT ,
--  trainee_id INT PRIMARY KEY
--);

CREATE SEQUENCE BATCH_ID_SEQ START WITH 5 INCREMENT BY 5;
