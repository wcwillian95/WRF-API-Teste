package entity;

public class Companies {

	private String id;
	private String logo_path;
	private String name;
	private String origin_country;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLogo_path() {
		return logo_path;
	}
	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin_country() {
		return origin_country;
	}
	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logo_path == null) ? 0 : logo_path.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((origin_country == null) ? 0 : origin_country.hashCode());
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
		Companies other = (Companies) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logo_path == null) {
			if (other.logo_path != null)
				return false;
		} else if (!logo_path.equals(other.logo_path))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (origin_country == null) {
			if (other.origin_country != null)
				return false;
		} else if (!origin_country.equals(other.origin_country))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Companies [id=" + id + ", logo_path=" + logo_path + ", name=" + name + ", origin_country="
				+ origin_country + "]";
	}
	
	
	
}
