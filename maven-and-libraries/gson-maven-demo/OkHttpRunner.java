import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpRunner {

    public static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws Exception {
        // I found this URL in this node library:
        // https://github.com/pat310/google-trends-api/blob/master/src/utils/hotTrends.js

        String result = run("http://hawttrends.appspot.com/api/terms/");
        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(result).getAsJsonObject();
        
        // map 
        //   -> arrays
        Map<Integer, List<String>> trends = new TreeMap<>();
        
        for(Entry<String, JsonElement> entry : o.entrySet()) {
        	Integer key = Integer.parseInt(entry.getKey());
        	List<String> values = new ArrayList<>();
        	
        	for(JsonElement element : entry.getValue().getAsJsonArray()) {
        		String trend = element.getAsString();
        		values.add(trend);
        	}
        	
        	trends.put(key, values);
        }
        
        //System.out.println(trends);
        for(Integer key : trends.keySet()) {
        	System.out.println("Key: " + key);
        	System.out.println(" --> Top trend 1: " + trends.get(key).get(0));
        	System.out.println(" --> Top trend 2: " + trends.get(key).get(1));
        	
        }
    }

    // you can do this in vanilla java but a good library makes it WAY WAY WAY easier!
    private static String run(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }


}
