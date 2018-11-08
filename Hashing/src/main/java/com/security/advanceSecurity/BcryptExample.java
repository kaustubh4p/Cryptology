package com.security.advanceSecurity;



import java.security.NoSuchAlgorithmException;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author KaustubhWaghmare
 * 08-Nov-2018
 * 
 * Bcrypt example with SALT
 *
 */
public class BcryptExample {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(BcryptExample.class);
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String originalPassword = "Pass@1234";
		String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
		logger.info("Generated Secured Password Hash ["+generatedSecuredPasswordHash+"]");
		boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
		logger.info("Status ["+matched+"]");
	}

}
