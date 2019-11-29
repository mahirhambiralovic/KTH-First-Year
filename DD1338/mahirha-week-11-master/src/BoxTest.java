import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

/**
 * Test class for Box.
 *
 * @author Simon Larsén
 * @version 2017-08-16
 */
public class BoxTest {
    private final int ALL_HEIGHT = 1;
    private final int ALL_WIDTH = 1;
    private final int SMALL_DEPTH = 1;
    private final int MEDIUM_DEPTH = 2;
    private final int LARGE_DEPTH = 3;
    private final Box SMALL_BOX = new Box(ALL_HEIGHT, ALL_WIDTH, SMALL_DEPTH);
    private final Box MEDIUM_BOX = new Box(ALL_HEIGHT, ALL_WIDTH, MEDIUM_DEPTH);
    private final Box LARGE_BOX = new Box(ALL_HEIGHT, ALL_WIDTH, LARGE_DEPTH);

    @Test
    public void boxImplementsComparable() {
        // Act
        Box box = new Box(1, 1, 1);

        // Assert
        assertThat(box, isA(Comparable.class));
    }

    @Test
    public void compareToIsPositiveWhenArgumentIsSmallerThanCallee() {
        // Act
        int compareMediumToSmall = MEDIUM_BOX.compareTo(SMALL_BOX);
        int compareLargeToSmall = LARGE_BOX.compareTo(SMALL_BOX);
        int compareLargeToMedium = LARGE_BOX.compareTo(MEDIUM_BOX);

        // Assert
        assertTrue(0 < compareMediumToSmall);
        assertTrue(0 < compareLargeToSmall);
        assertTrue(0 < compareLargeToMedium);
    }

    @Test
    public void compareToIsNegativeWhenArgumentIsLargerThanCallee() {
        // Act
        int compareSmallToMedium = SMALL_BOX.compareTo(MEDIUM_BOX);
        int compareSmallToLarge = SMALL_BOX.compareTo(LARGE_BOX);
        int compareMediumToLarge = MEDIUM_BOX.compareTo(LARGE_BOX);

        // Assert
        assertTrue(compareSmallToMedium < 0);
        assertTrue(compareSmallToLarge < 0);
        assertTrue(compareMediumToLarge < 0);
    }

    @Test
    public void compareToIsZeroWhenArgumentIsSameSizeAsCallee() {
        // Arrange
        Box smallBox = new Box(ALL_HEIGHT, ALL_WIDTH, SMALL_DEPTH);
        Box mediumBox = new Box(ALL_HEIGHT, ALL_WIDTH, MEDIUM_DEPTH);
        Box largeBox = new Box(ALL_HEIGHT, ALL_WIDTH, LARGE_DEPTH);

        // Act
        int compareSmallToSmall = SMALL_BOX.compareTo(smallBox);
        int compareMediumToMedium = MEDIUM_BOX.compareTo(mediumBox);
        int compareLargeToLarge = LARGE_BOX.compareTo(largeBox);

        // Assert
        assertThat(compareSmallToSmall, equalTo(0));
        assertThat(compareMediumToMedium, equalTo(0));
        assertThat(compareLargeToLarge, equalTo(0));
    }
}
