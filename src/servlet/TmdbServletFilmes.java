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

import dao.TmdbRecomendadosDao;
import entity.TmdbRecomendados;
import modal.ListaEmAlta;
import modal.ListaFilmes;
import modal.ListaOriginais;

@WebServlet(name = "recomendados", urlPatterns = "/viewFilmes/recomendados")
public class TmdbServletFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TmdbRecomendadosDao recDao;
	private ListaFilmes listaFilmes;
	private ListaEmAlta listaEmAlta;
	private ListaOriginais listaOriginais;
	private String classFilme;

	public TmdbServletFilmes() {
		this.recDao = new TmdbRecomendadosDao();
		this.listaFilmes = new ListaFilmes();
		this.listaEmAlta = new ListaEmAlta();
		this.listaOriginais = new ListaOriginais();
	}

//  private static HttpURLConnection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String emAlta = "https://api.themoviedb.org/3/movie/popular?api_key=2e0ae99af7d2c9c2ae236f403d6c111c&language=pt-BR&page=1";
		String recomendados = "https://api.themoviedb.org/3/trending/all/week?language=pt-BR&api_key=2e0ae99af7d2c9c2ae236f403d6c111c";
		String originais = "https://api.themoviedb.org/3/discover/tv?with_network=213&language=pt-BR&api_key=2e0ae99af7d2c9c2ae236f403d6c111c";

		ListarFilmes(recomendados, classFilme = "recomendados");
		ArrayList<TmdbRecomendados> lista = listaFilmes.ListaFilmes();
		request.setAttribute("listaRecomendados", lista);

		ListarFilmes(emAlta, classFilme = "emAlta");
		ArrayList<TmdbRecomendados> lista2 = listaEmAlta.ListaFilmes();
		request.setAttribute("listaEmAlta", lista2);

		ListarFilmes(originais, classFilme = "originais");
		ArrayList<TmdbRecomendados> lista3 = listaOriginais.ListaFilmes();
		request.setAttribute("listaOriginais", lista3);

		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	private void ListarFilmes(String sURL, String classMovie) throws IOException {
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

		// Lista para comparar cadastros no banco
//		ArrayList<TmdbRecomendados> listaVerifica = recDao.selectAllrecs();

		if (classMovie == "recomendados") {
			listaFilmes.LimparLista();
		} else if (classMovie == "emAlta") {
			listaEmAlta.LimparLista();
		} else if (classMovie == "originais") {
			listaOriginais.LimparLista();
		}

		// Adicionando filmes para uma lista e salvando no banco
		for (int i = 0; i < arrayFilmes.length; i++) {
			TmdbRecomendados rec = new TmdbRecomendados();
			rec.setId(arrayFilmes[i].getId());
			rec.setMedia_type(arrayFilmes[i].getMedia_type());
			rec.setOriginal_language(arrayFilmes[i].getOriginal_language());
			if (arrayFilmes[i].getOriginal_title() == null || arrayFilmes[i].getOriginal_title() == "") {
				rec.setOriginal_title(arrayFilmes[i].getOriginal_name());
			} else {
				rec.setOriginal_title(arrayFilmes[i].getOriginal_title());
			}
			rec.setOverview(arrayFilmes[i].getOverview());
			rec.setPoster_path(arrayFilmes[i].getPoster_path());
			rec.setRelease_date(arrayFilmes[i].getRelease_date());
			rec.setVote_average(arrayFilmes[i].getVote_average());
			if (arrayFilmes[i].getOriginal_name() == null || arrayFilmes[i].getOriginal_name() == "") {
				rec.setOriginal_name(arrayFilmes[i].getOriginal_title());
			} else {
				rec.setOriginal_name(arrayFilmes[i].getOriginal_name());
			}

			if (classMovie == "recomendados") {
				listaFilmes.AddListaFilmes(rec);
			} else if (classMovie == "emAlta") {
				listaEmAlta.AddListaFilmes(rec);
			} else if (classMovie == "originais") {
				listaOriginais.AddListaFilmes(rec);
			}

		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
