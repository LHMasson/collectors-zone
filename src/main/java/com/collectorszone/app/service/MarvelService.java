package com.collectorszone.app.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@ConfigurationProperties(prefix = "api")
public class MarvelService {

    private final String publicMarvelApiKey;
    private final String privateMarvelApiKey;
    private static final String MARVEL_API_URL = "https://gateway.marvel.com/v1/public/";

    public MarvelService() {
        Dotenv dotenv = Dotenv.load();
        this.publicMarvelApiKey = dotenv.get("MARVEL_PUBLIC_KEY");
        this.privateMarvelApiKey = dotenv.get("MARVEL_PRIVATE_KEY");
    }

    private String generateAPIHash(long timestamp) {
        String input = timestamp + privateMarvelApiKey + publicMarvelApiKey;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(input.getBytes());
            StringBuilder hashString = new StringBuilder();
            for (byte b : hashBytes) {
                hashString.append(String.format("%02x", b));
            }
            return hashString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar o hash MD5", e);
        }
    }

    public String buildApiUrl(String method) {
        long timestamp = System.currentTimeMillis();
        return UriComponentsBuilder.fromHttpUrl(MARVEL_API_URL + method)
                .queryParam("ts", timestamp)
                .queryParam("apikey", publicMarvelApiKey)
                .queryParam("hash", generateAPIHash(timestamp))
                .toUriString();
    }
}
