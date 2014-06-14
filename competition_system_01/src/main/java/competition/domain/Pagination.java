package competition.domain;

public class Pagination {
    private int currentPage = 1;
    private int pageSize = 10;
    private String srchType;
    private String content;
    private int boardCodeId;
    
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
    
    public String getSt() {
        return srchType;
    }
    
    public void setSt(String srchType) {
        this.srchType = srchType;
    }
	
	public int getBid() {
		return boardCodeId;
	}

	public void setBid(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}   
    
	public String getCt() {
		return content;
	}

	public void setCt(String content) {
		this.content = content;
	}
	
    public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSrchType() {
		return srchType;
	}

	public void setSrchType(String srchType) {
		this.srchType = srchType;
	}
	
	public int getBoardCodeId() {
		return boardCodeId;
	}

	public void setBoardCodeId(int boardCodeId) {
		this.boardCodeId = boardCodeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("bid=%d&sz=%d", boardCodeId, pageSize));
        if (srchType != null) sb.append("&st=" + srchType);
        if (content != null) sb.append("&ct=" + content);
        return sb.toString();
    }
}
