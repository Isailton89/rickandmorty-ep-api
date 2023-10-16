package com.rickandmorty.application.api;

public class ConnectionApi {
    private String episodeId;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
        this.address = "https://rickandmortyapi.com/api/episode/" + episodeId;
    }
}
