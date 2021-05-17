package entity;

import java.util.Arrays;

public class Images {

	private Backdrops[] backdrops;

	public Backdrops[] getBackdrops() {
		return backdrops;
	}

	public void setBackdrops(Backdrops[] backdrops) {
		this.backdrops = backdrops;
	}

	@Override
	public String toString() {
		return "Images [backdrops=" + Arrays.toString(backdrops) + "]";
	}
	
}
