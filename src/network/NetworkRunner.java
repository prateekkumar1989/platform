package network;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import gson.JsonDb;
import gson.JsonProfile;

public class NetworkRunner {

	public static void main(String[] args) {

		JsonDb jsonDb = HttpClient.doGet("https://my-json-server.typicode.com/typicode/demo/db", JsonDb.class);
		System.out.println(jsonDb.toString());
		
		JsonProfile jsonProfile = HttpClient.doGet("https://my-json-server.typicode.com/typicode/demo/profile", JsonProfile.class);
		System.out.println(jsonProfile.toString());
		
		JsonProfile jsonProfilePost = HttpClient.doPost("https://my-json-server.typicode.com/typicode/demo/profile", new JsonProfile("pk", "dev"), JsonProfile.class);
		System.out.println(jsonProfilePost.toString());
		
		JsonProfile jsonProfileGet = HttpClient.doGet("https://my-json-server.typicode.com/typicode/demo/profile", JsonProfile.class);
		System.out.println(jsonProfileGet.toString());
		
		JsonElement jsonPk = HttpClient.doPost("https://reqres.in/api/users", new JsonProfile("pk", "dev"), JsonElement.class);
		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(jsonPk));
	}
}
