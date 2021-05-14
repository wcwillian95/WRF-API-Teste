import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.Filme;

public class MainTeste {

	public static void main(String[] args) {
		 String apiKey = "?api_key=2e0ae99af7d2c9c2ae236f403d6c111c";
		 String URL = "https://api.themoviedb.org/3/movie/";
		 String language = "&language=pt-BR";
		 
			String x = "399566";
			String search = URL + x + apiKey + language;
			System.out.println(search);
	}
	
	private void ListarFilmes(HttpServletResponse response, String sURL) throws IOException {
		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		URLConnection json = url.openConnection();
		json.connect();


		// Convert to a JSON object to print data
	    JsonParser jp = new JsonParser(); //from gson
	    JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent())); //Convert the input stream to a json element
	    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
	    JsonElement code = rootobj; // Get value by code name

	   Gson gson = new GsonBuilder().create();
	   
	   //Convertendo um objeto Java para JSON e retorna uma String JSON formatada.
	   String JsonConvertido = gson.toJson(code);
	   response.getWriter().append(JsonConvertido);
	   
	   JSONObject jsonObjectdados = new JSONObject(JsonConvertido);

//	   Iterator<String> iteratordados = jsonObjectdados.keys();
//	   while (iteratordados.hasNext()) {
//		      JSONObject dadosFilme = jsonObjectdados.getJSONObject(iteratordados.next());
//		      Filme dados = new Filme();
//		      dados.setId(dadosFilme.getString("id"));
//		      dados.setBackdrop_path(dadosFilme.getString("backdrop_path"));
//		      dados.setBudget(dadosFilme.getString("budget"));
//		      dados.setHomepage(dadosFilme.getString("homepage"));
//		      dados.setOriginal_language(dadosFilme.getString("original_language"));
//		      dados.setOriginal_title(dadosFilme.getString("original_title"));
//		      dados.setOverview(dadosFilme.getString("overview"));
//		      dados.setPoster_path(dadosFilme.getString("poster_path"));
//		      dados.setRelease_date(dadosFilme.getString("release_date"));
//		      dados.setRevenue(dadosFilme.getString("revenue"));
//		      dados.setRuntime(dadosFilme.getString("runtime"));
//		      dados.setStatus(dadosFilme.getString("status"));
//		      dados.setTagline(dadosFilme.getString("tagline"));
//		      dados.setTitle(dadosFilme.getString("title"));
//		      dados.setVote_average(dadosFilme.getString("vote_average"));
//
//		      listFilmeDetail.AddListaFilmes(dados);
//		   }  
	}
}
