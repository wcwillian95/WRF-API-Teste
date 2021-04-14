package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConexaoDao;
import entity.Filme;

public class FilmeDao extends ConexaoDao {

	private static final String INSERT = "INSERT INTO FILME (original_title,title,original_language,overview,poster_path,release_date,media_type,vote_average) VALUES (?,?,?,?,?,?,?,?)";
	private static final String SELECT = "SELECT * FROM FILME";
	private static final String SELECTCODE = "SELECT * FROM FILME where CODE = \"USD\" ORDER BY ID DESC LIMIT 2";// "SELECT

	// Salva no banco
	public void AddFilmes(Filme filme) {

		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INSERT);) {

			pst.setString(1, filme.getOriginal_title());
			pst.setString(2, filme.getTitle());
			pst.setString(3, filme.getOriginal_language());
			pst.setString(4, filme.getOverview());
			pst.setString(5, filme.getPoster_path());
			pst.setDate(6, filme.getRelease_date());
			pst.setString(7, filme.getMedia_type());
			pst.setDouble(8, filme.getVote_average());
			
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
				filme.setId(rs.getInt("id"));
				filme.setOriginal_title(rs.getString("original_title"));
				filme.setTitle(rs.getString("title"));
				filme.setOriginal_language(rs.getString("original_language"));
				filme.setOverview(rs.getString("overview"));
				filme.setPoster_path(rs.getString("poster_path"));
				filme.setRelease_date(java.sql.Date.valueOf((rs.getString("release_date"))));
				filme.setMedia_type(rs.getString("media_type"));
				filme.setVote_average(rs.getDouble("vote_average"));
				

				listFilme.add(filme);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listFilme;

	}

	public ArrayList<Filme> selectOneFilme() {

		ArrayList<Filme> listFilme = new ArrayList<Filme>();
		try (Connection connection = this.conectar();
				PreparedStatement pst = connection.prepareStatement(SELECTCODE);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Filme filme = new Filme();
				filme.setId(rs.getInt("id"));
				filme.setOriginal_title(rs.getString("original_title"));
				filme.setTitle(rs.getString("title"));
				filme.setOriginal_language(rs.getString("original_language"));
				filme.setOverview(rs.getString("overview"));
				filme.setPoster_path(rs.getString("poster_path"));
				filme.setRelease_date(java.sql.Date.valueOf((rs.getString("release_date"))));
				filme.setMedia_type(rs.getString("media_type"));
				filme.setVote_average(rs.getDouble("vote_average"));
			
				listFilme.add(filme);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listFilme;

	}
}
