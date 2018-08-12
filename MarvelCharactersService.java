import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

import org.json.JSONArray;
import org.json.JSONObject;

public class MarvelCharactersService {
 
	public void getCharacters() throws Exception {
		StringBuilder content = new StringBuilder();
		BufferedReader in;
		HttpURLConnection con;
		int offset = 0;
		int limit = 100;
		//do {
			String url = "http://gateway.marvel.com/v1/public/characters?ts=1&apikey=518cc59dca9223c9c23c5a8a5d8ad2bf&hash=2a4f88f7a59d84debbfbc6547b864dd3&offset=" + offset + "&limit=" + limit;
			URL urlObj = new URL(url);
			con = (HttpURLConnection) urlObj.openConnection();
			// optional default is GET
			con.setRequestMethod("GET");
			//add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			if (offset <= 1400)
				offset = offset + limit;
			else
				offset = offset + 90;
			
		//} while (offset < limit);
		in.close();
		processCharacters(content.toString());		
	}
	
	public void processCharacters(String jsonString) {
		JSONObject response = new JSONObject(jsonString);
		ArrayList <MarvelCharacter> mcArray = new ArrayList<MarvelCharacter>();
		JSONObject data = response.getJSONObject("data");
		JSONArray results = data.getJSONArray("results");
		for (Object result : results) {		
			MarvelCharacter mc = new MarvelCharacter();
			JSONObject character = new JSONObject(result.toString());
			mc.setId(character.getInt("id"));
			JSONObject comicList = character.getJSONObject("comics");
			JSONObject storiesList = character.getJSONObject("stories");
			mc.setTotalComics(comicList.getInt("available"));
			mc.setTotalStories(storiesList.getInt("available"));
			mcArray.add(mc);
		}
		
		SortMarvelCharacters smc = new SortMarvelCharacters();
		smc.sort(mcArray);
		ArrayList <MarvelCharacter> sortedCharacters = smc.getSortedMarvelCharacterArray();
		ArrayList <Integer> sortedIds = new ArrayList<Integer>();
		JSONObject characters = new JSONObject();
		int comicsCount = 0;
		int storiesCount = 0;
		for (MarvelCharacter mc: sortedCharacters) {
			sortedIds.add(mc.getTotalAppearances());
			comicsCount = comicsCount + mc.getTotalComics();
			storiesCount = storiesCount + mc.getTotalStories();
		}
		characters.put("ids", sortedIds);
		characters.put("total_in_stories", storiesCount);
		characters.put("total_in_comics", comicsCount);
		characters.put("total", data.getInt("total"));
		
		
		System.out.println(characters.toString(4));
		//System.out.println("Count: " + count);
	}
	
}
