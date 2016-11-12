import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GithubSearch {

	private static OkHttpClient client = new OkHttpClient();

	public static void main(String[] args) throws Exception {
		String searchTerm = getCLIArgs(args);

		String endpoint = "https://api.github.com/search/repositories?q=" + searchTerm;

		String results = getData(endpoint);
		//System.out.println(results);

		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse(results).getAsJsonObject();
		
		int totalCount = o.get("total_count").getAsInt();
		if(totalCount == 0) {
			System.out.println("Sorry, there were no results");
			System.exit(1);
		}
		
		JsonArray items = o.get("items").getAsJsonArray();
		System.out.println("  => Total results: " + totalCount);
		System.out.println();
		//System.out.println(items);
		
		List<Repository> repos = new ArrayList<>();
		int count = 0;
		for(JsonElement elem : items) {
			JsonObject object = parser.parse(elem.toString())
					.getAsJsonObject();
			try {
				String name = object.get("name").getAsString();
				String url = object.get("html_url").getAsString();
				String description = "";
				if(object.has("description")) {
					description = object.get("description").getAsString();
				}
					
				repos.add(new Repository(name, url, description));
			} catch (Exception e) {
				//System.out.println(e);
			}
			
			count++;
			if(count > 4) {
				break;
			}
		}
		
		for(Repository repo : repos) {
			System.out.println(repo.toString());
			System.out.println();
		}
	}

	private static String getCLIArgs(String[] args) throws ParseException {
		Options options = new Options();
		options.addOption("q", true, "repository search term");
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);
		if (!cmd.hasOption("q")) {
			System.out.println("Please enter a search term (-q)");
			System.exit(1);
		}

		String searchTerm = cmd.getOptionValue("q");
		System.out.printf("searching for => \"%s\" ... \n", searchTerm);

		if (searchTerm == null || searchTerm.equals("") || searchTerm.length() < 3) {
			System.out.println("Sorry your search term may not be empty or less than 3 chars");
			System.exit(1);
		}
		return searchTerm;
	}

	private static String getData(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		Response response = client.newCall(request).execute();
		return response.body().string();
	}
	
	public static class Repository {
		public String name;
		public String url;
		public String description;
		
		public Repository(String name, String url, String description) {
			super();
			this.name = name;
			this.url = url;
			this.description = description;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Name: " + name + "\n");
			builder.append("Url:  " + url + "\n");
			String tmpDescription = description;
			if(description != null && description.length() > 120) {
				tmpDescription = description.substring(0, 120);
			}
			
			builder.append("Description: " + tmpDescription + "\n");
			return builder.toString();
		}
		
	}

}
