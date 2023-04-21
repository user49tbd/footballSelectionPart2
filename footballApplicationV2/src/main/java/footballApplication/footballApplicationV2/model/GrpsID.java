package footballApplication.footballApplicationV2.model;

public class GrpsID {
	private int id;
	private String grp;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	@Override
	public String toString() {
		return "GrpsID [id=" + id + ", grp=" + grp + "]";
	}
}
