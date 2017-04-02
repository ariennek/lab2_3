package edu.iis.mto.search;

public class MockSequenceSearcher implements SequenceSearcher{
	
	public int key;
	public int[] sequence;
	public int callCounter = 0;
	
	public SearchResult search(int key, int[] seq) {
		
		this.key = key;
		this.sequence = seq.clone();
		callCounter++;
		
		for (int at = 0; at < seq.length; at++) {
			if (seq[at] == key) {
				return new MockSearchResult(true, at);
			}
		}
		return new MockSearchResult();
	}
}
