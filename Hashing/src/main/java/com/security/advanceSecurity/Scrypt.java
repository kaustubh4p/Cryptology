package com.security.advanceSecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lambdaworks.crypto.SCryptUtil;
import com.security.md5.SaltedMD5Example;

/**
 * @author KaustubhWaghmare
 * 08-Nov-2018
 * 
 * Scrypt example with salt
 */
public class Scrypt {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(Scrypt.class);
	
	public static void main(String[] args) {
        String originalPassword = "Pass@1234";
        String generatedSecuredPasswordHash = SCryptUtil.scrypt(originalPassword, 16, 16, 16);
        logger.info(generatedSecuredPasswordHash);
         
        boolean matched = SCryptUtil.check(originalPassword, generatedSecuredPasswordHash);
        logger.info("Status :"+matched);
         
        matched = SCryptUtil.check("pass", generatedSecuredPasswordHash);
        logger.info("Status :"+matched);
    }

}
