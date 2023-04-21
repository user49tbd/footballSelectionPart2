package footballApplication.footballApplicationV2.model;

public class StatusGrupo {
	private String grp;
	private String nomeTime;
	
	
	

	public String getGrp() {
		return grp;
	}

	public void setGrp(String grp) {
		this.grp = grp;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	@Override
	public String toString() {
		return "StatusGrupo [Grp=" + grp + ", nomeTime=" + nomeTime + "]";
	}
}
