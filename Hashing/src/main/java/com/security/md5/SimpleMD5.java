package com.security.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** Simple MD5
 * @author KaustubhWaghmare
 * 06-Nov-2018
 *
 * The MD5 Message-Digest Algorithm is a widely used cryptographic hash function that produces a 
 * 128-bit (16-byte) hash value. It’s very simple and straight forward; 
 * the basic idea is to map data sets of variable length to data sets of a fixed length.
 * 
 * Please remember that once this password hash is generated and stored in the database, 
 * you can not convert it back to the original password.
 */

public class SimpleMD5 {
	
	private static final Logger logger = 
			LoggerFactory.getLogger(SimpleMD5.class);
	
	public static void main(String args[])
	{
		String passwordToHash = "Pass@1234";
		String generatedPassword ="";

		
        try {
			MessageDigest md = MessageDigest.getInstance("MD5");	// Create MessageDigest instance for MD5
			  md.update(passwordToHash.getBytes());					//Get the hash's bytes
	            
	            byte[] bytes = md.digest();
														            //This bytes[] has bytes in decimal format;
														            //Convert it to hexadecimal format
	            StringBuilder sb = new StringBuilder();
	            for(int i=0; i< bytes.length ;i++)
	            {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	            }
	           
	            generatedPassword = sb.toString();					 //Get complete hashed password in hex format
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("Generated Hash Password [ "+generatedPassword+" ]");
	}
}
