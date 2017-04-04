package edu.iis.mto.similarity;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Konrad Gos on 18.03.2017.
 */
public class SimilarityFinderTest {

    private MockupSequenceSearcher mockupSequenceSearcher;
    private SimilarityFinder similarityFinder;

    @Before
    public void setUp() throws Exception {
        mockupSequenceSearcher = new MockupSequenceSearcher();
        similarityFinder = new SimilarityFinder(mockupSequenceSearcher);
    }

    @Test
    public void checkTwoEmptySequences() {
        int[] firstSeqeunce = new int[0];
        int[] secondSeqeunce = new int[0];

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(1.0));
    }

    @Test
    public void checkTwoSameSequences() {
        int[] firstSeqeunce = new int[] {1, 2, 3};
        int[] secondSeqeunce = new int[] {1, 2, 3};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(1.0));
    }

    @Test
    public void checkTwoDifferentSequences() {
        int[] firstSeqeunce = new int[] {1, 2, 3};
        int[] secondSeqeunce = new int[] {4, 5, 6};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(0.0));
    }

    @Test
    public void checkSequencesThatHaveOneSameElement() {
        int[] firstSeqeunce = new int[] {1, 2, 3};
        int[] secondSeqeunce = new int[] {1, 5, 6};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(0.2));
    }

    @Test
    public void checkSequencesThatHaveTwoSameElement() {
        int[] firstSeqeunce = new int[] {1, 2, 3};
        int[] secondSeqeunce = new int[] {1, 2, 6};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(0.5));
    }

    @Test(expected = NullPointerException.class)
    public void checkNullPointerExceptionForSequences() {
        int[] firstSeqeunce = null;
        int[] secondSeqeunce = null;

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);
    }

    @Test
    public void checkSequencesWithDifferentDimensions() {
        int[] firstSeqeunce = new int[] {1, 3};
        int[] secondSeqeunce = new int[] {1, 2, 6};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(similarityResult, is(0.25));
    }

    @Test
    public void checkParametersForMockuSequenceSearcher() {
        int[] firstSeqeunce = new int[] {1, 3};
        int[] secondSeqeunce = new int[] {1, 2, 6};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(mockupSequenceSearcher.getIndex(), is(3));
        assertThat(mockupSequenceSearcher.getSeq(), is(secondSeqeunce));
    }

    @Test
    public void checkCallsForMockuSequenceSearcher() {
        int[] firstSeqeunce = new int[] {1, 3, 6};
        int[] secondSeqeunce = new int[] {1, 2, 3, 4};

        double similarityResult = similarityFinder.calculateJackardSimilarity(firstSeqeunce,secondSeqeunce);

        assertThat(mockupSequenceSearcher.getCount(), is(3));
    }
}