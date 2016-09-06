package service.utils;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Password {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Logger LOGGER = Logger.getLogger(Password.class);


    public static String hash(String str) {
        MessageDigest digestCoding;
        StringBuffer hexPasString = new StringBuffer();
        try {
            digestCoding = MessageDigest.getInstance("MD5");

            digestCoding.update(str.getBytes("UTF-8"));
            for (byte d : digestCoding.digest()) {
                hexPasString.append(getFirstHxDigit(d)).append(getSecondHxDigit(d));
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            LOGGER.error("Error during getting hash from pass");
        }
        return hexPasString.toString();
    }

    private static char getFirstHxDigit(byte x) {
        return HEX_DIGITS[(0xFF & x) / 16];
    }

    private static char getSecondHxDigit(byte x) {
        return HEX_DIGITS[(0xFF & x) % 16];
    }

}