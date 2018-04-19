CREATE TABLE batch
(
    batch_id NUMBER PRIMARY KEY,
    cotrainer_id NUMBER,
    end_date TIMESTAMP NULL,
    location VARCHAR(200),
    resource_id NUMBER,
    skill_type VARCHAR(200),
    start_date TIMESTAMP NULL,
    trainer_id NUMBER,
    training_name VARCHAR2(200),
    training_type VARCHAR2(200),
);
