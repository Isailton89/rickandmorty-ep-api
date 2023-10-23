package com.rickandmorty.application.menuoptionshandler;

import com.rickandmorty.application.api.ConnectionApi;
import com.rickandmorty.application.jsondataconverter.ApiResponse;

public class MenuHandler {
    public static String menuHandler1(int optionSo, int optionEp){
        ConnectionApi connectionApi = new ConnectionApi();
        String responseEpSo;

        connectionApi.setSeason(optionSo);
        if (optionSo <= 9 && optionSo >= 1 && optionEp <= 9 && optionEp >=1) {
            responseEpSo = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?episode=S0" + optionSo + "E0" + optionEp);
        } else {
            responseEpSo = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?episode=S" + optionSo + "E" + optionEp);
        }
        connectionApi.setAddress(responseEpSo);
        var responseEpSoComplet = ConnectionApi.apiCaller(connectionApi.getAddress());
        ApiResponse apiResponse = ApiResponse.fromJson(responseEpSoComplet);
        return apiResponse.getEpisodeInfo();
    }

    public static String menuHandler2(String optionNameEp){
        ConnectionApi connectionApi = new ConnectionApi();
        String responseNameEp;

        connectionApi.setEpisodeId(optionNameEp);
        responseNameEp = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?name=" + optionNameEp);
        connectionApi.setAddress(responseNameEp);
        var responseEpSoComplet = ConnectionApi.apiCaller(connectionApi.getAddress());
        ApiResponse apiResponse = ApiResponse.fromJson(responseEpSoComplet);
        return apiResponse.getEpisodeInfo();
    }

    public static String menuHandler3(int optionSo){
        ConnectionApi connectionApi = new ConnectionApi();
        String responseSo;

        connectionApi.setSeason(optionSo);
        if (optionSo <= 9 && optionSo >= 1) {
            responseSo = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?episode=S0" + optionSo);
        } else {
            responseSo = connectionApi.setAddress("https://rickandmortyapi.com/api/episode?episode=S" + optionSo);
        }
        connectionApi.setAddress(responseSo);
        var responseSoComplet = ConnectionApi.apiCaller(connectionApi.getAddress());
        ApiResponse apiResponse = ApiResponse.fromJson(responseSoComplet);
        return apiResponse.getEpisodeInfo();
    }
}
