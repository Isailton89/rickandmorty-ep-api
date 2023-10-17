package com.rickandmorty.application.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionApi {
    private String episodeId;
    private String address;
    private String season;
    private String episode;

    public void setSeason(String season) {
        this.season = season;
        this.address = "https://rickandmortyapi.com/api/episode?episode=S0" + season +"E01";
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getAddress() {
        return address;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
        this.address = "https://rickandmortyapi.com/api/episode/" + episodeId;
    }

    public static String apiCaller(String apiAddress) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiAddress))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
