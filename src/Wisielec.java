import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Wisielec {
    List<String> words = List.of("samochód", "misio", "programowanie", "komputer");
    String word;
    char[] userWord;
    int lives = 3;
    int currentExperience = 0;
    public void play() {
        Scanner scanner = new Scanner(System.in);

        Random random = new Random();
        word = words.get(random.nextInt(words.size()));

        userWord = new char[word.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded()) {
            System.out.println(userWord);
            System.out.println();
            System.out.println("Podaj kolejną litere: ");
            System.out.println("Pozostało żyć:" + lives);

            char letter = scanner.nextLine().charAt(0);

            checkLetter(letter);
        }
        if (lives == 0) {
            System.out.println("Przegrałeś, spróbuj ponownie");
        }
        else {
            currentExperience += 20;
            System.out.println("Gratulacje, przeszedłeś poziom 1");
            System.out.println("gratulacje, zdobyłeś 20 pkt doświadczenia");
        }
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord[i] = letter;
                foundLetter = true;
            }
        }

        if (!foundLetter) {
            System.out.println("Niestety, tej litery nie ma w danym słowie");
            lives--;
        }
    }

    private boolean gameEnded() {
        return lives == 0 || word.equals(String.valueOf(userWord));
    }
}

