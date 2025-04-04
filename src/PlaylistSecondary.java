import java.util.Random;

import components.queue.Queue;
import components.queue.Queue2;

/**
 * This class is looking a bit abstract...
 */
public abstract class PlaylistSecondary implements Playlist {

    /**
     * Returns if song is in playlist.
     *
     * @param song
     *            song to check for
     * @return if song is in playlist
     */
    @Override
    public boolean containsSong(String song) {
        boolean result = false;
        for (int i = 0; i < this.length(); i++) {
            String temp = this.removeFront();
            if (temp.compareTo(song) == 0) {
                result = true;
            }
            this.addSong(temp);
        }

        return result;
    }

    /**
     * Returns a (pseudo)random song, and not just the first every time.
     *
     * @updates this
     * @ensures playlist consists of all previous songs except returned song
     * @return the removed song
     */
    @Override
    public String randomSong() {
        Random random = new Random();
        int songSelection = random.nextInt(this.length());
        for (int i = 0; i <= songSelection; i++) {
            this.addSong(this.removeFront());
        }
        return this.removeFront();
    }

    /**
     * Shuffles the playlist.
     *
     * @updates this
     * @ensures order of playlist != order of #playlist
     */
    @Override
    public void shuffle() {
        Queue<String> temp = new Queue2<String>();
        for (int i = 0; i < this.length(); i++) {
            temp.enqueue(this.randomSong());
        }
        for (int i = 0; i < temp.length(); i++) {
            this.addSong(temp.dequeue());
        }
    }
}
