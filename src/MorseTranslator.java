import java.util.Scanner;
public class MorseTranslator {
    public static void main(String[] args) {
        MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter text:");
        String input = scanner.nextLine();

        if (Character.isLetter(input.charAt(0))) {
            // Input is in English
            String morse = morseCodeTranslator.toMorseCode(input);
            System.out.println("Morse: " + morse);
        } else {
            try {
                String englishText = morseCodeTranslator.toEnglish(input);
                System.out.println("English: " + englishText);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}