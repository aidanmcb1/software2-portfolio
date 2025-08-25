import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Components.Playlist;
import Components.Playlist1L;

/**
 * Tests for secondary methods.
 */
public class Playlist1LTest {

    /**
     * Test contains song resulting in true.
     */
    @Test
    public void testContainsSongTrue() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");
        assertTrue(test.containsSong("second"));
    }

    /**
     * Test contains song resulting in false.
     */
    @Test
    public void testContainsSongFalse() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");
        assertFalse(test.containsSong("fourth"));
    }

    /**
     * Test random song.
     */
    @Test
    public void testRandomSong() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");
        String random = test.removeFront();
        assertFalse(test.containsSong(random));
        assertTrue(random.compareTo("first") == 0
                || random.compareTo("second") == 0
                || random.compareTo("third") == 0);
    }

    /**
     * Test shuffle.
     */
    @Test
    public void testShuffle() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");

        Playlist control = new Playlist1L();
        control.addSong("first");
        control.addSong("second");
        control.addSong("third");

        test.shuffle();

        for (int i = 0; i < test.length(); i++) {
            assertTrue(test.containsSong(control.removeFront()));
        }
    }

    /**
     * Test toString.
     */
    @Test
    public void testToString() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");

        String list = test.toString();
        String listControl = "Playlist conatins: \\nfirst, \\nsecond, \\nthird, \\n";
        assertEquals(list, listControl);
    }

    /**
     * Test equals resulting in true.
     */
    @Test
    public void testEqualsTrue() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");

        Playlist control = new Playlist1L();
        control.addSong("first");
        control.addSong("second");
        control.addSong("third");

        assertTrue(test.equals(control));
    }

    /**
     * Test equals resulting in false.
     */
    @Test
    public void testEqualsFalse() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");

        Playlist control = new Playlist1L();
        control.addSong("third");
        control.addSong("second");
        control.addSong("first");

        assertFalse(test.equals(control));
    }

    /**
     * Test hashCode.
     */
    @Test
    public void testHashCode() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");

        int hash = test.hashCode();
        final int hashControl = 16;

        assertEquals(hash, hashControl);
    }

}
