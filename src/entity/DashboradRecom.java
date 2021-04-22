package entity;

public class DashboradRecom {

	private int nota5;
	private int nota6;
	private int nota7;
	private int nota8;
	private int nota9;
	@Override
	public String toString() {
		return "DashboradRecom [nota5=" + nota5 + ", nota6=" + nota6 + ", nota7=" + nota7 + ", nota8=" + nota8
				+ ", nota9=" + nota9 + "]";
	}
	public int getNota5() {
		return nota5;
	}
	public void setNota5(int nota5) {
		this.nota5 = nota5;
	}
	public int getNota6() {
		return nota6;
	}
	public void setNota6(int nota6) {
		this.nota6 = nota6;
	}
	public int getNota7() {
		return nota7;
	}
	public void setNota7(int nota7) {
		this.nota7 = nota7;
	}
	public int getNota8() {
		return nota8;
	}
	public void setNota8(int nota8) {
		this.nota8 = nota8;
	}
	public int getNota9() {
		return nota9;
	}
	public void setNota9(int nota9) {
		this.nota9 = nota9;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nota5;
		result = prime * result + nota6;
		result = prime * result + nota7;
		result = prime * result + nota8;
		result = prime * result + nota9;
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
		DashboradRecom other = (DashboradRecom) obj;
		if (nota5 != other.nota5)
			return false;
		if (nota6 != other.nota6)
			return false;
		if (nota7 != other.nota7)
			return false;
		if (nota8 != other.nota8)
			return false;
		if (nota9 != other.nota9)
			return false;
		return true;
	}
	
}
