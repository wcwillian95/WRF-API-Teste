package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
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

import dao.TmdbRecomendadosDao;
import entity.TmdbRecomendados;

@WebServlet(name = "recomendados", urlPatterns = "/viewFilmes/recomendados")
public class TmdbServletFilmes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TmdbRecomendadosDao recDao;

	public TmdbServletFilmes() {
		this.recDao = new TmdbRecomendadosDao();
	}

//  private static HttpURLConnection connection;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<TmdbRecomendados> lista = recDao.selectAllrecs();
//		response.getWriter().print(lista);
		request.setAttribute("listaRecomendados", lista);
		
		

		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String sURL = "https://api.themoviedb.org/3/trending/all/week?language=pt-BR&api_key=2e0ae99af7d2c9c2ae236f403d6c111c";

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

		//Array de filmes convertido para Array
		TmdbRecomendados[] arrayFilmes = gson.fromJson(jsonArray, TmdbRecomendados[].class);
		response.getWriter().append( rootobj + "");

		
		//Lista para comparar cadastros no banco
		ArrayList<TmdbRecomendados> listaVerifica = recDao.selectAllrecs();
		
		List<TmdbRecomendados> listaFilmes = new ArrayList<TmdbRecomendados>();
		
		
		for (int i = 0; i < arrayFilmes.length; i++) {
			TmdbRecomendados rec = new TmdbRecomendados();
			rec.setId(arrayFilmes[i].getId());
//			rec.setGenre_ids(arrayFilmes[i].getGenre_ids());
			rec.setMedia_type(arrayFilmes[i].getMedia_type());
			rec.setOriginal_language(arrayFilmes[i].getOriginal_language());
			if(arrayFilmes[i].getOriginal_title() == null) {
				rec.setOriginal_title(arrayFilmes[i].getOriginal_name());
			}
			rec.setOriginal_title(arrayFilmes[i].getOriginal_title());
			rec.setOverview(arrayFilmes[i].getOverview());
			rec.setPoster_path(arrayFilmes[i].getPoster_path());
			rec.setRelease_date(arrayFilmes[i].getRelease_date());
			rec.setVote_average(arrayFilmes[i].getVote_average());
			rec.setOriginal_name(arrayFilmes[i].getOriginal_name());

			boolean x = true;
			listaFilmes.add(rec);
			recDao.Addrecs(rec);
			for (TmdbRecomendados filmeRec: listaFilmes) {
				if(filmeRec.getId().equals(arrayFilmes[i].getId())){
					System.out.println("Encontrei");
					x = false;
				}
			}
			System.out.println(x);
			if (x == true) {
				System.out.println("Salvando...");
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
