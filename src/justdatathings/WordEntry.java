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
public class WordEntry {
    private String word;
    private int frequency;

    public WordEntry(String w, int f) {
        word = w;
        frequency = f;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }
}
