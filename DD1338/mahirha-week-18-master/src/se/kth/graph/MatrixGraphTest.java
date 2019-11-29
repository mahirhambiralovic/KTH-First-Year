package se.kth.graph;

import org.junit.Test;
import static org.junit.Assert.fail;

/**
 * @author Simon Larsén (adapted from tests by Stefan Nilsson)
 * @version 2013-01-01
 */
public class MatrixGraphTest extends GraphTest {
    @Override
    protected Graph getEmptyGraph(int numVertices) {
        return new MatrixGraph(numVertices);
    }

    @Test
    public void testConstructor() {
        try {
            new MatrixGraph(-1);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }
}
