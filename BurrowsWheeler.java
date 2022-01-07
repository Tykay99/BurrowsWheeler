import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class BurrowsWheeler {
    // Size of Alphabet
    private static final int SIZE = 256;

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        String word = BinaryStdIn.readString();
        CircularSuffixArray suffix = new CircularSuffixArray(word);
        for (int n = 0; n < suffix.length(); n++) {
            if (suffix.index(n) == 0) {
                BinaryStdOut.write(n);
            }
        }
        for (int n = 0; n < suffix.length(); n++) {
            BinaryStdOut.write(word.charAt((suffix.index(n) + word.length() - 1)
                                                   % word.length()));
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int n = BinaryStdIn.readInt();
        String s = BinaryStdIn.readString();
        char[] chars = new char[s.length()];
        char[] sorted = new char[s.length()];
        char[] regular = new char[s.length()];
        int[] count = new int[SIZE + 1];
        for (int x = 0; x < s.length(); x++) {
            chars[x] = s.charAt(x);
            regular[x] = s.charAt(x);
        }
        // apply key-index counting
        int[] next = new int[s.length()];
        for (int i = 0; i < s.length(); i++) count[chars[i] + 1]++;
        for (int r = 0; r < SIZE; r++) count[r + 1] = count[r] + count[r + 1];
        for (int i = 0; i < s.length(); i++) sorted[count[chars[i]]++] = chars[i];

        for (int x = s.length() - 1; x >= 0; x--) {
            char y = regular[x];
            int z = count[y] - 1;
            count[y]--;
            next[z] = x;
        }
        int counter = 0;
        while (counter < s.length()) {
            counter++;
            BinaryStdOut.write(sorted[n]);
            n = next[n];
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        if (args[0].equals("-")) transform();
        if (args[0].equals("+")) inverseTransform();
    }
}
