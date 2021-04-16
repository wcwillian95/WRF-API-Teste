package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConexaoDao;
import entity.Filme;

public class FilmeDao extends ConexaoDao {

	private static final String INSERT = "INSERT INTO FILME (id,varrank,title,fullTitle,varyear,image,crew,imDbRating,imDbRatingCount) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String SELECT = "SELECT * FROM FILME";
	private static final String SELECTCODE = "SELECT * FROM FILME where CODE = \"USD\" ORDER BY ID DESC LIMIT 2";// "SELECT

	// Salva no banco
	public void AddFilmes(Filme filme) {

		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INSERT);) {

			pst.setString(1, filme.getId());
			pst.setString(2, filme.getRank());
			pst.setString(3, filme.getTitle());
			pst.setString(4, filme.getFullTitle());
			pst.setString(5, filme.getYear());
			pst.setString(6, filme.getImage());
			pst.setString(7, filme.getCrew());
			pst.setString(8, filme.getImDbRating());
			pst.setString(9, filme.getImDbRatingCount());

			pst.executeUpdate();

			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}

	public ArrayList<Filme> selectAllFilmes() {

		ArrayList<Filme> listFilme = new ArrayList<Filme>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(SELECT);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Filme filme = new Filme();
				filme.setId(rs.getString("id"));
				filme.setRank(rs.getString("varrank"));
				filme.setTitle(rs.getString("title"));
				filme.setFullTitle(rs.getString("fullTitle"));
				filme.setYear(rs.getString("varyear"));
				filme.setImage(rs.getString("image"));
				filme.setCrew(rs.getString("crew"));
				filme.setImDbRating(rs.getString("imDbRating"));
				filme.setImDbRatingCount(rs.getString("imDbRatingCount"));

				listFilme.add(filme);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listFilme;

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
