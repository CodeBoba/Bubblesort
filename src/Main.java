import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Dateneingabe aus Datei
        File eingabe = new File("./eingabe.txt");
        Scanner scanner = new Scanner(eingabe);
        ArrayList<Integer> eingabeDaten = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String zeile = scanner.nextLine();
            String[] elements = zeile.split(" ");
            for (String element : elements) {
                eingabeDaten.add(Integer.parseInt(element));
            }
        }
        //Bubblesort Algorithmus
        for (int i = 0; i < eingabeDaten.size() - 1; i++) {
            for (int j = 0; j < eingabeDaten.size() - i - 1; j++) {
                if (eingabeDaten.get(j) > eingabeDaten.get(j + 1)) {
                    int temp = eingabeDaten.get(j);
                    eingabeDaten.set(j, eingabeDaten.get(j + 1));
                    eingabeDaten.set(j + 1, temp);
                    System.out.println(eingabeDaten);
                }
            }
        }
        //Sortierte Ausgabe in neue Datei schreiben
        BufferedWriter writer = new BufferedWriter(new FileWriter("./ausgabe.txt"));
        for (Integer element : eingabeDaten) {
            writer.write(element + " ");
        }
        writer.close();
    }
}