
import java.util.ArrayList;

class Node {

    boolean isEOW;
    Node[] next = new Node[26];
}

public class Trie {

    Node root = new Node();
    ArrayList<String> words = new ArrayList<>();

    void insertWord(Node root, String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);
            int idx = c - 'a';
            if (temp.next[idx] == null) {
                temp.next[idx] = new Node();
            }
            temp = temp.next[idx];
        }
        temp.isEOW = true;

    }

    ArrayList<String> printAllWordsHelper(Node root, String prefix) {

        if (root.isEOW == true) {
            words.add(prefix);
        }

        for (int i = 0; i < 26; i++) {
            if (root.next[i] != null) {
                char c = (char) (i + 'a');
                String newPrefix = prefix.concat(c + "");
                printAllWordsHelper(root.next[i], newPrefix);
            }

        }
        return words;
    }

    ArrayList<String> printAllWords(Node root) {
        ArrayList<String> a = new ArrayList<>();

        a = printAllWordsHelper(root, "");

        return a;
    }

    ArrayList<String> autoSuggest(Node root, String prefix) {
        words.clear();
        for (int i = 0; i < prefix.length(); i++) {
            if (root.next[prefix.charAt(i) - 'a'] != null) {
                root = root.next[prefix.charAt(i) - 'a'];

            } else {
                return null;
            }

        }
        printAllWordsHelper(root, prefix);
        return words;
    }

 

}
