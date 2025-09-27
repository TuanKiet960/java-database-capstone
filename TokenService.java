package com.project_back_end.services;

import java.util.Date;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Mac;

/**
 * Placeholder TokenService - simple HMAC-based token example.
 * In a real project you would use a robust library (e.g. jjwt) and proper secret management.
 */
public class TokenService {
    private final String secret = "change_this_secret_to_secure_value";
    private final String HMAC_ALGO = "HmacSHA256";

    public String generateToken(String subject) {
        try {
            long now = System.currentTimeMillis();
            String payload = subject + ":" + now;
            Mac hmac = Mac.getInstance(HMAC_ALGO);
            SecretKeySpec key = new SecretKeySpec(secret.getBytes("UTF-8"), HMAC_ALGO);
            hmac.init(key);
            byte[] sig = hmac.doFinal(payload.getBytes("UTF-8"));
            String token = Base64.getUrlEncoder().withoutPadding().encodeToString((payload + ":" + Base64.getUrlEncoder().withoutPadding().encodeToString(sig)).getBytes("UTF-8"));
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate token", e);
        }
    }

    public boolean validateToken(String token) {
        try {
            String decoded = new String(Base64.getUrlDecoder().decode(token), "UTF-8");
            String[] parts = decoded.split(":");
            if (parts.length < 3) return false;
            String subject = parts[0];
            String timestamp = parts[1];
            String sigProvided = parts[2];

            String payload = subject + ":" + timestamp;
            Mac hmac = Mac.getInstance(HMAC_ALGO);
            SecretKeySpec key = new SecretKeySpec(secret.getBytes("UTF-8"), HMAC_ALGO);
            hmac.init(key);
            byte[] sig = hmac.doFinal(payload.getBytes("UTF-8"));
            String sigCalc = Base64.getUrlEncoder().withoutPadding().encodeToString(sig);

            return sigCalc.equals(sigProvided);
        } catch (Exception e) {
            return false;
        }
    }
}
