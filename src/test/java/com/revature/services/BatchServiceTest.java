package com.revature.services;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.gambit.Application;
import com.revature.gambit.model.Batch;
import com.revature.gambit.services.BatchService;

/**
 * 
 * Authors:
 * Yuri Felicio
 * Malik Biddle
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class BatchServiceTest {


    @Autowired
    private BatchService batchService;

    Batch savedBatch;

    @Before
    public void setUp() throws Exception {
        Batch newBatch = new Batch();
        newBatch.setBatchId(2);
        newBatch.setResourceId(2);
        newBatch.setTrainingName("java");
        newBatch.setTrainerId(20);
        newBatch.setCotrainerId(5);
        newBatch.setSkillTypeId(4);
        newBatch.setTrainingType("lecturing");
        newBatch.setLocation("Reston");
        savedBatch = batchService.save(newBatch);
    }

    @Test
    public void testSave() throws Exception {
        // instantiate and save a new batch
        Batch testBatch = new Batch();
        testBatch.setBatchId(2);
        testBatch.setResourceId(2);
        testBatch.setTrainingName("java");
        testBatch.setTrainerId(20);
        testBatch.setCotrainerId(5);
        testBatch.setSkillTypeId(4);
        testBatch.setTrainingType("lecturing");
        testBatch.setLocation("Reston");
        Batch newBatch = batchService.save(testBatch);

        assertNotEquals(0, savedBatch.getBatchId());
        assertEquals(testBatch.getCotrainerId(), newBatch.getCotrainerId());
        assertEquals(testBatch.getResourceId(), newBatch.getResourceId());
    }

    @Test
    public void testGetAllBatches() throws Exception {

        assertNotEquals(null, batchService.findAll());
        assertTrue(batchService.findAll().size() > 1);
    }

    @Test
    public void testGetBatchById() throws Exception {
        // get the id of the saved batch
        int id = savedBatch.getBatchId();
        //check that the find by id gets the correct batch
        Batch batch = batchService.findById(id);
        assertEquals(savedBatch.getBatchId(), batch.getBatchId());
        assertTrue(savedBatch.getLocation().equals(batch.getLocation()));
        assertEquals(savedBatch.getSkillTypeId(), batch.getSkillTypeId());

    }


    @Test
    public void testGetBatchesByTrainerId() throws Exception {
        // get the id of the trainer
        int trainerId = savedBatch.getTrainerId();
        // get the list of batches with that trainer id, should only be 1
        List<Batch> batches = batchService.findByTrainerId(trainerId);

        assertNotEquals(null, batches);
        assertTrue(batches.size() >= 1);
    }

    @Test
    public void testUpdate() {

        //update fields of savedbatch
        savedBatch.setLocation("Reston");
        savedBatch.setSkillTypeId(5122);
        batchService.update(savedBatch);
        //get updated batch
        Batch updatedBatch = batchService.findById(savedBatch.getBatchId());

        assertNotEquals(0, updatedBatch.getBatchId());
        assertTrue(5122 == updatedBatch.getSkillTypeId());
        assertTrue("Reston".equals(updatedBatch.getLocation()));
    }


    @After
    public void tearDown() throws Exception {
        batchService.delete(savedBatch.getBatchId());
    }

}
