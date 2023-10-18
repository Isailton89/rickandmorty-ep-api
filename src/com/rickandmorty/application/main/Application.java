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
        int option = 0;
        String search = "";
        System.out.println("Seja bem vindo ao buscador de episódios Rick e Morty");
        String messageInitial = """
                Por favor digite o numero da opção que corresponde o seu tipo de busca
                \n1 - Buscar episódio e temporada.
                \n2 - Buscar por nome do episódio.
                \n3 - Listar espisódios por temporada.
                """;
        while (!search.equalsIgnoreCase("sair")){
            System.out.println(messageInitial);
            if (search.equalsIgnoreCase("sair")){
                break;
            }

            option = spell.nextInt();

            while (option > 0 || option < 4) {
                if (option == 1) {
                    System.out.println("Digite o número de um episódio:");
                    int optionEp = spell.nextInt();
                    connectionApi.setEpisode(optionEp);
                    System.out.println("Digite o número de uma temporada");
                    int optionSo = spell.nextInt();
                    connectionApi.setSeason(optionSo);
                    String responseEpSo;
                    if (optionSo <= 9 && optionSo >= 1 && optionEp <= 9 && optionEp >=1) {
                        responseEpSo = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?episode=S0" + optionSo + "E0" + optionEp);
                    } else {
                        responseEpSo = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?episode=S" + optionSo + "E" + optionEp);
                    }
                    System.out.println(responseEpSo);
                    connectionApi.setAddress(responseEpSo);
                    var responseEpSoComplet = ConnectionApi.apiCaller(connectionApi.getAddress());
                    System.out.println(responseEpSoComplet);
                    break;
                }
            }
        }
    }
}
/*
Buscar episodio e temporada
Buscar por nome do episódio
Buscar por temporada : requisição https://rickandmortyapi.com/api/episode?episode=S01
 */