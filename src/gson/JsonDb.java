package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDb {

	JsonPost[] posts;
	JsonComment[] comments;
	JsonProfile profile;
	
	public JsonPost[] getPosts() {
		return posts;
	}
	
	public void setPosts(JsonPost[] posts) {
		this.posts = posts;
	}
	
	public JsonComment[] getComments() {
		return comments;
	}
	
	public void setComments(JsonComment[] comments) {
		this.comments = comments;
	}
	
	public JsonProfile getProfile() {
		return profile;
	}
	
	public void setProfile(JsonProfile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this);
	}
	
}
