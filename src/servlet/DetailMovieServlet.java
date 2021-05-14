package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
import com.google.gson.reflect.TypeToken;

import entity.Filme;
import entity.Genres;

@WebServlet(name = "detailMovie", urlPatterns = "/viewFilmes/detailMovie")
public class DetailMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String apiKey = "?api_key=2e0ae99af7d2c9c2ae236f403d6c111c";
	private String URL = "https://api.themoviedb.org/3/movie/";
	private String language = "&language=pt-BR";

	public DetailMovieServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String x = "399566";
		String search = URL + x + apiKey + language;
		Filme objeto = ListarFilmes(search);
		System.out.println(search);
		request.setAttribute("detailMovie", objeto);

		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/movieDetail.jsp");
		rd.forward(request, response);
	}

	private Filme ListarFilmes(String sURL) throws IOException {
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

		Filme film = gson.fromJson(code, Filme.class);
		Normalizer(film);
		return film;
	}
	
	public void Normalizer(Filme x) {
		for(Genres y : x.getGenres()) {
			y.setName(y.getName().replaceAll("[^\\p{ASCII}]", ""));
		}
		int num = Integer.parseInt(x.getRuntime());
		x.setRuntime(num / 60 + "h " + num % 60 + "m");
		x.setOriginal_title(x.getOriginal_title().replaceAll("[^\\p{ASCII}]", ""));
		x.setOverview(x.getOverview().replaceAll("[^\\p{ASCII}]", ""));
	}
	
}
