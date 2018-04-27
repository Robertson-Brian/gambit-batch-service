package com.revature.gambit.messaging;
import java.util.List;
import java.util.UUID;

import org.apache.kafka.common.network.Send;
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
	private List<UUID>listUUID;
	private UUID serviceInstanceIdentifier;
	   
	   /**
	 *  Creates instance of a random UUID
	 */
	private UUIDService(){
		
	     
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
	public void checkuuid() {
		if (checked==0) {
			checkPartTwo();
		}
	}
	
	public void checkPartTwo() {
		if(listUUID.isEmpty()) {
			sender.sendUUID(serviceInstanceIdentifier.toString());
			checked=1;
	     
		}
		else {
			checkPartThree();
		}
	}
	
	public void checkPartThree() {
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



