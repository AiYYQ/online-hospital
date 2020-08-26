package xyz.cfsaisi.utils;

import java.util.ArrayList;
import java.util.List;

public class PageUtils<T> {

	private int pageCount;
	private int pageSize;
	private int currentPage = 1;
	private int totalCount;
	private int currentStartIndex;
	private int prePage;
	private int nextPage;
	//存放页面数据
	private List<T> pageList = new ArrayList<T>();
	
	public PageUtils(int pageSize,int totalCount) {
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}

	public int getPageCount() {
		int i = totalCount/pageSize;
		return totalCount%pageSize==0?i:i+1;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getCurrentStart() {
		return pageSize * (currentPage-1);
	}

	public void setCurrentStart(int currentStartIndex) {
		this.currentStartIndex = currentStartIndex;
	}

	public int getPrePage() {
		if (currentPage <= 1) {
			prePage = 1;
		}else {
			prePage = currentPage - 1;
		}
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		int countPage = getPageCount();
		if (currentPage >= countPage) {
			nextPage = countPage;
		}else {
			nextPage = currentPage + 1;
		}
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
}
