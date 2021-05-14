package entity;

public class SpokenLanguages {
	private String english_name;
	private String iso_639_1;
	private String name;
	public String getEnglish_name() {
		return english_name;
	}
	public void setEnglish_name(String english_name) {
		this.english_name = english_name;
	}
	public String getIso() {
		return iso_639_1;
	}
	public void setIso(String iso) {
		this.iso_639_1 = iso;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((english_name == null) ? 0 : english_name.hashCode());
		result = prime * result + ((iso_639_1 == null) ? 0 : iso_639_1.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		SpokenLanguages other = (SpokenLanguages) obj;
		if (english_name == null) {
			if (other.english_name != null)
				return false;
		} else if (!english_name.equals(other.english_name))
			return false;
		if (iso_639_1 == null) {
			if (other.iso_639_1 != null)
				return false;
		} else if (!iso_639_1.equals(other.iso_639_1))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SpokenLanguages [english_name=" + english_name + ", iso=" + iso_639_1 + ", name=" + name + "]";
	}
	
	
}
