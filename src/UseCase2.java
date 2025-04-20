
/**
 * Use case 2. A standard main program.
 */
final class UseCase2 {

    /**
     * Private constructor.
     */
    private UseCase2() {

    }

    /**
     * Main.
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {

        Playlist playlist1 = new Playlist1L();

        playlist1.addSong("Never");
        playlist1.addSong("gonna");
        playlist1.addSong("give");
        playlist1.addSong("you");
        playlist1.addSong("up");
        playlist1.addSong("gottem");

        System.out.println(playlist1.toString());

        playlist1.shuffle();

        String removed = playlist1.randomSong();

        System.out.println("Removed song " + removed);

        System.out.println("Does song " + removed + " appear? "
                + playlist1.containsSong(removed));

        playlist1.addSong(removed);

        System.out.println("Hashed value: " + playlist1.hashCode());

        Playlist playlist2 = playlist1.newInstance();

        playlist2.addSong("bingus");
        playlist2.addSong("bongus");
        playlist2.addSong("bungus");

        System.out.println(
                "Do the two playlists match? " + playlist1.equals(playlist2));

    }
}
