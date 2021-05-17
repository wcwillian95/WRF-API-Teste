package entity;

import java.util.Arrays;

public class Cast {
	private String adult;
	private String gender;
	private String id;
	private String known_for_department;
	private String name;
	private String original_name;
	private String popularity;
	private String profile_path;
	private String character;
	private Roles[] roles;
	private String total_episode_count;
	private String order;
	
	
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getAdult() {
		return adult;
	}
	public void setAdult(String adult) {
		this.adult = adult;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKnown_for_department() {
		return known_for_department;
	}
	public void setKnown_for_department(String known_for_department) {
		this.known_for_department = known_for_department;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginal_name() {
		return original_name;
	}
	public void setOriginal_name(String original_name) {
		this.original_name = original_name;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getProfile_path() {
		return profile_path;
	}
	public void setProfile_path(String profile_path) {
		this.profile_path = profile_path;
	}
	public Roles[] getRoles() {
		return roles;
	}
	public void setRoles(Roles[] roles) {
		this.roles = roles;
	}
	public String getTotal_episode_count() {
		return total_episode_count;
	}
	public void setTotal_episode_count(String total_episode_count) {
		this.total_episode_count = total_episode_count;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Cast [adult=" + adult + ", gender=" + gender + ", id=" + id + ", known_for_department="
				+ known_for_department + ", name=" + name + ", original_name=" + original_name + ", popularity="
				+ popularity + ", profile_path=" + profile_path + ", character=" + character + ", roles="
				+ Arrays.toString(roles) + ", total_episode_count=" + total_episode_count + ", order=" + order + "]";
	}
	
	
}
