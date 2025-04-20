import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Components.Playlist;
import Components.Playlist1L;

/**
 * Test file for kernel.
 */
public class PlaylistKernelTest {

    /**
     * Test empty constructor.
     */
    @Test
    public void constructorTest() {
        Playlist test = new Playlist1L();
        assertTrue(test instanceof Playlist && test.length() == 0);
    }

    /**
     * Test adding a song to empty playlist.
     */
    @Test
    public void testAddSongEmpty() {
        Playlist test = new Playlist1L();
        String song = "testsong";
        test.addSong(song);
        assertEquals(test.removeFront(), song);
    }

    /**
     * Test adding a song to non empty playlist.
     */
    @Test
    public void testAddSongNonEmpty() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("target");
        test.removeFront();
        assertEquals(test.removeFront(), "target");
    }

    /**
     * Test removing song.
     */
    @Test
    public void testRemoveSong() {
        Playlist test = new Playlist1L();
        test.addSong("test");
        assertEquals(test.removeFront(), "test");
    }

    /**
     * Test length with empty playlist.
     */
    @Test
    public void testLengthEmpty() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.addSong("third");
        final int length = 3;
        assertTrue(test.length() == length);
    }

    /**
     * Test transfer from.
     */
    @Test
    public void testTransferFrom() {
        Playlist source = new Playlist1L();
        Playlist target = source.newInstance();
        source.addSong("first");
        source.addSong("second");
        source.addSong("third");
        target.transferFrom(source);
        final int length = 3;
        assertEquals(target.length(), length);
        assertEquals(target.removeFront(), "first");
    }

    /**
     * Test clear.
     */
    @Test
    public void testClear() {
        Playlist test = new Playlist1L();
        test.addSong("first");
        test.addSong("second");
        test.clear();
        assertEquals(test.length(), 0);
    }
}
