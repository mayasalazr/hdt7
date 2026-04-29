
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BinaryTree<Association<String, String>> tree = new BinaryTree<>();

        BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));
        String line;

        while ((line = br.readLine()) != null) {
            line = line.replace("(", "").replace(")", "");
            String[] parts = line.split(",");

            String english = parts[0].trim().toLowerCase();
            String spanish = parts[1].trim();

            tree.insert(new Association<>(english, spanish));
        }

        br.close();

        System.out.println("Diccionario ordenado:");
        tree.inOrder();

                BufferedReader textReader = new BufferedReader(new FileReader("texto.txt"));

        String textLine;
        while ((textLine = textReader.readLine()) != null) {

            String[] words = textLine.split(" ");

            for (String word : words) {
                String cleanWord = word.toLowerCase().replaceAll("[^a-z]", "");

                Association<String, String> temp = new Association<>(cleanWord, "");
                Association<String, String> result = tree.search(temp);

                if (result != null) {
                    System.out.print(result.getValue() + " ");
                } else {
                    System.out.print("*" + word + "* ");
                }
            }
            System.out.println();
        }

        textReader.close();
    }
}