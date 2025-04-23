import java.io.*;
import java.time.LocalDateTime;

public class Post {
    public static void main(String[] args) throws IOException {
        String email = args[0];
        String title = args[1];
        StringBuilder message = new StringBuilder();
        for (int i = 2; i < args.length; i++) message.append(args[i]).append(" ");
        String date = LocalDateTime.now().toString();

        String postEntry = email + "|" + date + "|" + title + "|" + message.toString().trim() + "\n";

        try (RandomAccessFile raf = new RandomAccessFile("posts.dat", "rw");
             BufferedWriter idxWriter = new BufferedWriter(new FileWriter("posts.idx", true))) {

            long position = raf.length(); // seek to end
            raf.seek(position);
            raf.writeBytes(postEntry);

            idxWriter.write(email + "|" + position); // index line
            idxWriter.newLine();
        }

        System.out.println("Post added.");
    }
}
