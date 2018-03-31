package com.revature.hydra.messaging;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.revature.hydra.entities.Trainee;


@FeignClient(name="user-service", fallback=UserClientFallback.class)
public interface UserClient {
	
	// example/placehollder
	@GetMapping("trainees/batch/{id}/status/{status}")
	ResponseEntity<List<Trainee>> findAllByBatchAndStatus(@PathVariable("id") Integer id, @PathVariable("status") String status);
	
}
