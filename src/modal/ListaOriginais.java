package modal;

import java.util.ArrayList;

import entity.TmdbRecomendados;

public class ListaOriginais {
	ArrayList<TmdbRecomendados> listFilme = new ArrayList<TmdbRecomendados>();

	public void AddListaFilmes(TmdbRecomendados rec) {

		listFilme.add(rec);
	}

	public ArrayList<TmdbRecomendados> ListaFilmes() {

		return listFilme;
	}

	public void LimparLista() {
		listFilme.removeAll(listFilme);
	}
}
