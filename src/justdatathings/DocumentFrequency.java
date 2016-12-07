/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justdatathings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndietz
 */
public class DocumentFrequency {
    private HashMap<String, Integer> words;
    public static String noiseWordArray[] = {"a", "about", "above", "all", "along","also", "although", "am", "an", "and", "any", "are", "aren't", "as", "at","be", "because", "been", "but", "by", "can", "cannot", "could", "couldn't","did", "didn't", "do", "does", "doesn't", "e.g.", "either", "etc", "etc.","even", "ever", "enough", "for", "from", "further", "get", "gets", "got", "had", "have","hardly", "has", "hasn't", "having", "he", "hence", "her", "here","hereby", "herein", "hereof", "hereon", "hereto", "herewith", "him","his", "how", "however", "i", "i.e.", "if", "in", "into", "it", "it's", "its","me", "more", "most", "mr", "my", "near", "nor", "now", "no", "not", "or", "on", "of", "onto","other", "our", "out", "over", "really", "said", "same", "she","should", "shouldn't", "since", "so", "some", "such","than", "that", "the", "their", "them", "then", "there", "thereby","therefore", "therefrom", "therein", "thereof", "thereon", "thereto","therewith", "these", "they", "this", "those", "through", "thus", "to","too", "under", "until", "unto", "upon", "us", "very", "was", "wasn't","we", "were", "what", "when", "where", "whereby", "wherein", "whether","which", "while", "who", "whom", "whose", "why", "with", "without","would", "you", "your", "yours", "yes"};
    
    public DocumentFrequency() {
        this.words = new HashMap<>();
    }
    

    public Integer GetWordFrequency(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        }

        return 0;
    }
    
    public Set<Map.Entry<String, Integer>> WordsAsEntrySet() {
        return words.entrySet();
    }

    public void populateWords(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                for (String word : line.split("\\s+")) {
                    word = word.replaceAll("[^a-zA-Z]+","").toLowerCase();
                    if (word.length() > 0 && words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    }
                    else if (word.length() > 0) {
                        words.put(word, 1);
                    }
                }
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
