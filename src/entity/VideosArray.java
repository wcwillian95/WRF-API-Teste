package entity;

import java.util.Arrays;

public class VideosArray {

	private String id;
	private Results[] results;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Results[] getResults() {
		return results;
	}
	public void setResults(Results[] results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "VideosArray [id=" + id + ", results=" + Arrays.toString(results) + "]";
	}
	
}
