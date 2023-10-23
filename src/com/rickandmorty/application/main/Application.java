package com.rickandmorty.application.main;

import com.rickandmorty.application.api.ConnectionApi;
import com.rickandmorty.application.menuoptionshandler.MenuHandler;

import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        ConnectionApi connectionApi = new ConnectionApi();
        Scanner spell = new Scanner(System.in);
        String search = "";
        System.out.println("Seja bem vindo ao buscador de episódios Rick e Morty");
        String messageInitial = """
                Por favor digite o numero da opção que corresponde ao seu tipo de busca
                1 - Buscar episódio e temporada.
                2 - Buscar por nome do episódio.
                3 - Listar espisódios por temporada.
                """;
        while (!search.equalsIgnoreCase("sair")) {
            System.out.println(messageInitial);
            search = spell.nextLine();
            if (search.equalsIgnoreCase("sair")) {
                break;
            }

            if (search.equalsIgnoreCase("1")) {
                System.out.println("Digite o número de um episódio:");
                int optionEp = spell.nextInt();
                connectionApi.setEpisode(optionEp);
                System.out.println("Digite o número de uma temporada");
                int optionSo = spell.nextInt();
                System.out.println(MenuHandler.menuHandler1(optionSo, optionEp));
                break;
            } else if (search.equalsIgnoreCase("2")) {
                System.out.println("Digite o nome do episódio:");
                String optionNameEp = spell.nextLine();
                connectionApi.setEpisodeId(optionNameEp);
                System.out.println(MenuHandler.menuHandler2(optionNameEp));
                break;
            } else if (search.equalsIgnoreCase("3")) {
                System.out.println("Digite a temporada que deseja listar:");
                int optionNameSo = spell.nextInt();
                connectionApi.setSeason(optionNameSo);
                System.out.println(MenuHandler.menuHandler3(optionNameSo));
                break;
            } else {
                System.out.println("Por favor digite uma opção válida!");
            }
        }
    }
}
/*
Buscar episodio e temporada
Buscar por nome do episódio
Buscar por temporada : requisição https://rickandmortyapi.com/api/episode?episode=S01
 */