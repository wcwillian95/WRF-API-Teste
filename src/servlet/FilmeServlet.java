package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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

import dao.FilmeDao;
import entity.Filme;

@WebServlet(name = "filmez", urlPatterns = "/viewFilmes/filmez")
public class FilmeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmeDao filmeDao;

	public FilmeServlet() {
		this.filmeDao = new FilmeDao();
	}

//  private static HttpURLConnection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Filme> lista = filmeDao.selectAllFilmes();
//		response.getWriter().print(lista);
		request.setAttribute("listaFilmes", lista);

		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/exibeFilmes.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sURL = "https://imdb-api.com/en/API/Top250Movies/k_jw6z7bdy";

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
		JsonArray jsonArray = rootobj.getAsJsonArray("items");

		Filme[] arrayFilmes = gson.fromJson(jsonArray, Filme[].class);
		response.getWriter().append(Arrays.asList(arrayFilmes) + "");

		// Convertendo um objeto Java para JSON e retorna uma String JSON formatada.
//		String JsonConvertido = gson.toJson(code);
//
//		JSONArray jsonObjectFilmes = new JSONArray(JsonConvertido);
//
		List<Filme> listaFilmes = new ArrayList<Filme>();
//
//		System.out.println(arrayFilmes);
//		Iterator<String> iteratorFilmes = jsonObjectFilmes;
//
		for (int i = 0; i < arrayFilmes.length; i++) {
			Filme filmes = new Filme();
			filmes.setId(arrayFilmes[i].getId());
			filmes.setRank(arrayFilmes[i].getRank());
			filmes.setTitle(arrayFilmes[i].getTitle());
			filmes.setFullTitle(arrayFilmes[i].getFullTitle());
			filmes.setYear(arrayFilmes[i].getYear());
			filmes.setImage(arrayFilmes[i].getImage());
			filmes.setCrew(arrayFilmes[i].getCrew());
			filmes.setImDbRating(arrayFilmes[i].getImDbRating());
			filmes.setImDbRatingCount(arrayFilmes[i].getImDbRatingCount());

			listaFilmes.add(filmes);
			System.out.println(listaFilmes);
			filmeDao.AddFilmes(filmes);

		}
//			JSONObject dadosFilmes = jsonObjectFilmes.getJSONObject(iteratorFilmes.next());
//			response.getWriter().append(dadosFilmes + "");

//		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
