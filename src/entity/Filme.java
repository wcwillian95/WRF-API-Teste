package entity;

import java.sql.Date;

public class Filme {
	/*
	 * create table filme( id identity primary key, original_title varchar(255),
	 * title varchar(255), original_language varchar(5), overview varchar(255),
	 * poster_path varchar(255) reloase_date date, vote_average float, media_type
	 * varchar(25) )
	 */
	private int id;
	private String original_title;
	private String title;
	private String original_language;
	private String overview;
	private String poster_path;
	private Date release_date;
	private String media_type;
	private Double vote_average;

	@Override
	public String toString() {
		return "Filme [id=" + id + ", original_title=" + original_title + ", title=" + title + ", original_language="
				+ original_language + ", overview=" + overview + ", poster_path=" + poster_path + ", media_type="
				+ media_type + ", vote_average=" + vote_average + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((media_type == null) ? 0 : media_type.hashCode());
		result = prime * result + ((original_language == null) ? 0 : original_language.hashCode());
		result = prime * result + ((original_title == null) ? 0 : original_title.hashCode());
		result = prime * result + ((overview == null) ? 0 : overview.hashCode());
		result = prime * result + ((poster_path == null) ? 0 : poster_path.hashCode());
		result = prime * result + ((release_date == null) ? 0 : release_date.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Filme other = (Filme) obj;
		if (id != other.id)
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
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (vote_average == null) {
			if (other.vote_average != null)
				return false;
		} else if (!vote_average.equals(other.vote_average))
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOriginal_title() {
		return original_title;
	}

	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
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

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public String getMedia_type() {
		return media_type;
	}

	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}

	public Double getVote_average() {
		return vote_average;
	}

	public void setVote_average(Double vote_average) {
		this.vote_average = vote_average;
	}

	public Filme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Filme(int id, String original_title, String title, String original_language, String overview,
			String poster_path, Date release_date, String media_type, Double vote_average) {
		super();
		this.id = id;
		this.original_title = original_title;
		this.title = title;
		this.original_language = original_language;
		this.overview = overview;
		this.poster_path = poster_path;
		this.release_date = release_date;
		this.media_type = media_type;
		this.vote_average = vote_average;
	}

	public Filme(String original_title, String title, String original_language, String overview, String poster_path,
			Date release_date, String media_type, Double vote_average) {
		super();
		this.original_title = original_title;
		this.title = title;
		this.original_language = original_language;
		this.overview = overview;
		this.poster_path = poster_path;
		this.release_date = release_date;
		this.media_type = media_type;
		this.vote_average = vote_average;
	}

}
