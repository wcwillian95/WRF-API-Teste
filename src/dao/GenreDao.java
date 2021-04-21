package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConexaoDao;
import entity.Genero;

public class GenreDao extends ConexaoDao {

	private static final String INSERT = "INSERT INTO GENRE (id ,name) VALUES (?,?)";
	private static final String SELECT = "SELECT * FROM GENRE";
	private static final String SELECTCODE = "SELECT * FROM FILME where CODE = \"USD\" ORDER BY ID DESC LIMIT 2";// "SELECT

	// Salva no banco
	public void AddFilmes(Genero genero) {

		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INSERT);) {

			pst.setInt(1, genero.getId());
			pst.setString(2, genero.getName());

			pst.executeUpdate();

			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}

	public ArrayList<Genero> selectAllGenres() {

		ArrayList<Genero> listGenre = new ArrayList<Genero>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(SELECT);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Genero genero = new Genero();
				genero.setId(rs.getInt("id"));
				genero.setName(rs.getString("name"));

				listGenre.add(genero);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listGenre;

	}

//	public ArrayList<Filme> selectOneFilme() {
//
//		ArrayList<Filme> listFilme = new ArrayList<Filme>();
//		try (Connection connection = this.conectar();
//				PreparedStatement pst = connection.prepareStatement(SELECTCODE);) {
//			ResultSet rs = pst.executeQuery();
//
//			while (rs.next()) {
//
//				Filme filme = new Filme();
//				filme.setId(rs.getString("id"));
//				filme.setRank(rs.getString("original_title"));
//				filme.setTitle(rs.getString("title"));
//				filme.setTitle(rs.getString("original_language"));
//				filme.setFullTitle(rs.getString("overview"));
//				filme.setYear(rs.getString("poster_path"));
//				filme.setRelease_date(java.sql.Date.valueOf((rs.getString("release_date"))));
//				filme.setMedia_type(rs.getString("media_type"));
//				filme.setVote_average(rs.getDouble("vote_average"));
//
//				listFilme.add(filme);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return listFilme;
//
//	}
}
