import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;

/**
 * First use case. A music library.
 */
public class MusicLibrary {

    /**
     * Data Structure.
     */
    private Map<String, Playlist> library;

    /**
     * Initial representation.
     */
    private void createNewRep() {
        this.library = new Map1L<String, Playlist>();
    }

    /**
     * Constructor.
     */
    public MusicLibrary() {
        this.createNewRep();
    }

    /**
     * Creates a new playlist.
     *
     * @param name
     *            name of playlist
     */
    final void newPlaylist(String name) {
        this.library.add(name, new Playlist1L());
    }

    /**
     * Removes playlist by name and returns it.
     *
     * @param name
     *            playlist to be removed
     * @return the removed playlist
     */
    final Pair<String, Playlist> removePlaylist(String name) {
        return this.library.remove(name);
    }

    /**
     * Adds a song to specified playlist.
     *
     * @param playlist
     *            the playlist to add to
     * @param name
     *            the name of added song
     */
    final void addSong(String playlist, String name) {
        Pair<String, Playlist> currentPair = this.removePlaylist(playlist);
        Playlist currentPlaylist = currentPair.value();
        currentPlaylist.addSong(name);
        this.library.add(name, currentPlaylist);
    }

    /**
     * Removes a song to specified playlist.
     *
     * @param playlist
     *            the playlist to remove from
     * @param name
     *            the name of removed song
     * @return the removed song
     */
    final String removeSong(String playlist, String name) {
        Pair<String, Playlist> currentPair = this.removePlaylist(playlist);
        Playlist currentPlaylist = currentPair.value();
        String removed = currentPlaylist.removeSong(name);
        this.library.add(name, currentPlaylist);
        return removed;
    }

}
