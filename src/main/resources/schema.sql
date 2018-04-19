CREATE TABLE batch
(
    batch_id INT PRIMARY KEY,
    cotrainer_id INT,
    end_date TIMESTAMP NULL,
    location VARCHAR(200),
    resource_id INT,
    skill_type VARCHAR(200),
    start_date TIMESTAMP NULL,
    trainer_id INT,
    training_name VARCHAR2(200),
    training_type VARCHAR2(200),
);

CREATE SEQUENCE BATCH_ID_SEQ START WITH 5 INCREMENT BY 5;
