import java.io.*;
import java.time.LocalDateTime;

public class Follow {
    public static void main(String[] args) throws IOException {
        String email = args[0];
        String toFollow = args[1];
        String date = LocalDateTime.now().toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("follows.dat", true))) {
            writer.write(email + "|" + date + "|" + toFollow);
            writer.newLine();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("subscriptions.dat", true))) {
            writer.write(email + "|" + toFollow);
            writer.newLine();
        }

        System.out.println(email + " now follows " + toFollow);
    }
}
