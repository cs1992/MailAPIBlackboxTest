package com.mail.blackbox.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class UtilFunction {

	public static String request(String apiURL, List<NameValuePair> params) {
		String result = null;

		try {
			HttpClient client = HttpClientBuilder.create().build();
			URI uri = new URI(apiURL);
			HttpPost post = new HttpPost(uri);

			UrlEncodedFormEntity ent = new UrlEncodedFormEntity(params, HTTP.UTF_8);
			post.setEntity(ent);
			HttpResponse httpPost = client.execute(post);
			HttpEntity entity = httpPost.getEntity();
			result = EntityUtils.toString(entity);

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
