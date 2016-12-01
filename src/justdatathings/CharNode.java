/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justdatathings;


/**
 *
 * @author nnegrey
 */
public class CharNode {
    private char letter;
    private ArrayList<WordNode> frequentWords;
    private HashMap<Char, CharNode> childrenNodes;

    public CharNode(char l) {
        letter = l;
        frequentWords = new ArrayList<>();
        childrenNodes = new Hashmap<>();
    }

    public char getLetter() {
        return letter;
    }

    public addWord(WordEntry wordEntry) {
        if (frequentWords.size() > 0) {
            for (int i = 0; i < frequentWords.size(); i++) {
                if (wordNode.getFrequency() > frequentWords.get(i).getFrequency()) {
                    frequentWords.add(i, wordEntry);
                }
            }
        }
        else {
            frequentWords.add(wordEntry);
        }
    }

    public ArrayList<String> getFrequentWords() {
        ArrayList<String> words = new ArrayList<>();
        for (WordNode wordNode : frequentWords) {
            words.add(wordNode.getWord());
        }
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
