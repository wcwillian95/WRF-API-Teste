import java.sql.Date;

import dao.FilmeDao;
import entity.Filme;

public class MainTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FilmeDao x = new FilmeDao();
		System.out.println(x.selectAllFilmes());
	}

	public static void AddFilme(){
		Filme film = new Filme();
		FilmeDao x = new FilmeDao();

		film.setMedia_type("tv");
		film.setOriginal_language("EN");
		film.setOriginal_title("Friends");
		film.setOverview("4 amigos super divertidos ...");
		film.setPoster_path("/imagen.com.br");
		film.setRelease_date(Date.valueOf("1999-07-12"));
		film.setTitle("Amigos");
		film.setVote_average(Double.valueOf(9.8));
		x.AddFilmes(film);
	}
}
