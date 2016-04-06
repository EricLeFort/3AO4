package tools;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import sun.misc.*;

/**
 * @author Nicholas Lago
 * @version 1.0
 */
public class Message_Passer{
    private int keySize = 128; // 16 bytes
    private byte[] v = new byte[keySize/8]; //from bits to bytes
    private SecretKey key; // symmetric key used

    public byte[] messagePass(String message){
        return encode(message, null);
    }
    public byte[] messagePass(String message, SecretKey sKey){
        return encode(message, sKey);
    }



    private byte[] encode(String message, SecretKey sKey){
        byte[] empty = new byte [1];
        try{
            /** AES Key Generator
             * AES - Advanced Encryption Standard
             * DES - too small keys (56 bits), 3DES - slow
             * KeyGenerator.getInstance will create a KeyGenerator object
             * that uses the algorithm specified
             */
            KeyGenerator gen = KeyGenerator.getInstance("AES");
            if (sKey == null){
                gen.init(keySize);
                key = gen.generateKey(); // key created
            }else{
                key = sKey;
            }
            //Initialization Vector
            // PRNG - Pseudo random number generator
            SecureRandom PRNG = new SecureRandom();
            PRNG.nextBytes(v); // fills our vector with random bytes
            /**
             * .getInstance creates a Cipher object using algorithm/feedback mode/ padding
             * Cipher Block Chaining (CBC) uses an initialization vector XOR'd with the first
             * block of plain text before encryption (AES algorithm). Subsequently after this each plain text block
             * is XOR'd with cipher text.
             * PKCS7 pads with whole bytes. Each byte is the value
             */
            Cipher bill= Cipher.getInstance("AES/CBC/PKCS5PADDING");

            /**
             * Cipher is initialized to encryption mode, IVParameterSpec allows the
             * cipher to use the vector v as an IV
             */
            bill.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(v));

            byte[] byteMe = message.getBytes();
            byte[] byteBill = bill.doFinal(byteMe); // pass in the message in byte form


            return byteBill;

        }catch (NoSuchAlgorithmException alg){
            alg.printStackTrace();
            return empty;
        }catch (NoSuchPaddingException pad) {
            System.out.println("No such Padding");
            return empty;
        }catch (InvalidKeyException invKey){
            System.out.println("Invalid Key");
            return empty;
        }catch (InvalidAlgorithmParameterException parm){
            System.out.println("Invalid algo Parameter");
            return empty;
        }catch (IllegalBlockSizeException blockSize){
            System.out.println("Illegal Block Size");
            return empty;
        }catch(BadPaddingException padding){
            System.out.println("Bad Padding");
            return empty;
        }
    }

    public String messageDecode(byte[] message, SecretKey sKey, byte[] vect){
        return decode(message,sKey, vect );
    }

    private String decode(byte[] message, SecretKey sKey, byte[] vect){
        String empty = "";
        try{
            // just like the encryption process ..
            Cipher bill = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            bill.init(Cipher.DECRYPT_MODE, sKey, new IvParameterSpec(vect));
            byte[] byteMe = bill.doFinal(message);
            return new String(byteMe);

        }catch (NoSuchAlgorithmException alg){
            alg.printStackTrace();
            return empty;
        }catch (NoSuchPaddingException pad) {
            System.out.println("No such Padding");
            return empty;
        }catch (InvalidKeyException invKey){
            System.out.println("Invalid Key");
            return empty;
        }catch (InvalidAlgorithmParameterException parm){
            System.out.println("Invalid algo Parameter");
            return empty;
        }catch (IllegalBlockSizeException blockSize){
            System.out.println("Illegal Block Size");
            return empty;
        }catch(BadPaddingException padding){
            System.out.println("Bad Padding");
            return empty;
        }
    }


    public SecretKey getKey(){
        return key;
    }
    public byte[] getIV(){
        return v;
    }


    /**
     *     public static void main(String ... args){
     Message_Passer MP = new Message_Passer();
     byte[] message = MP.messagePass("Sup");
     SecretKey mKey = MP.getKey();
     byte[] vectorBar = MP.getIV();
     Message_Passer Dec = new Message_Passer();
     String MESS = Dec.messageDecode(message, mKey, vectorBar);
     System.out.println(MESS);
     System.out.println(new String(message));

     }
     *
     */



}

