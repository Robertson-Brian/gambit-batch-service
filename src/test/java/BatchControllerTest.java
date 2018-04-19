import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.gambit.controllers.BatchControllerImpl;
import com.revature.gambit.model.Batch;
import com.revature.gambit.services.BatchService;

@RunWith(SpringJUnit4ClassRunner.class)
public class BatchControllerTest {

	
	private MockMvc mockMvc;
	
	@InjectMocks
	private BatchControllerImpl batchController;
	
	@Mock
	private BatchService batchService;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(batchController)
				.build();
	}

	@Test
	public void testGetAllBatches() throws Exception {
		List<Batch> batches = new ArrayList<>();
		batches.add(new Batch());
		batches.add(new Batch());
		
		when(batchService.findAll()).thenReturn((List) batches);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/batches"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8));
	}
	
	@Test 
	public void testGetAllBatchesJson() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/batches")
			.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	@Test
	public void testGetBatchById() throws Exception {
		Batch batch = new Batch();
		batch.setBatchId(1);
		
		when(batchService.findById(1)).thenReturn(batch);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/batches/1")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}
