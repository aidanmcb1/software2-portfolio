package Components;

import components.queue.Queue2;

/**
 * The playlist represented by a Queue. Includes primary implementations.
 *
 * @convention entries is set of valid strings.
 * @correspondence this = queue of strings.
 */
public class Playlist1L extends PlaylistSecondary {

    //Private Members
    /**
     * Representation of this.
     */
    private Queue2<String> rep;

    /**
     * Creator of initial rep.
     */
    private void createNewRep() {
        this.rep = new Queue2<String>();
    }

    //Constructors
    /**
     * No arg constructor.
     */
    public Playlist1L() {
        this.createNewRep();
    }

    //Standard Methods
    @Override
    public final Playlist newInstance() {

        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }

    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Playlist source) {
        Playlist1L localSource = (Playlist1L) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    //Kernel Methods
    @Override
    public final void addSong(String song) {

        this.rep.enqueue(song);

    }

    @Override
    public final String removeFront() {

        return this.rep.dequeue();

    }

    @Override
    public final int length() {

        return this.rep.length();

    }

}
