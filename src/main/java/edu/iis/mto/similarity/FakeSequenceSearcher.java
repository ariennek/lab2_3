package edu.iis.mto.similarity;

import edu.iis.mto.search.SearchResult;
import edu.iis.mto.search.SequenceSearcher;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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
        return new FakeSearchResult(IntStream.of(seq).boxed().collect(Collectors.toList()).indexOf(i));
    }
}
