/**
 * Playlist Primary Methods.
 */
public interface PlaylistKernel {

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
     * Remove a song to the end of the playlist.
     *
     * @param song
     *            the song to be removed
     * @requires song is in this
     * @updates this
     * @ensures this = #this - song
     * @return the removed song
     */
    String removeSong(String song);
}
