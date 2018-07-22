package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonProfile {

	String name;
	String job;

	public JsonProfile(String name, String job) {
		this.name = name; 
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
	
}
