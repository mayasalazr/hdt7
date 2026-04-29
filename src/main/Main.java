package main;

import com.sun.nio.sctp.Association;
import com.sun.source.tree.BinaryTree;
import java.io.*;

public class Main {
    public static void main(String [] args) throws Exception{
        BinaryTree<Association<String, String>> tree = new BinaryTree<>() {
            BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));
            String line;

            while ((line = br.readLine()) != null){
                line = line.replace("(", "").replace(")", "");
                String[] parts = line.split(",");
                String english = parts[0].trim().toLowerCase();
                String spanish = parts[1].trim();
                tree.insert(new Association<>(english, spanish));
            }

            br.close();

            System.out.println("Diccionario ordenado:");
            tree.inOrder();

            BufferedReader textReader = new BufferedReader(new FileReader("text.txt"));
            String textLine;
            while((textLine = textREader.readLine()) !=null){
                String[] word = textLine.split(" ");
                
                for(String word : words){
                    String cleanWord = word.toLowerCase().replaceAll("[^a-z", "");
                    Association<String, String> temp = new Association<>(cleanWord, "");
                    Association<String, Strin> result = tree.search(temp);

                    if (result ! = null){
                        System.out.println(result.getValue()+ " ");
                    
                    } else {
                        System.out.println("*" + word + "* ");

                }
            }

            Systeml.out.println();



















            
        }

        textReader.close()
    }

    
}
