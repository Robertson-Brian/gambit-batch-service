package com.revature.hydra.messaging;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.revature.hydra.entities.Trainee;

public class UserClientFallback implements UserClient {

	@Override
	public ResponseEntity<List<Trainee>> findAllByBatchAndStatus(Integer id, String status) {
		return null;
	}
}
