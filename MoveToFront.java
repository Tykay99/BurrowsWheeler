import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
    // size of alphabet
    private static final int SIZE = 256;

    // apply move-to-front encoding, reading from stdin and writing to stdout
    public static void encode() {
        char[] chars = new char[SIZE];
        for (int n = 0; n < SIZE; n++) {
            chars[n] = (char) n;
        }
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            for (int n = 0; n < SIZE; n++) {
                if (chars[n] == c) {
                    for (int x = n; x > 0; x--) {
                        chars[x] = chars[x - 1];
                    }
                    chars[0] = c;
                    BinaryStdOut.write((char) n);
                    break;
                }
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from stdin and writing to stdout
    public static void decode() {
        char[] chars = new char[SIZE];
        for (int n = 0; n < SIZE; n++) {
            chars[n] = (char) n;
        }
        while (!BinaryStdIn.isEmpty()) {
            int c = BinaryStdIn.readChar();
            BinaryStdOut.write(chars[c]);
            char temp = chars[c];
            for (int x = c; x > 0; x--) {
                chars[x] = chars[x - 1];
            }
            chars[0] = temp;
        }
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args) {
        if (args[0].equals("-")) encode();
        if (args[0].equals("+")) decode();
    }
}
