package modal;

import java.util.ArrayList;
import java.util.List;

import entity.Filme;
import entity.TmdbRecomendados;

public class ListaFilmes {
	ArrayList<TmdbRecomendados> listFilme = new ArrayList<TmdbRecomendados>();

	public void AddListaFilmes(TmdbRecomendados rec) {
		
		listFilme.add(rec);
	}
	
	public ArrayList<TmdbRecomendados> ListaFilmes(){
		
		return listFilme;
	}
}
