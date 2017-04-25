import edu.iis.mto.similarity.FakeSequenceSearcher;
import edu.iis.mto.similarity.SimilarityFinder;
import org.junit.Before;

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
}
