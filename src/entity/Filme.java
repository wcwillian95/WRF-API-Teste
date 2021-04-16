package entity;

import java.sql.Date;

public class Filme {
	private String id;
	private String rank;
	private String title;
	private String fullTitle;
	private String year;
	private String image;
	private String crew;
	private String imDbRating;
	private String imDbRatingCount;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFullTitle() {
		return fullTitle;
	}
	public void setFullTitle(String fullTitle) {
		this.fullTitle = fullTitle;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCrew() {
		return crew;
	}
	public void setCrew(String crew) {
		this.crew = crew;
	}
	public String getImDbRating() {
		return imDbRating;
	}
	public Filme(String id, String rank, String title, String fullTitle, String year, String image, String crew,
			String imDbRating, String imDbRatingCount) {
		super();
		this.id = id;
		this.rank = rank;
		this.title = title;
		this.fullTitle = fullTitle;
		this.year = year;
		this.image = image;
		this.crew = crew;
		this.imDbRating = imDbRating;
		this.imDbRatingCount = imDbRatingCount;
	}
	public Filme() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crew == null) ? 0 : crew.hashCode());
		result = prime * result + ((fullTitle == null) ? 0 : fullTitle.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imDbRating == null) ? 0 : imDbRating.hashCode());
		result = prime * result + ((imDbRatingCount == null) ? 0 : imDbRatingCount.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		if (crew == null) {
			if (other.crew != null)
				return false;
		} else if (!crew.equals(other.crew))
			return false;
		if (fullTitle == null) {
			if (other.fullTitle != null)
				return false;
		} else if (!fullTitle.equals(other.fullTitle))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imDbRating == null) {
			if (other.imDbRating != null)
				return false;
		} else if (!imDbRating.equals(other.imDbRating))
			return false;
		if (imDbRatingCount == null) {
			if (other.imDbRatingCount != null)
				return false;
		} else if (!imDbRatingCount.equals(other.imDbRatingCount))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	public void setImDbRating(String imDbRating) {
		this.imDbRating = imDbRating;
	}
	public String getImDbRatingCount() {
		return imDbRatingCount;
	}
	public void setImDbRatingCount(String imDbRatingCount) {
		this.imDbRatingCount = imDbRatingCount;
	}
	@Override
	public String toString() {
		return "Filme [id=" + id + ", rank=" + rank + ", title=" + title + ", fullTitle=" + fullTitle + ", year=" + year
				+ ", image=" + image + ", crew=" + crew + ", imDbRating=" + imDbRating + ", imDbRatingCount="
				+ imDbRatingCount + "]";
	}

	

}
