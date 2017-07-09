package com.mail.blackbox.my_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 블로그, 뉴스, 책, 백과사전, 카페글, 지식인, 웹문서, 이미지, 전문자료
 */

public class NaverAPIExamSearchBlog2 {

    public static void main(String[] args) {
        String clientId = "eSez1gcGAZUzO3T_T4MR";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "kEYHr3ZNAd";//애플리케이션 클라이언트 시크릿값";
        try {
            String text = URLEncoder.encode("c언어", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/blog?display=20&query="+ text + ""; // json 결과
//            String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//            con.setRequestProperty("encoding", "euc-kr");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
            	System.out.println("error");
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            System.out.println(response.toString());
            System.out.println();
            System.out.println();
            
            ObjectMapper mapper = new ObjectMapper();
            
            HashMap<String, Object> map = new HashMap<>();
            ArrayList<HashMap<String, Object>> list = new ArrayList<>();
            mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            map = mapper.readValue(response.toString(), new TypeReference<HashMap<String, Object>>()
			{
			});
//            System.out.println(mapper.writeValueAsString(list));
            System.out.println(map);
            for(String key : map.keySet()){
            	if(key.equals("items")){
//            		String transformedText = ParserOutput.replace('""', '"');
            		System.out.println(map.get(key));
            		list = mapper.readValue(mapper.writeValueAsString(map.get(key)), new TypeReference<ArrayList<HashMap<String, Object>>>()
					{
					});
            	}
            }
            System.out.println(list.get(0));
            
//            System.out.println();
            
            
            
            
//            JSONParser parser = new JSONParser();
//            JSONObject object = (JSONObject)parser.parse(response.toString());
//            JSONArray items = (JSONArray)object.get("items");
//            
//            int size = items.size();
//            for(int i = 0; i < size; i++){
//            	JSONObject tempObj = (JSONObject)items.get(i);
//            	System.out.println("title : " + tempObj.get("title"));
//            	System.out.println("postdate : " + tempObj.get("postdate"));
//            	System.out.println("link : " + tempObj.get("link"));
//            	System.out.println("description : " + tempObj.get("description"));
//            	System.out.println("blogname : " + tempObj.get("bloggername"));
//            	System.out.println("bloggerlink : " + tempObj.get("bloggerlink"));
//            	System.out.println("###########################################");
//            	
//            }
//            System.out.println(size);
//            NodeList titleNodeList = 
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

	public static String isoToEuc(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("ISO-8859-1"), "EUC-KR");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
	public static String isoToUtf(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
	
	public static String utfToMs(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("UTF-8"), "MS949");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
	
	public static String msToUtf(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("MS949"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
	
	public static String utfToEuc(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
	
	public static String eucToUtf(String tmp) {
		String euc = "";
		try {
			if(tmp != null)
				euc = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return euc;
	}
}