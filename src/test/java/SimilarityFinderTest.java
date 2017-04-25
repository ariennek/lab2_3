import edu.iis.mto.similarity.FakeSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Krzysztof Zimny on 4/25/2017.
 */
public class SimilarityFinderTest {

    private SimilarityFinder similarityFinder;
    private FakeSequenceSearcher fakeSequenceSearcher;

    @Before
    public void setUp() throws Exception {
        fakeSequenceSearcher = new FakeSequenceSearcher();
        similarityFinder = new SimilarityFinder(fakeSequenceSearcher);
    }

    @Test
    public void calculateJackardSimilarityForEmptySequences() throws Exception {
        int[] seq1 = {};
        int[] seq2 = {};
        final double expected = 1.0d;
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(result,is(expected));
    }

    @Test
    public void calculateJackardSimilarityForOneEmptySequence() throws Exception {
        int[] seq1 = {1,2,3};
        int[] seq2 = {};
        final double expected = 0.0d;
        double result = similarityFinder.calculateJackardSimilarity(seq1, seq2);
        assertThat(result,is(expected));
    }
}
