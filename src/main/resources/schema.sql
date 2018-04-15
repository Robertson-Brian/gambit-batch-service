/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE batch
(
    resource_id NUMBER,
    training_name VARCHAR2(200),
    trainer_id NUMBER,
    cotrainer_id NUMBER,
    skill_type VARCHAR2(200),
    training_type VARCHAR2(200),
    start_date TIMESTAMP NULL,
    end_date TIMESTAMP NULL,
    location VARCHAR2(200),
    curriculum VARCHAR2(200),
    batch_id NUMBER PRIMARY KEY
);

/*******************************************************************************
   Create Sequences
********************************************************************************/
CREATE SEQUENCE batch_id_seq;