package com.code.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;


public class HttpClientGetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest  request = HttpRequest.newBuilder()
					.uri(URI.create("https://cricbuzz-cricket.p.rapidapi.com/schedule/v1/international"))
					.header("x-rapidapi-key", "fb802404c7msh710a2f6584f529ap134daajsn77e932b2a006")
					.build();
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			System.out.println("status code: " + response.statusCode());
			System.out.println("------------------------------------------------");
			System.out.println("headers: " + response.headers());
			System.out.println("------------------------------------------------");
			System.out.println("response body: " + response.body());
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	

}
