/*
    This Class implements the password security of the app
    the password is encrypted using java's standared libraries, the encrypted password is stored in the database.
    the function encrypt does the above task.
    Conversly the function decrypt decrypts the encrypted password into the original password.
    This function is used only once, i.e., during editing the password.
*/
package com.example.phase1;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryption
{
    /**
     *
     * @author vaibh
     */

        private static final String algo = "AES";
        private static byte[] keyValue;

        private static Key generateKey() {
            Key key = new SecretKeySpec(keyValue,algo);
            return key;
        }

        public Encryption(){
            String key="lv39eptlvuhaqqsr";
            keyValue = key.getBytes();
        }

        public static String encrypt(String data)  {
            try{
                String keyy="lv39eptlvuhaqqsr";
                keyValue = keyy.getBytes();
                Key key = generateKey();
                Cipher c = Cipher.getInstance(algo);
                c.init(Cipher.ENCRYPT_MODE, key);
                byte[] encVal = c.doFinal(data.getBytes());
                Base64.Encoder encoder = Base64.getEncoder();
                String encryptedValue = new String(encoder.encode(encVal));
                return encryptedValue;
            } catch(Exception ex){
                System.out.println("Error while encrypting" + ex.toString());
            }
            return null;
        }

        public static String decrypt(String encryptedData) {
            try {
                String keyy="lv39eptlvuhaqqsr";
                keyValue = keyy.getBytes();
                Key key = generateKey();
                Cipher c = Cipher.getInstance(algo);
                c.init(Cipher.DECRYPT_MODE, key);
                Base64.Decoder decoder = Base64.getDecoder();
                byte[] decordedValue = decoder.decode(encryptedData);
                byte[] decValue = c.doFinal(decordedValue);
                String decryptedValue = new String(decValue);
                return decryptedValue;
            } catch (Exception ex){
                System.out.println("Error while " + ex.toString());
            }
            return null;
        }



    }
