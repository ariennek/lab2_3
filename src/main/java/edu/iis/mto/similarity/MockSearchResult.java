package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Piotr on 18.03.2017.
 */
public class MockSearchResult implements SearchResult{
    private boolean found;
    private int position;

    public MockSearchResult(boolean found, int position) {
        this.found = found;
        this.position = position;
    }

    public boolean isFound() {
        return this.found;
    }

    public int getPosition() {
        return position;
    }
}