
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author GEETHA
 */
public class SuggestionDataManager implements ISuggestionDataManager {
//ArrayList<String> a;

    Trie t;
    Node root;

    public SuggestionDataManager() {
        // a=new ArrayList<>();
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
        // ArrayList<String> words=new ArrayList<>();
        ArrayList<String> w = t.autoSuggest(root, prefix);

        if (w==null) {
            return null;
        } else {
            return w;
        }

    }

}
