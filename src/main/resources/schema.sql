
CREATE TABLE BATCH
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
    good_grade_threshold INT,
    address_id INT,
    borderline_grade_threshold INT,
    week INT
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
