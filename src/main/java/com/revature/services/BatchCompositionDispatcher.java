package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.revature.entities.Batch;
import com.revature.repository.BatchRepo;


@Service
public class BatchCompositionDispatcher {
	@Autowired
	private BatchRepo repo;
	
//	/**
//	 * 
//	 * @param request
//	 * @return
//	 */
//	public List<Batch> processListBatchRequest(JsonObject request) {
//		System.out.println(request);
//		System.out.println("List");
//		String methodName = request.get("methodName").getAsString();
//		if(methodName.contains("findAll")){
//			if(methodName.contains("AfterDate")) {
//				int month = request.get("month").getAsInt();
//				int day = request.get("day").getAsInt();
//				int year = request.get("year").getAsInt();
//				return bcs.findAllAfterDate(month, day, year);
//			}else if(methodName.contains("Current")){
//				if (methodName.contains("WithNotes")) {
//					return bcs.findAllCurrentWithNotes();
//				} else if(methodName.contains("WithNotesAndTrainees")) {
//					return bcs.findAllCurrentWithNotesAndTrainees();
//				} else if(methodName.contains("WithTrainees")) {
//					return bcs.findAllCurrentWithTrainees();
//				} else {
//					return bcs.findAllCurrent();
//				}
//			}
//		}
//		return null;
//	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	public Batch processBatchRequest(JsonObject request) {
		String methodName = request.get("methodName").getAsString();
		if(methodName.contains("findOne")){
				return repo.findByBatchId(request.get("batchId").getAsInt());
		}
		return null;
	}
}
