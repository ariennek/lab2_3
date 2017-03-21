package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

public class MockSearchResult implements SearchResult {

	private boolean found;
	private int position;
	
	public MockSearchResult(boolean found, int position) {
		
		this.found = found;
		this.position = position;
	}
	
	public boolean isFound() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getPosition() {
		// TODO Auto-generated method stub
		return 0;
	}

}
