package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TmdbRecomendadosDao;
import entity.TmdbRecomendados;
import entity.DashboradRecom;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TmdbRecomendadosDao recDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Dashboard() {
		this.recDao = new TmdbRecomendadosDao();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DashboradRecom dash = new DashboradRecom();
		ArrayList<TmdbRecomendados> lista = recDao.selectAllrecs();
		for (TmdbRecomendados x : lista) {
			if(x.getVote_average() >= 5 && x.getVote_average() < 6) {
				dash.setNota5(dash.getNota5()+1);
			}
			if(x.getVote_average() >= 6 && x.getVote_average() < 7) {
				dash.setNota6(dash.getNota6()+1);
			}
			if(x.getVote_average() >= 7 && x.getVote_average() < 8) {
				dash.setNota7(dash.getNota7()+1);
			}
			if(x.getVote_average() >= 8 && x.getVote_average() < 9) {
				dash.setNota8(dash.getNota8()+1);
			}
			if(x.getVote_average() >= 9 && x.getVote_average() < 10) {
				dash.setNota9(dash.getNota9()+1);
			}
		}
		System.out.println(dash.toString());
		request.setAttribute("listaValores", dash);


		RequestDispatcher rd = request.getRequestDispatcher("/viewFilmes/dashboard.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
