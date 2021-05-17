package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.Elenco;
import entity.Genres;
import entity.Images;
import entity.TV;
import entity.Results;
import entity.VideosArray;

/**
 * Servlet implementation class DetailTVServlet
 */
@WebServlet(name = "detailTV", urlPatterns = "/viewFilmes/detailTV")
public class DetailTVServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String apiKey = "?api_key=2e0ae99af7d2c9c2ae236f403d6c111c";
	private String URL = "https://api.themoviedb.org/3/tv/";
	private String language = "&language=pt-BR";

	public DetailTVServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String x = request.getParameter("detailTV");
		String search = URL + x + apiKey + language;
		String searchImg = URL + x + "/images" + apiKey;
		String castString = URL + x + "/aggregate_credits" + apiKey + language;
		String videoString = URL + x + "/videos" + apiKey;

		TV objeto = ListTV(search);
		Images img = ListImages(searchImg);
		Elenco elenco = ListElenco(castString);
		VideosArray video = ListVideo(videoString);
		
		request.setAttribute("detailTV", objeto);
		request.setAttribute("imagesTV", img);
		request.setAttribute("castDetail", elenco);
		request.setAttribute("videosTV", video);

		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/tvDetail.jsp");
		rd.forward(request, response);
	}

	private VideosArray ListVideo(String sURL) throws IOException {
		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		URLConnection json = url.openConnection();
		json.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent())); // Convert the input stream
																								// to a json element
		JsonObject rootobj = root.getAsJsonObject(); // May be an array, may be an object.
		JsonElement code = rootobj; // Get value by code name

		Gson gson = new GsonBuilder().create();

		VideosArray film = gson.fromJson(code, VideosArray.class);
		return film;
	}

	private TV ListTV(String sURL) throws IOException {
		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		URLConnection json = url.openConnection();
		json.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent())); // Convert the input stream
																								// to a json element
		JsonObject rootobj = root.getAsJsonObject(); // May be an array, may be an object.
		JsonElement code = rootobj; // Get value by code name

		Gson gson = new GsonBuilder().create();

		TV film = gson.fromJson(code, TV.class);
		Normalizer(film);
		return film;
	}

	private Images ListImages(String sURL) throws IOException {
		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		URLConnection json = url.openConnection();
		json.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent())); // Convert the input stream
		// to a json element
		JsonObject rootobj = root.getAsJsonObject(); // May be an array, may be an object.
		JsonElement code = rootobj; // Get value by code name

		Gson gson = new GsonBuilder().create();

		Images imgs = gson.fromJson(code, Images.class);
		return imgs;
	}

	private Elenco ListElenco(String sURL) throws IOException {
		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		URLConnection json = url.openConnection();
		json.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser(); // from gson
		JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent())); // Convert the input stream
		// to a json element
		JsonObject rootobj = root.getAsJsonObject(); // May be an array, may be an object.
		JsonElement code = rootobj; // Get value by code name

		Gson gson = new GsonBuilder().create();

		Elenco elenco = gson.fromJson(code, Elenco.class);
		return elenco;
	}

	public void Normalizer(TV x) {
		for (Genres y : x.getGenres()) {
			y.setName(y.getName().replaceAll("[^\\p{ASCII}]", ""));
		}
		x.setTagline(x.getTagline().replaceAll("[^\\p{ASCII}]", ""));
		x.setOverview(x.getOverview().replaceAll("[^\\p{ASCII}]", ""));
	}

}
