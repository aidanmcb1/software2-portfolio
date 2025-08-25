package Components;

/**
 * Playlist enhanced with secondary methods.
 */
public interface Playlist extends PlaylistKernel {

    /**
     * Returns if song is in playlist.
     *
     * @param song
     *            song to check for
     * @return if song is in playlist
     */
    boolean containsSong(String song);

    /**
     * Remove specified song from playlist.
     *
     * @param name
     *            name of song to be removed
     * @return the song removed
     * @updates this
     * @requires name to be in playlist
     * @ensures #playlist = Splaylist + return
     */
    String removeSong(String name);

    /**
     * Shuffles the playlist.
     *
     * @updates this
     * @ensures order of playlist != order of #playlist
     */
    void shuffle();

    /**
     * Returns a (pseudo)random song, and not just the first every time.
     *
     * @updates this
     * @ensures playlist consists of all previous songs except returned song
     * @return the random song
     */
    String randomSong();

}
