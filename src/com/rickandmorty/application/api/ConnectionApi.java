package com.rickandmorty.application.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionApi {
    private String episodeId;
    private String address;
    private int season;
    private int episode;

    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public String getAddress() {
        return address;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public static String apiCaller(String apiAddress){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiAddress))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return response.body();
    }
}