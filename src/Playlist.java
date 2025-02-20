import components.queue.Queue;
import components.queue.Queue2;

/**
 * playlist.
 *
 * @author Aidan McBride
 */
public final class Playlist {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    public Playlist() {
        this.newPlaylist();
    }

    /**
     * the thing.
     */
    private Queue<String> playlist;

    /**
     * the thing maker. i hate checkstyle.
     */
    private void newPlaylist() {
        this.playlist = new Queue2<String>();
    }

    /**
     * shuffles the queue so you can dequeue.
     *
     * @param q
     *            the queue
     * @param x
     *            the thing to move to
     */
    private static void moveToFront(Queue<String> q, String x) {
        assert q != null : "Violation of: q is not null";

        boolean loop = true;
        int maxCycles = q.length();
        while (loop) {
            if (maxCycles != 0) {
                String temp = q.dequeue();
                q.enqueue(temp);
                if (q.front().equals(x)) {
                    loop = false;
                }
            } else {
                loop = false;
            }
        }

    }

    /**
     * adds a song to the end.
     *
     * @param song
     *            the song name
     */
    public void addSong(String song) {
        this.playlist.enqueue(song);
    }

    /**
     * removes song then returns name.
     *
     * @param song
     *            the song name
     * @return the name of removed song
     */
    public String removeSong(String song) {
        moveToFront(this.playlist, song);
        return this.playlist.dequeue();
    }

    /**
     * returns if song exists in playlist.
     *
     * @param song
     *            the song to check
     * @return true/false
     */
    public boolean containsSong(String song) {
        moveToFront(this.playlist, song);
        return this.playlist.front().equals(song);
    }

    /**
     * shuffles the playlist with math.random. currently broken as i need to
     * figure out how to prevent overwriting the same array index twice.
     */
    public void shuffle() {
        int min = 0;
        int max = this.playlist.length();
        int originalSize = max;
        String[] temp = new String[max];
        for (int i = 0; i <= max; i++) {
            max = this.playlist.length();
            temp[(int) Math.random() * (max - min) + min] = this.playlist
                    .dequeue();
        }
        for (int i = 1; i < originalSize + 1; i++) {
            this.playlist.enqueue(temp[i]);
        }
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments; unused here
     */
    public static void main(String[] args) {

        Playlist test = new Playlist();

        test.addSong("test");
        test.addSong("ajwdjawdjkawd");
        test.addSong("1234");
        test.addSong("hhrlp");

        String removed = test.removeSong("1234");
        System.out.println(removed);

        //test.shuffle();

        System.out.println(test.toString());

        //probably will rewrite with a different data structure, who knows.
    }

}
