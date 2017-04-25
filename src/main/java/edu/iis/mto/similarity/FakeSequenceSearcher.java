package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;

import java.util.Arrays;

/**
 * Created by Krzysztof Zimny on 4/25/2017.
 */
public class FakeSequenceSearcher implements SequenceSearcher {

    private int call = 0;

    public int getCall() {
        int callsNumber = call;
        call = 0;
        return callsNumber;
    }

    public SearchResult search(int i, int[] seq) {
        ++call;
        return new FakeSearchResult(Arrays.asList(seq).indexOf(i));
    }
}
