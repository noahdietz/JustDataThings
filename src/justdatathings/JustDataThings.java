/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justdatathings;

import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author ndietz
 */
public class JustDataThings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         DocumentFrequency df = new DocumentFrequency();
         df.populateWords(args[0]);
         CharNode root = generateTree(df);
         System.out.println(root);
    }


    public static CharNode generateTree(DocumentFrequency df) {
        CharNode root = new CharNode('.');
        for (Map.Entry<String, Integer> map : df.WordsAsEntrySet()) {
            char[] letters = map.getKey().toCharArray();
            WordEntry wordEntry = new WordEntry(map.getKey(), map.getValue());
            root.addChild(addLetters(root, letters, wordEntry));
        }
        
        return root;
    }

    public static CharNode addLetters(CharNode curCharNode, char[] letters, WordEntry wordEntry) {
        char letter = letters[0];
        CharNode charNode;
        if (curCharNode.hasLetter(letter)) {
            charNode = curCharNode.getChild(letter);
        }
        else {
            charNode = new CharNode(letter);
        }
        charNode.addWord(wordEntry);
        if (letters.length == 1) {
            return charNode;
        }
        else {
            charNode.addChild(addLetters(charNode, Arrays.copyOfRange(letters, 1, letters.length), wordEntry));
        }
        return charNode;
    }
}
