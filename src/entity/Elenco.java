package entity;

import java.util.Arrays;

public class Elenco {

	private Cast[] cast;

	public Cast[] getCast() {
		return cast;
	}

	public void setCast(Cast[] cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		return "Elenco [cast=" + Arrays.toString(cast) + "]";
	}
	
}
