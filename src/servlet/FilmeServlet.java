package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.*;
import dao.*;
import java.util.*;

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
		String sURL = "https://api.themoviedb.org/3/trending/all/week?language=pt-BR&api_key=2e0ae99af7d2c9c2ae236f403d6c111c";

		// Connect to the URL using java's native library
		URL url = new URL(sURL);
		URLConnection json = url.openConnection();
		json.connect();

		Reader in = new InputStreamReader(getClass().getResourceAsStream("/WebContent/WEB-INF/text.txt") );
		// Convert to a JSON object to print data
		response.getWriter().append(in + "");
		JsonParser jp = new JsonParser();
		JsonElement root = jp.parse(new InputStreamReader((InputStream) json.getContent()));
		JsonObject rootobj = root.getAsJsonObject();
		JsonElement code = rootobj.get("results");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		// Convertendo um objeto Java para JSON e retorna uma String JSON formatada.
		String JsonConvertido = gson.toJson(code);
		
		JSONObject jsonObjectFilmes = new JSONObject(JsonConvertido);

		List<Filme> listaFilmes = new ArrayList<Filme>();

		Iterator<String> iteratorFilmes = jsonObjectFilmes.keys();

		while (iteratorFilmes.hasNext()) {
			JSONObject dadosFilmes = jsonObjectFilmes.getJSONObject(iteratorFilmes.next());

			Filme filmes = new Filme();
			filmes.setOriginal_title(dadosFilmes.getString("original_title"));
			filmes.setTitle(dadosFilmes.getString("title"));
			filmes.setMedia_type(dadosFilmes.getString("media_type"));
			filmes.setOriginal_language(dadosFilmes.getString("original_language"));
			filmes.setOverview(dadosFilmes.getString("overview"));
			filmes.setPoster_path(dadosFilmes.getString("poster_path"));
			filmes.setRelease_date(java.sql.Date.valueOf((dadosFilmes.getString("release_date"))));
			filmes.setVote_average(dadosFilmes.getDouble("vote_average"));

			listaFilmes.add(filmes);
			filmeDao.AddFilmes(filmes);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
