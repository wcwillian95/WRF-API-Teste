package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConexaoDao;
import entity.TmdbRecomendados;

public class TmdbRecomendadosDao extends ConexaoDao {

	private static final String INSERT = "INSERT INTO recomendados (id,original_language,original_title,overview,poster_path,release_date,vote_average,media_type,original_name) VALUES (?,?,?,?,?,?,?,?,?)";
	private static final String SELECT = "SELECT * FROM recomendados";

	// Salva no banco
	public void Addrecs(TmdbRecomendados rec) {

		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(INSERT);) {

			pst.setString(1, rec.getId());
			pst.setString(2, rec.getOriginal_language());
			pst.setString(3, rec.getOriginal_title());
			pst.setString(4, rec.getOverview());
			pst.setString(5, rec.getPoster_path());
			pst.setString(6, rec.getRelease_date());
			pst.setDouble(7, rec.getVote_average());
			pst.setString(8, rec.getMedia_type());
			pst.setString(9, rec.getOriginal_name());

			pst.executeUpdate();

			System.out.println("Salvou");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Não Salvou");
		}

	}

	public ArrayList<TmdbRecomendados> selectAllrecs() {

		ArrayList<TmdbRecomendados> listrec = new ArrayList<TmdbRecomendados>();
		try (Connection connection = this.conectar(); PreparedStatement pst = connection.prepareStatement(SELECT);) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				TmdbRecomendados rec = new TmdbRecomendados();
				rec.setId(rs.getString("id"));
				rec.setMedia_type(rs.getString("media_type"));
				rec.setOriginal_language(rs.getString("original_language"));
				rec.setOriginal_title(rs.getString("original_title"));
				rec.setOverview(rs.getString("overview"));
				rec.setPoster_path(rs.getString("poster_path"));
				rec.setRelease_date(rs.getString("release_date"));
				rec.setVote_average(rs.getDouble("vote_average"));
				rec.setOriginal_name(rs.getString("original_name"));

				listrec.add(rec);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listrec;

	}

}
