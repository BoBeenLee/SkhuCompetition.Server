package competition.domain;

public class Pagination {
	private int currentPage = 1;
	private int pageSize = 15;
	private int srchType;
	private String srchText;
	private String category;

	public int getPg() {
		return currentPage;
	}

	public void setPg(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getSz() {
		return pageSize;
	}

	public void setSz(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSt() {
		return srchType;
	}

	public void setSt(int srchType) {
		this.srchType = srchType;
	}

	public String getTt() {
		return srchText;
	}

	public void setTt(String srchText) {
		this.srchText = srchText;
	}

	public String getCt() {
		return category;
	}

	public void setCt(String category) {
		this.category = category;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("pg=%d&sz=%d", currentPage, pageSize));
		if (srchType != 0)
			sb.append(String.format("&st=%d", srchType));
		if (srchText != null)
			sb.append("&tt=" + srchText);
		if (category != null)
			sb.append("&ct=" + category);
		return sb.toString();
	}
}
