import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class GetMarvelCharacters {
 
	public void getCharacters() throws Exception {
		String url = "http://gateway.marvel.com/v1/public/characters?ts=1&apikey=518cc59dca9223c9c23c5a8a5d8ad2bf&hash=2a4f88f7a59d84debbfbc6547b864dd3";
		URL urlObj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		// optional default is GET
		con.setRequestMethod("GET");
		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuilder content = new StringBuilder();
		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		processCharacters(content.toString());		
	}
	
	public void processCharacters(String jsonString) {
		JSONObject response = new JSONObject(jsonString);
		ArrayList <Integer> ids = new ArrayList <Integer>();
		
		JSONObject data = response.getJSONObject("data");
		JSONArray results = data.getJSONArray("results");
		int comicsCount = 0;
		int storiesCount = 0;
		for (Object result : results) {		
			JSONObject character = new JSONObject(result.toString());
			ids.add(character.getInt("id"));
			JSONObject comicList = character.getJSONObject("comics");
			JSONObject storiesList = character.getJSONObject("stories");
			comicsCount = comicsCount + comicList.getInt("available");
			storiesCount = storiesCount + storiesList.getInt("available");
			
		}
		
		JSONObject characters = new JSONObject();
				
		characters.put("total_in_stories", storiesCount);
		characters.put("total_in_comics", comicsCount);
		characters.put("total", data.getInt("total"));
		characters.put("ids", ids);
		
		System.out.println(characters.toString(4));
		//System.out.println("Count: " + count);
	}
	
}
