import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.revature.gambit.model.Batch;
import com.revature.gambit.services.BatchService;
import com.revature.gambit.services.BatchServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class BatchServiceTest {

//	@Configuration
//	static class ContextConfiguration {
//
//		// this bean will be injected into the OrderServiceTest class
//		@Bean
//		public BatchService batchService() {
//			BatchService batchService = new BatchServiceImpl(null);
//			// set properties, etc.
//			return batchService;
//		}
//	}

	@MockBean
	private BatchServiceImpl batchService;

	Batch batch1;
	Batch batch2;

	List<Batch> batches;

	@Before
	public void setUp() throws Exception {
		batch1 = new Batch(1, 2, "java", 10, 2, "programming", "lecturing", null, null, "Reston", "Java Full Stack",
				null, null, null);

		batch2 = new Batch(2, 2, "pega", 20, 5, "pega stuff", "lecturing", null, null, "Reston", "Pega", null, null,
				null);

		batches = Arrays.asList(batch1, batch2);

		batchService.save(batch1);
		batchService.save(batch2);

		when(batchService.findAll()).thenReturn(batches);
	}

	@Test
	public void testGetAllBatchesService() throws Exception {
		
		List<Batch> batchTest = batchService.findAll();

		assertEquals(batches, batchTest);

	}

	@After
	public void tearDown() throws Exception {
		batchService.delete(batch1.getBatchId());
		batchService.delete(batch2.getBatchId());
	}

}
