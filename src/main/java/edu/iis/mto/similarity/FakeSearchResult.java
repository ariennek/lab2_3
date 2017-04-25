package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;

/**
 * Created by Krzysztof Zimny on 4/25/2017.
 */
public class FakeSearchResult implements SearchResult {

    private int position;

    FakeSearchResult(int position) {
        this.position = position;
    }

    public boolean isFound() {
        return position != -1;
    }

    public int getPosition() {
        return position;
    }

}
