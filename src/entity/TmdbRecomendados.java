package entity;

import java.util.Arrays;

public class TmdbRecomendados {

	private String id;
	private String original_language;
	private String original_name;
	private String original_title;
	private String overview;
	private String poster_path;
	private String release_date;
	private Double vote_average;
	private String media_type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public Double getVote_average() {
		return vote_average;
	}
	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}
	public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((media_type == null) ? 0 : media_type.hashCode());
		result = prime * result + ((original_language == null) ? 0 : original_language.hashCode());
		result = prime * result + ((original_name == null) ? 0 : original_name.hashCode());
		result = prime * result + ((original_title == null) ? 0 : original_title.hashCode());
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		result = prime * result + ((poster_path == null) ? 0 : poster_path.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((vote_average == null) ? 0 : vote_average.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TmdbRecomendados other = (TmdbRecomendados) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (media_type == null) {
			if (other.media_type != null)
				return false;
		} else if (!media_type.equals(other.media_type))
			return false;
		if (original_language == null) {
			if (other.original_language != null)
				return false;
		} else if (!original_language.equals(other.original_language))
			return false;
		if (original_name == null) {
			if (other.original_name != null)
				return false;
		} else if (!original_name.equals(other.original_name))
			return false;
		if (original_title == null) {
			if (other.original_title != null)
				return false;
		} else if (!original_title.equals(other.original_title))
			return false;
		if (overview == null) {
			if (other.overview != null)
				return false;
		} else if (!overview.equals(other.overview))
			return false;
		if (poster_path == null) {
			if (other.poster_path != null)
				return false;
		} else if (!poster_path.equals(other.poster_path))
			return false;
		if (release_date == null) {
			if (other.release_date != null)
				return false;
		} else if (!release_date.equals(other.release_date))
			return false;
		if (vote_average == null) {
			if (other.vote_average != null)
				return false;
		} else if (!vote_average.equals(other.vote_average))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TmdbRecomendados [id=" + id + ", original_language=" + original_language + ", original_name="
				+ original_name + ", original_title=" + original_title + ", overview=" + overview + ", poster_path="
				+ poster_path + ", release_date=" + release_date + ", vote_average=" + vote_average + ", media_type="
				+ media_type + "]";
	}
	
	
}
