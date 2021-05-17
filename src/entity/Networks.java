package entity;

public class Networks {
private String name;
private String id;
private String logo_path;
private String origin_country;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
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
public String getOrigin_country() {
	return origin_country;
}
public void setOrigin_country(String origin_country) {
	this.origin_country = origin_country;
}
@Override
public String toString() {
	return "Networks [name=" + name + ", id=" + id + ", logo_path=" + logo_path + ", origin_country=" + origin_country
			+ "]";
}


}
