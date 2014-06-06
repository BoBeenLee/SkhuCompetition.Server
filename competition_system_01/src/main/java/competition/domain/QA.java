package competition.domain;

public class QA extends Article{
	private int qaId;
	private int articleId;
	private int processId;
	private int parentQAId;
	private int distance;
	private int step;

	public int getQaId() {
		return qaId;
	}

	public void setQaId(int qaId) {
		this.qaId = qaId;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public int getProcessId() {
		return processId;
	}

	public void setProcessId(int processId) {
		this.processId = processId;
	}

	public int getParentQAId() {
		return parentQAId;
	}

	public void setParentQAId(int parentQAId) {
		this.parentQAId = parentQAId;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}
