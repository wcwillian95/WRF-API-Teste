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
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import entity.TmdbRecomendados;
import modal.ListaFilmes;

/**
 * Servlet implementation class ServletSearch
 */
@WebServlet(name = "search", urlPatterns = { "/viewFilmes/search" })
public class ServletSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String apiKey = "2e0ae99af7d2c9c2ae236f403d6c111c";
	private String URL = "https://api.themoviedb.org/3/search/movie?api_key=";
	private String language = "&language=pt-BR";
	private String query = "&query=";
	private String page = "&page=1";
	private ListaFilmes listaFilmes;

	public ServletSearch() {
		this.listaFilmes = new ListaFilmes();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String x = request.getParameter("search").replace(" ", "%20");

		String search = URL + apiKey + language + query + x + page + "&include_adult=false";
		System.out.println(search);
		ListarFilmes(search);
		ArrayList<TmdbRecomendados> lista = listaFilmes.ListaFilmes();
		request.setAttribute("listaPesquisa", lista);
		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/search.jsp");
		rd.forward(request, response);
	}

	private void ListarFilmes(String sURL) throws IOException {
		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		URLConnection json = url.openConnection();
		json.connect();

		// Convert to a JSON object to print data
		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent()));// {"items":[{"id":"tt0111161"
		JsonObject rootobj = root.getAsJsonObject();
		JsonElement code = rootobj;
		Gson gson = new GsonBuilder().create();
		JsonArray jsonArray = rootobj.getAsJsonArray("results");

		// Array de filmes convertido para Array
		TmdbRecomendados[] arrayFilmes = gson.fromJson(jsonArray, TmdbRecomendados[].class);

		listaFilmes.LimparLista();

		// Adicionando filmes para uma lista e salvando no banco
		for (int i = 0; i < arrayFilmes.length; i++) {
			TmdbRecomendados rec = new TmdbRecomendados();
			rec.setId(arrayFilmes[i].getId());
//					rec.setGenre_ids(arrayFilmes[i].getGenre_ids());
			rec.setMedia_type(arrayFilmes[i].getMedia_type());
			rec.setOriginal_language(arrayFilmes[i].getOriginal_language());
			if (arrayFilmes[i].getOriginal_title() == null) {
				rec.setOriginal_title(arrayFilmes[i].getOriginal_name());
			}
			rec.setOriginal_title(arrayFilmes[i].getOriginal_title());
			rec.setOverview(arrayFilmes[i].getOverview());
			rec.setPoster_path(arrayFilmes[i].getPoster_path());
			rec.setRelease_date(arrayFilmes[i].getRelease_date());
			rec.setVote_average(arrayFilmes[i].getVote_average());
			rec.setOriginal_name(arrayFilmes[i].getOriginal_name());

			Normalizer(rec);
			listaFilmes.AddListaFilmes(rec);
		}
	}
	
	public void Normalizer(TmdbRecomendados x) {
		x.setOriginal_language(x.getOriginal_language().replaceAll("[^\\p{ASCII}]", ""));
		x.setOverview(x.getOverview().replaceAll("[^\\p{ASCII}]", ""));
		x.setOriginal_title(x.getOriginal_title().replaceAll("[^\\p{ASCII}]", ""));
	}

}
