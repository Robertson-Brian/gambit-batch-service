package com.revature.gambit.messaging;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chris
 *	creates a UUIDService if one is not made already 
 */
@Component
public class UUIDService {
	
	@Autowired
	Sender sender;
	private static UUIDService instance = null;
	private int checked= 0;
	private List<UUID> listUUID;
	private UUID serviceInstanceIdentifier;
	   
	   /**
	 *  Creates instance of a random UUID
	 */
	private UUIDService(){

		listUUID = new ArrayList<UUID>();
		serviceInstanceIdentifier = UUID.randomUUID();
	     
	}
	   /**
	    * if it does not exist it is created 
	 * @return itself (UUIDService)
	 */
	public static UUIDService getInstance(){
	      if(instance == null) {
	         instance = new UUIDService();
	      }
	      return instance;
	}
	   
	   /**
	 * @return the UUID to be made into a string to be sent to whatever is calling it
	 */
	public void addUUIDToList(String uuid){
		listUUID.add(UUID.fromString(uuid));
	   }
	
	/**
	 * Sees if it has been checked before
	 */
	public void checkuuid() {
		if (checked==0) {
			sendIfListIsEmpty();
		}
	}
	
	/**
	 * sends UUID to kafka if there is no UUID in kafka (starts list)
	 */
	public void sendIfListIsEmpty() {
		if(listUUID.isEmpty()) {
			sender.sendUUID(serviceInstanceIdentifier.toString());
			checked=1;
	     
		}
		else {
			checkToSeeIfUuidIsInList();
		}
	}
	
	/**
	 * goes threw list to make sure uuid is not duplicatied 
	 */
	public void checkToSeeIfUuidIsInList() {
		int a=0;
		while(a!=1) {
			UUID temp = UUID.randomUUID();
			for (UUID i:listUUID) {
				if(temp.equals(i)){
					temp = UUID.randomUUID();
					a=-1;
				}
			}
			if (a==0) {
				serviceInstanceIdentifier = temp;
				sender.sendUUID(serviceInstanceIdentifier.toString());
				checked=1;
				a=1;
			}
		}
	}
	
	public UUID getServiceInstanceIdentifier(){
		   return this.serviceInstanceIdentifier;
	   }
	}



