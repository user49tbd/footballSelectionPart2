package footballApplication.footballApplicationV2.model;

public class PartidaStatusMod {
	private String t1grp;
	private String t1nome;
	private int t1gols;
	private String t2grp;
	private String t2nome;
	private int t2gols;
	public String getT1grp() {
		return t1grp;
	}
	public void setT1grp(String t1grp) {
		this.t1grp = t1grp;
	}
	public String getT1nome() {
		return t1nome;
	}
	public void setT1nome(String t1nome) {
		this.t1nome = t1nome;
	}
	public int getT1gols() {
		return t1gols;
	}
	public void setT1gols(int t1gols) {
		this.t1gols = t1gols;
	}
	public String getT2grp() {
		return t2grp;
	}
	public void setT2grp(String t2grp) {
		this.t2grp = t2grp;
	}
	public String getT2nome() {
		return t2nome;
	}
	public void setT2nome(String t2nome) {
		this.t2nome = t2nome;
	}
	public int getT2gols() {
		return t2gols;
	}
	public void setT2gols(int t2gols) {
		this.t2gols = t2gols;
	}
	@Override
	public String toString() {
		return "PartidaStatusMod [t1grp=" + t1grp + ", t1nome=" + t1nome + ", t1gols=" + t1gols + ", t2grp=" + t2grp
				+ ", t2nome=" + t2nome + ", t2gols=" + t2gols + "]";
	}
	
}
