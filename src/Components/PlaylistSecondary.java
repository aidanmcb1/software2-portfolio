package Components;

import java.util.Random;

import components.queue.Queue;
import components.queue.Queue2;

/**
 * This class is looking a bit abstract...
 */
public abstract class PlaylistSecondary implements Playlist {

    @Override
    public final boolean containsSong(String song) {
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

    @Override
    public final String removeSong(String name) {
        String answer = "";
        for (int i = 0; i < this.length(); i++) {
            String current = this.removeFront();
            if (current.compareTo(name) == 0 && answer.compareTo("") == 0) {
                answer = current;
            } else {
                this.addSong(current);
            }

        }
        return answer;
    }

    @Override
    public final String randomSong() {
        Random random = new Random();
        int songSelection = random.nextInt(this.length());
        for (int i = 0; i <= songSelection; i++) {
            this.addSong(this.removeFront());
        }
        return this.removeFront();
    }

    @Override
    public final void shuffle() {
        Queue<String> temp = new Queue2<String>();
        for (int i = 0; i < this.length(); i++) {
            temp.enqueue(this.randomSong());
        }
        for (int i = 0; i < temp.length(); i++) {
            this.addSong(temp.dequeue());
        }
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Playlist conatins: ");
        for (int i = 0; i < this.length(); i++) {
            String temp = this.removeFront();
            sb.append(temp);
            sb.append(", ");
            this.addSong(temp);
        }
        return sb.toString();
    }

    @Override
    public final boolean equals(Object obj) {
        boolean equals = true;
        if (!(obj instanceof Playlist)) {
            equals = false;
        } else {
            Playlist compared = (Playlist) obj;
            for (int i = 0; i < this.length(); i++) {
                String song1 = this.removeFront();
                String song2 = compared.removeFront();
                if (song1.compareTo(song2) != 0) {
                    equals = false;
                }
                this.addSong(song1);
                compared.addSong(song2);
            }
        }
        return equals;
    }

    @Override
    public final int hashCode() {
        int count = 0;

        for (int i = 0; i < this.length(); i++) {
            String temp = this.removeFront();
            count += temp.length();
            this.addSong(temp);
        }

        return count;
    }
}
