import java.io.*;
import java.util.*;

public class Timeline {
    public static void main(String[] args) throws IOException {
        String email = args[0];

        Set<String> following = new HashSet<>();
        Map<String, List<Long>> userPostOffsets = new HashMap<>();

        // Step 1: Load follows
        try (BufferedReader reader = new BufferedReader(new FileReader("follows.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts[0].equals(email)) following.add(parts[2]);
            }
        }

        // Step 2: Load post index
        try (BufferedReader indexReader = new BufferedReader(new FileReader("posts.idx"))) {
            String line;
            while ((line = indexReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String postUser = parts[0];
                long offset = Long.parseLong(parts[1]);
                if (following.contains(postUser)) {
                    userPostOffsets.putIfAbsent(postUser, new ArrayList<>());
                    userPostOffsets.get(postUser).add(offset);
                }
            }
        }

        // Step 3: Use RandomAccessFile to jump to post entries
        try (RandomAccessFile raf = new RandomAccessFile("posts.dat", "r")) {
            for (String user : userPostOffsets.keySet()) {
                for (long offset : userPostOffsets.get(user)) {
                    raf.seek(offset);
                    String postLine = raf.readLine();
                    String[] parts = postLine.split("\\|");
                    System.out.println("User: " + parts[0]);
                    System.out.println("Title: " + parts[2]);
                    System.out.println("Message: " + parts[3]);
                    System.out.println("Date: " + parts[1]);
                    System.out.println();
                }
            }
        }
    }
}
