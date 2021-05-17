package entity;

import java.util.Arrays;

public class TV {
	private String backdrop_path;
	private Created[] created_by;
	private String[] episode_run_time;
	private String first_air_date;
	private Genres[] genres; 
	private String homepage;
	private String id;
	private String in_production;
	private String[] languages;
	private String last_air_date;
	private LastEpToAir last_episode_to_air; 
	private String name;
	private Networks[] networks;
	private String number_of_episodes;
	private String number_of_seasons;
	private String[] origin_country;
	private String original_language;
	private String original_name;
	private String overview;
	private String popularity;
	private String poster_path;
	private Companies[] production_companies;
	private ProductionCountry[] production_countries;
	private Seasons[] seasons;
	private SpokenLanguages[] spoken_languages;
	private String status;
	private String tagline;
	private String type;
	private String vote_average;
	private String vote_count;
	public String getBackdrop_path() {
		return backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public Created[] getCreated_by() {
		return created_by;
	}
	public void setCreated_by(Created[] created_by) {
		this.created_by = created_by;
	}
	public String[] getEpisode_run_time() {
		return episode_run_time;
	}
	public void setEpisode_run_time(String[] episode_run_time) {
		this.episode_run_time = episode_run_time;
	}
	public String getFirst_air_date() {
		return first_air_date;
	}
	public void setFirst_air_date(String first_air_date) {
		this.first_air_date = first_air_date;
	}
	public Genres[] getGenres() {
		return genres;
	}
	public void setGenres(Genres[] genres) {
		this.genres = genres;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIn_production() {
		return in_production;
	}
	public void setIn_production(String in_production) {
		this.in_production = in_production;
	}
	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public String getLast_air_date() {
		return last_air_date;
	}
	public void setLast_air_date(String last_air_date) {
		this.last_air_date = last_air_date;
	}
	public LastEpToAir getLast_episode_to_air() {
		return last_episode_to_air;
	}
	public void setLast_episode_to_air(LastEpToAir last_episode_to_air) {
		this.last_episode_to_air = last_episode_to_air;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Networks[] getNetworks() {
		return networks;
	}
	public void setNetworks(Networks[] networks) {
		this.networks = networks;
	}
	public String getNumber_of_episodes() {
		return number_of_episodes;
	}
	public void setNumber_of_episodes(String number_of_episodes) {
		this.number_of_episodes = number_of_episodes;
	}
	public String getNumber_of_seasons() {
		return number_of_seasons;
	}
	public void setNumber_of_seasons(String number_of_seasons) {
		this.number_of_seasons = number_of_seasons;
	}
	public String[] getOrigin_country() {
		return origin_country;
	}
	public void setOrigin_country(String[] origin_country) {
		this.origin_country = origin_country;
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
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getPopularity() {
		return popularity;
	}
	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public Companies[] getProduction_companies() {
		return production_companies;
	}
	public void setProduction_companies(Companies[] production_companies) {
		this.production_companies = production_companies;
	}
	public ProductionCountry[] getProduction_countries() {
		return production_countries;
	}
	public void setProduction_countries(ProductionCountry[] production_countries) {
		this.production_countries = production_countries;
	}
	public Seasons[] getSeasons() {
		return seasons;
	}
	public void setSeasons(Seasons[] seasons) {
		this.seasons = seasons;
	}
	public SpokenLanguages[] getSpoken_languages() {
		return spoken_languages;
	}
	public void setSpoken_languages(SpokenLanguages[] spoken_languages) {
		this.spoken_languages = spoken_languages;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTagline() {
		return tagline;
	}
	public void setTagline(String tagline) {
		this.tagline = tagline;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVote_average() {
		return vote_average;
	}
	public void setVote_average(String vote_average) {
		this.vote_average = vote_average;
	}
	public String getVote_count() {
		return vote_count;
	}
	public void setVote_count(String vote_count) {
		this.vote_count = vote_count;
	}
	@Override
	public String toString() {
		return "TV [backdrop_path=" + backdrop_path + ", created_by=" + Arrays.toString(created_by)
				+ ", episode_run_time=" + Arrays.toString(episode_run_time) + ", first_air_date=" + first_air_date
				+ ", genres=" + Arrays.toString(genres) + ", homepage=" + homepage + ", id=" + id + ", in_production="
				+ in_production + ", languages=" + Arrays.toString(languages) + ", last_air_date=" + last_air_date
				+ ", last_episode_to_air=" + last_episode_to_air + ", name=" + name + ", next_episode_to_air="
				+ ", networks=" + Arrays.toString(networks) + ", number_of_episodes="
				+ number_of_episodes + ", number_of_seasons=" + number_of_seasons + ", origin_country="
				+ Arrays.toString(origin_country) + ", original_language=" + original_language + ", original_name="
				+ original_name + ", overview=" + overview + ", popularity=" + popularity + ", poster_path="
				+ poster_path + ", production_companies=" + Arrays.toString(production_companies)
				+ ", production_countries=" + Arrays.toString(production_countries) + ", seasons="
				+ Arrays.toString(seasons) + ", spoken_languages=" + Arrays.toString(spoken_languages) + ", status="
				+ status + ", tagline=" + tagline + ", type=" + type + ", vote_average=" + vote_average
				+ ", vote_count=" + vote_count + "]";
	}
	
	
}
