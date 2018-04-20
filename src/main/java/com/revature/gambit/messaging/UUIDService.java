package com.revature.gambit.messaging;
import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * @author chris
 *	creates a UUIDService if one is not made already 
 */
@Component
public class UUIDService {
	   private static UUIDService instance = null;
	   private UUID serviceInstanceIdentifier;
	   
	   /**
	 *  Creates instance of a random UUID
	 */
	private UUIDService(){
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
	public UUID getServiceInstanceIdentifier(){
		   return this.serviceInstanceIdentifier;
	   }
	}



