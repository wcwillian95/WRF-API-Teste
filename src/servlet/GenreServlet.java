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

import dao.GenreDao;
import entity.Genero;

@WebServlet(name = "generos", urlPatterns = "/viewFilmes/generos")
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GenreDao genreDao;

	public GenreServlet() {
		this.genreDao = new GenreDao();
	}

//  private static HttpURLConnection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Genero> lista = genreDao.selectAllGenres();
//		response.getWriter().print(lista);
		request.setAttribute("listaGenres", lista);

		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/exibeFilmes.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sURL = "https://api.themoviedb.org/3/genre/movie/list?api_key=2e0ae99af7d2c9c2ae236f403d6c111c&language=en-US";

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
		JsonArray jsonArray = rootobj.getAsJsonArray("genres");

		Genero[] arrayGeneros = gson.fromJson(jsonArray, Genero[].class);
		response.getWriter().append(Arrays.asList(arrayGeneros) + "");

		// Convertendo um objeto Java para JSON e retorna uma String JSON formatada.
//		String JsonConvertido = gson.toJson(code);
//
//		JSONArray jsonObjectFilmes = new JSONArray(JsonConvertido);
//
		ArrayList<Genero> listaVerifica = genreDao.selectAllGenres();
		List<Genero> listaGeneros = new ArrayList<Genero>();
		for (int i = 0; i < arrayGeneros.length; i++) {
			Genero generos = new Genero();
			generos.setId(arrayGeneros[i].getId());
			generos.setName(arrayGeneros[i].getName());

			listaGeneros.add(generos);
			genreDao.AddFilmes(generos);


		}
		System.out.println(listaGeneros);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
