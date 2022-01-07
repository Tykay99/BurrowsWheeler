import edu.princeton.cs.algs4.StdOut;

public class CircularSuffixArray {
    // size of alphabet
    private static final int SIZE = 256;
    // indexes of suffix array
    private int[] index;
    // string input
    private String s;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        nullCheck(s);
        this.s = s;
        index = new int[s.length()];
        sort();
    }

    // helper function to initiate sorting
    private void sort() {
        int[] aux = new int[s.length()];
        for (int n = 0; n < s.length(); n++)
            index[n] = n;
        sort(index, aux, 0, s.length() - 1, 0);
    }

    // recursive function for sorting using MSD sort
    private void sort(int[] a, int[] aux, int lo, int hi, int d) {
        if (hi <= lo || d == s.length()) return;
        int[] count = new int[SIZE + 1];
        for (int i = lo; i <= hi; i++)
            count[s.charAt((d + a[i]) % s.length()) + 1]++;
        for (int r = 0; r < SIZE; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)
            aux[count[s.charAt((a[i] + d) % s.length())]++] = a[i];
        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];
        sort(a, aux, lo, lo + count[0] - 1, d + 1);
        for (int r = 1; r < SIZE; r++)
            sort(a, aux, lo + count[r - 1], lo + count[r] - 1, d + 1);
    }

    // length of s
    public int length() {
        return index.length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= length())
            throw new IllegalArgumentException("Out of Bounds");
        return index[i];
    }

    // check if object is null
    private void nullCheck(Object obj) {
        if (obj == null) throw new IllegalArgumentException("Null Error");
    }

    // unit testing (required)
    public static void main(String[] args) {
        CircularSuffixArray asdf = new CircularSuffixArray("couscous");
        for (int n : asdf.index)
            StdOut.println(n);
        StdOut.println(asdf.index(0));
        StdOut.println(asdf.length());
    }
}
