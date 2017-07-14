
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SuggestionDataManager implements ISuggestionDataManager {

    Trie t;
    Node root;

    public SuggestionDataManager() {
        t = new Trie();
        root = new Node();

        try {
            BufferedReader b = new BufferedReader(new FileReader("C:\\Users\\GEETHA\\Desktop\\dictionary.txt"));
            while (true) {
                String line = b.readLine();
                if (line == null) {
                    break;
                }
                t.insertWord(root, line);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SuggestionDataManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SuggestionDataManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ArrayList<String> getSuggestions(String prefix) {
        ArrayList<String> w = t.autoSuggest(root, prefix);

        if (w==null) {
            return null;
        } else {
            return w;
        }

    }

}
