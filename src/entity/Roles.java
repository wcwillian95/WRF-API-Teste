package entity;

public class Roles {
	private String credit_id;
	private String character;
	private String episode_count;
	
	public String getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(String credit_id) {
		this.credit_id = credit_id;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public String getEpisode_count() {
		return episode_count;
	}
	public void setEpisode_count(String episode_count) {
		this.episode_count = episode_count;
	}
	@Override
	public String toString() {
		return "Roles [credit_id=" + credit_id + ", character=" + character + ", episode_count=" + episode_count + "]";
	}
	
	
}
