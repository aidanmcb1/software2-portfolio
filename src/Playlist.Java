/**
 * Playlist enhanced with secondary methods.
 */
public interface Playlist extends PlaylistKernel {

    /**
     * Returns if song is in playlist.
     * @param song
     *      song to check for
     * @return if song is in playlist
     */
    boolean containsSong(String song);

    /**
     * Shuffles the playlist.
     * @updates this
     * @ensures order of playlist != order of #playlist
     */
    void shuffe();

}
