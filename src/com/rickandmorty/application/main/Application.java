package com.rickandmorty.application.main;

import com.rickandmorty.application.api.ConnectionApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConnectionApi connectionApi = new ConnectionApi();
        Scanner spell = new Scanner(System.in);
        String search = "";
        search = spell.nextLine();
        connectionApi.setEpisodeId(search);
        System.out.println(connectionApi.getAddress());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(connectionApi.getAddress()))
                                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String teste = response.body();
        System.out.println(teste);

        String teste3;
        teste3 = spell.nextLine();
        connectionApi.setEpisodeId(teste3);
        String responseData = ConnectionApi.apiCaller(connectionApi.getAddress());
        System.out.println(responseData);

        String teste4;
        teste4 = spell.nextLine();
        connectionApi.setEpisode(teste4);
        responseData = ConnectionApi.apiCaller(connectionApi.getAddress());
        System.out.println(responseData);
    }
}