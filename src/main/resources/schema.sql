
CREATE TABLE BATCH
(
    batch_id INT PRIMARY KEY,
    GOOD_GRADE_THRESHOLD INT NOT NULL,
    ADDRESS_ID INT,
    BORDERLINE_GRADE_THRESHOLD INT NOT NULL,
    WEEK INT,
    cotrainer_id INT,
    end_date TIMESTAMP NULL,
    location VARCHAR(200),
    resource_id INT,
    skill_type INT,
    start_date TIMESTAMP NULL,
    trainer_id INT,
    training_name VARCHAR(200),
    training_type VARCHAR(200)
);

CREATE SEQUENCE BATCH_ID_SEQ START WITH 5 INCREMENT BY 5;

CREATE TABLE BATCH_NOTES
(
  batch_batch_id INT ,
  notes INT PRIMARY KEY
);

CREATE TABLE BATCH_TRAINEES
(
  batch_batch_id INT ,
  trainees INT PRIMARY KEY
);
