package footballApplication.footballApplicationV2.model;

public class GruposDadosMod {
	private String nomeTime;
	private int numJogosDisputados;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int golsMarcados;
	private int golsSofridos;
	private int saldoGols;
	private int pontos;
	private String grp;
	private int otime;
	private String timeStatus;
	public String getNomeTime() {
		return nomeTime;
	}
	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}
	public int getNumJogosDisputados() {
		return numJogosDisputados;
	}
	public void setNumJogosDisputados(int numJogosDisputados) {
		this.numJogosDisputados = numJogosDisputados;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getGolsMarcados() {
		return golsMarcados;
	}
	public void setGolsMarcados(int golsMarcados) {
		this.golsMarcados = golsMarcados;
	}
	public int getGolsSofridos() {
		return golsSofridos;
	}
	public void setGolsSofridos(int golsSofridos) {
		this.golsSofridos = golsSofridos;
	}
	public int getSaldoGols() {
		return saldoGols;
	}
	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	public int getOtime() {
		return otime;
	}
	public void setOtime(int otime) {
		this.otime = otime;
	}
	public String getTimeStatus() {
		return timeStatus;
	}
	public void setTimeStatus(String timeStatus) {
		this.timeStatus = timeStatus;
	}
	@Override
	public String toString() {
		return "GruposDadosMod [nomeTime=" + nomeTime + ", numJogosDisputados=" + numJogosDisputados + ", vitorias="
				+ vitorias + ", empates=" + empates + ", derrotas=" + derrotas + ", golsMarcados=" + golsMarcados
				+ ", golsSofridos=" + golsSofridos + ", saldoGols=" + saldoGols + ", pontos=" + pontos + ", grp=" + grp
				+ ", otime=" + otime + ", timeStatus=" + timeStatus + "]";
	}
	
}
