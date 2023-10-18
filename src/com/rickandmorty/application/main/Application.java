package com.rickandmorty.application.main;

import com.rickandmorty.application.api.ConnectionApi;
import com.rickandmorty.application.menuoptionshandler.MenuHandler;

import java.io.IOException;
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
                1 - Buscar episódio e temporada.
                2 - Buscar por nome do episódio.
                3 - Listar espisódios por temporada.
                """;
        while (!search.equalsIgnoreCase("sair")){
            System.out.println(messageInitial);
            search = spell.nextLine();
            if (search.equalsIgnoreCase("sair")){
                break;
            }
            option = spell.nextInt();
            spell.nextLine();
            while (option > 0 && option < 4) {
                if (option == 1) {
                    System.out.println("Digite o número de um episódio:");
                    int optionEp = spell.nextInt();
                    connectionApi.setEpisode(optionEp);
                    System.out.println("Digite o número de uma temporada");
                    int optionSo = spell.nextInt();
                    System.out.println(MenuHandler.menuHandler1(optionSo,optionEp));
                    break;
                } else if (option == 2) {
                    System.out.println("Digite o nome do episódio:");
                    String optionNameEp = spell.nextLine();
                    connectionApi.setEpisodeId(optionNameEp);
                    System.out.println(MenuHandler.menuHandler2(optionNameEp));
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