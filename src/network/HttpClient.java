package network;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class HttpClient {

	private static final CloseableHttpClient client;
	static {
		client = HttpClientBuilder.create().build();
	}
		
	public static <T> T doGet(String url, Class<T> resultClass) {
		
		HttpGet httpGet = new HttpGet(url);
		String responseBody = null;
		try {
			HttpResponse response = client.execute(httpGet);
			responseBody = EntityUtils.toString(response.getEntity());
			assert response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpGet.releaseConnection();
        }
		
		return new Gson().fromJson(responseBody, resultClass);
	}
	
	public static <T> T doPost(String url, Object object, Class<T> resultClass) {
		
		HttpPost httpPost = new HttpPost(url);
		String responseBody = null;
		try {
			Gson gson = new Gson();
            String json = gson.toJson(object, object.getClass());
            httpPost.addHeader("content-type", "application/json");
            httpPost.setEntity(new StringEntity(json, "UTF-8"));
			HttpResponse response = client.execute(httpPost);
			responseBody = EntityUtils.toString(response.getEntity());
			assert response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpPost.releaseConnection();
        }
		
		return new Gson().fromJson(responseBody, resultClass);
	}
}
