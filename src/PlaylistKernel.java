import components.standard.Standard;

/**
 * Playlist Primary Methods.
 */
public interface PlaylistKernel extends Standard<Playlist> {

    /**
     * Add a song to the end of the playlist.
     *
     * @param song
     *            the song to be added
     * @updates this
     * @ensures this = #this + song
     */
    void addSong(String song);

    /**
     * Removes the song at the front of the queue.
     *
     * @requires song is in this
     * @updates this
     * @ensures this = #this - song
     * @return the removed song
     */
    String removeFront();

    /**
     * Returns how many songs are in playlist.
     *
     * @return length of playlist
     */
    int length();
}
