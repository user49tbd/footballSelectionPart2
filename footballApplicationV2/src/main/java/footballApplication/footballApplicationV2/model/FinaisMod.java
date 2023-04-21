package footballApplication.footballApplicationV2.model;

public class FinaisMod {
	private String timeA;
	private String timeB;
	public String getTimeA() {
		return timeA;
	}
	public void setTimeA(String timeA) {
		this.timeA = timeA;
	}
	public String getTimeB() {
		return timeB;
	}
	public void setTimeB(String timeB) {
		this.timeB = timeB;
	}
	@Override
	public String toString() {
		return "FinaisMod [timeA=" + timeA + ", timeB=" + timeB + "]";
	}
	
}
