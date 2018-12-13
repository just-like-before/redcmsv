package com.redcmsv.beans;

import java.util.List;

public class Paging {

	private int totalOfData;
	private int totalOfPage;
	private int everyOfPage;
	private List<?> list;
	
	public Paging() {
		
	}

	public Paging(int totalOfData, int totalOfPage, int everyOfPage, List<?> list) {
		super();
		this.totalOfData = totalOfData;
		this.totalOfPage = totalOfPage;
		this.everyOfPage = everyOfPage;
		this.list = list;
	}

	public int getTotalOfData() {
		return totalOfData;
	}

	public void setTotalOfData(int totalOfData) {
		this.totalOfData = totalOfData;
	}

	public int getTotalOfPage() {
		return totalOfPage;
	}

	public void setTotalOfPage(int totalOfPage) {
		this.totalOfPage = totalOfPage;
	}

	public int getEveryOfPage() {
		return everyOfPage;
	}

	public void setEveryOfPage(int everyOfPage) {
		this.everyOfPage = everyOfPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Paging [totalOfData=" + totalOfData + ", totalOfPage=" + totalOfPage + ", everyOfPage=" + everyOfPage
				+ ", list=" + list + "]";
	}
}
