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

		listUUID = new ArrayList<>();
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
	public boolean checkuuid() {
		if (checked==0) {
			return sendIfListIsEmpty();
		}
		return false;
	}

	/**
	 * sends UUID to kafka if there is no UUID in kafka (starts list)
	 */
	public boolean sendIfListIsEmpty() {
		if(listUUID.isEmpty()) {
			sender.sendUUID(serviceInstanceIdentifier.toString());
			checked=1;
			return true;
		}
		else {
			checkToSeeIfUuidIsInList();
			return false;
		}
	}
	
	/**
	 * goes threw list to make sure uuid is not duplicatied 
	 */
	public void checkToSeeIfUuidIsInList() {
		int a=0;
		while(a!=1) {
			a=0;
			UUID temp = serviceInstanceIdentifier;
			for (UUID i:listUUID) {
				if(temp.equals(i)){
					serviceInstanceIdentifier = UUID.randomUUID();
					a=-1;
				}
			}
			if (a==0) {
				sender.sendUUID(serviceInstanceIdentifier.toString());
				checked=1;
				a=1;
			}
		}
	}
	
	public UUID getServiceInstanceIdentifier(){
		   return this.serviceInstanceIdentifier;
    }


	public List<UUID> getListUUID() {
		return listUUID;
	}

	public int getChecked(){
		return checked;
	}

	public void setSender(Sender sender){
		this.sender = sender;
	}

}