package fr.thomasdelecluse.portfolio.api.service;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.math.BigInteger;

@Service
public class TokenService {
    private SecureRandom random = new SecureRandom();

    public String nextToken() {
        return new BigInteger(130, random).toString(32);
    }
}




