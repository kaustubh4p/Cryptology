package com.security.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** MD5 + SALT
 * @author KaustubhWaghmare
 * 08-Nov-2018
 *
 * SALT is randomly generated and hence new MD5 will be generated each time
 */

public class SaltedMD5Example
{
	private static final Logger logger = 
			LoggerFactory.getLogger(SaltedMD5Example.class);
	
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException
    {
        String passwordToHash = "Pass@1234";
        byte[] salt = getSalt();
         
        String securePassword = getSecurePassword(passwordToHash, salt);
        logger.info(securePassword); 
         
        String regeneratedPassowrdToVerify = getSecurePassword(passwordToHash, salt);
        logger.info(regeneratedPassowrdToVerify);
    }
     
    private static String getSecurePassword(String passwordToHash, byte[] salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(salt);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();		 		//Get complete hashed password in hex format
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
     
    //Add salt
    private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");	 //Always use a SecureRandom generator
        byte[] salt = new byte[16];										 //Create array for salt
        sr.nextBytes(salt);	 											 //Get a random salt
        return salt;
    }
}