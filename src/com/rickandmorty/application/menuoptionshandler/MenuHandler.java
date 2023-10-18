package com.rickandmorty.application.menuoptionshandler;

import com.rickandmorty.application.api.ConnectionApi;
import com.rickandmorty.application.jsondataconverter.ApiResponse;

import java.io.IOException;

public class MenuHandler {
    public static String menuHandler1(int optionSo, int optionEp) throws IOException, InterruptedException {
        ConnectionApi connectionApi = new ConnectionApi();

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
        ApiResponse apiResponse = ApiResponse.fromJson(responseEpSoComplet);
        return apiResponse.getEpisodeInfo();
    }

    public static String menuHandler2(String optionNameEp) throws IOException, InterruptedException {
        ConnectionApi connectionApi = new ConnectionApi();

        connectionApi.setEpisodeId(optionNameEp);
        String responseNameEp;
        responseNameEp = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?name=" + optionNameEp);
        System.out.println(responseNameEp);
        connectionApi.setAddress(responseNameEp);
        var responseEpSoComplet = ConnectionApi.apiCaller(connectionApi.getAddress());
        ApiResponse apiResponse = ApiResponse.fromJson(responseEpSoComplet);
        return apiResponse.getEpisodeInfo();
    }
}
