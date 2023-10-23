package com.rickandmorty.application.jsondataconverter;

import com.google.gson.Gson;

public class ApiResponse {
    EpisodeResult[] results;

    public static ApiResponse fromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, ApiResponse.class);
    }

    public String getEpisodeInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        if (results != null) {
            for (EpisodeResult episodeResult : results) {
                String episodeName = episodeResult.name();
                String airDate = episodeResult.air_date();
                stringBuilder.append("\nEpisódio: ").append(episodeName).append("\nData de Lançamento: ").append(airDate).append("\n ");
            }
        }else {
            stringBuilder.append("Nenhum episódio encontrado!");
        }
        return stringBuilder.toString();
    }
}
