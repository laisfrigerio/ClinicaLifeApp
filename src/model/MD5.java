/**
 * @author Lais Frigério da Silva
 */

package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public String md5(String senha){
        MessageDigest md = null;
        try {
                md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        return hash.toString(16);			
    }
}
