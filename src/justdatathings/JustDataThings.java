/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package justdatathings;

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
         DocumentFrequency df = DocumentFrequency();
         df.populateWords("../data/debate.txt");
    }
    
}
