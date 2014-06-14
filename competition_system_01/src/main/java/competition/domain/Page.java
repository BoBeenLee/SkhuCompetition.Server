package competition.domain;

public class Page {
	private String korName;
	private String url;
	
	public Page() {}
	public Page(String korName, String url) {
		this.korName = korName;
		this.url = url;
	}
	
	public String getKorName() {
		return korName;
	}
	public void setKorName(String korName) {
		this.korName = korName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}