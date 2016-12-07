/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justdatathings;

import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author nnegrey
 */
public class CharNode {
    private char letter;
    private ArrayList<WordEntry> frequentWords;
    private HashMap<Character, CharNode> childrenNodes;

    public CharNode(char l) {
        letter = l;
        frequentWords = new ArrayList<>();
        childrenNodes = new HashMap<>();
    }
    
    @Override
    public String toString() {
        return letter + "\n\tfrequent words: " + frequentWords.toString() + "\n\tchildrens: " + childrenNodes.toString();
    }

    public char getLetter() {
        return letter;
    }

    public void addWord(WordEntry wordEntry) {
        boolean added = false;
        if (frequentWords.size() > 0) {
            for (int i = 0; i < frequentWords.size(); i++) {
                if (wordEntry.getFrequency() >= frequentWords.get(i).getFrequency()) {
                    frequentWords.add(i, wordEntry);
                    added = true;
                    break;
                }
            }
            
            if (!added) {
                frequentWords.add(wordEntry);
            }
        }
        else {
            frequentWords.add(wordEntry);
        }
    }

    public ArrayList<String> getFrequentWords() {
        ArrayList<String> words = new ArrayList<>();
        for (WordEntry wordEntry : frequentWords) {
            words.add(wordEntry.getWord());
        }
        
        return words;
    }

    public void addChild(CharNode childNode) {
        if (!childrenNodes.containsKey(childNode.getLetter())) {
            childrenNodes.put(childNode.getLetter(), childNode);
        }
    }

    public boolean hasLetter(char c) {
        return childrenNodes.containsKey(c);
    }

    public CharNode getChild(char c) {
        return childrenNodes.get(c);
    }
}
