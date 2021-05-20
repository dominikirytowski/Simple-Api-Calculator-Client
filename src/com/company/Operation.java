package com.company;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Operation{

    private static String url = "http://localhost:8080/labora10/resources/kalk/";


    String executeOperation(double a, double b, String operation) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        if(operation == "sqrt"){
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + operation + "/" + a))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }else {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + operation + "/" + a + "/" + b))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }

        }


}
