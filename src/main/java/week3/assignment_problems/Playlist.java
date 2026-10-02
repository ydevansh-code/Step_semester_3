package week3.assignment_problems;

public class Playlist {
    private String[] songs;
    private int count;

    public Playlist(int maxSize) {
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String songTitle) {
        if (count < songs.length) {
            songs[count] = songTitle;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        for (int i = 0; i < count; i++) {
            copy[i] = songs[i];
        }
        return copy;
    }

    public int getSongCount() {
        return count;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");
        String[] copy = p.getSongs();
        copy[0] = "Hacked";
        System.out.println("Original array at 0: " + p.getSongs()[0]);
    }
}
