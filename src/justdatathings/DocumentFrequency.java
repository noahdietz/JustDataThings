/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justdatathings;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ndietz
 */
public class DocumentFrequency {
    private HashMap<String, Integer> words;
    
    public DocumentFrequency() {
        this.words = new HashMap<>();
    }
    
    public void process(String fileName) {
        // read data file
        byte[] encoded = null;
        try {
            encoded = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException ex) {
            Logger.getLogger("DocumentFrequency").log(Level.SEVERE, null, ex);
        }
        String data = new String(encoded, Charset.defaultCharset());
        
        Scanner input = new Scanner(data);
    }

    public void populateWords(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            for(String line; (line = br.readLine()) != null; ) {
                // process the line.
                for (String word : line.split("\\s+")) {
                    if (words.containsKey(line)) {
                        words.put(word, words.get(word) + 1);
                    }
                    else {
                        words.put(word, 1);
                    }
                }
            }
            // line is not visible here.
        }
    }
}
