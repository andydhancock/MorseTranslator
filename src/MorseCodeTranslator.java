import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {
    private Map<Character, String> morseCodeMap;
    private static Map<String, Character> englishMap;

    public MorseCodeTranslator() {
        morseCodeMap = new HashMap<>();
        englishMap = new HashMap<>();
        morseCodeMap.put(' ', "  ");
        morseCodeMap.put('A', "*-");
        morseCodeMap.put('B', "-***");
        morseCodeMap.put('C', "-*-*");
        morseCodeMap.put('D', "-**");
        morseCodeMap.put('E', "*");
        morseCodeMap.put('F', "**-*");
        morseCodeMap.put('G', "--*");
        morseCodeMap.put('H', "****");
        morseCodeMap.put('I', "**");
        morseCodeMap.put('J', "*---");
        morseCodeMap.put('K', "-*-");
        morseCodeMap.put('L', "*-**");
        morseCodeMap.put('M', "--");
        morseCodeMap.put('N', "-*");
        morseCodeMap.put('O', "---");
        morseCodeMap.put('P', "*--*");
        morseCodeMap.put('Q', "--*-");
        morseCodeMap.put('R', "*-*");
        morseCodeMap.put('S', "***");
        morseCodeMap.put('T', "-");
        morseCodeMap.put('U', "**-");
        morseCodeMap.put('V', "***-");
        morseCodeMap.put('W', "*--");
        morseCodeMap.put('X', "-**-");
        morseCodeMap.put('Y', "-*--");
        morseCodeMap.put('Z', "--**");
        morseCodeMap.put('0', "-----");
        morseCodeMap.put('1', "*----");
        morseCodeMap.put('2', "**---");
        morseCodeMap.put('3', "***--");
        morseCodeMap.put('4', "****-");
        morseCodeMap.put('5', "*****");
        morseCodeMap.put('6', "-****");
        morseCodeMap.put('7', "--***");
        morseCodeMap.put('8', "---**");
        morseCodeMap.put('9', "----*");
        morseCodeMap.put('.', "*-*-*-");
        morseCodeMap.put(',', "--**--");
        morseCodeMap.put('?', "**--**");


        for(Map.Entry<Character, String> entry : morseCodeMap.entrySet()) {
            englishMap.put(entry.getValue(), entry.getKey());
        }

    }



    public String toMorseCode(String englishText) {
        englishText = englishText.toUpperCase();
        String morseCode = "";

        for (int i = 0; i < englishText.length(); i++) {
            char c = englishText.charAt(i);
            String code = morseCodeMap.get(c);
            if (code != null) {
                morseCode += code + " ";
            } else {
                throw new IllegalArgumentException("Invalid character: " + c);
            }
        }

        return morseCode.trim();
    }

    public static String toEnglish(String morseCode) {

        String english = "";

        String[] letters = morseCode.split(" ");
        for (String letter : letters) {
            if(letter.length() == 0) {
                english  = english.trim() + " ";
                continue;
            }
            if (englishMap.containsKey(letter)) {
                english += englishMap.get(letter);
            } else {
                throw new IllegalArgumentException("Invalid character: " + letter);
            }
        }

        return english.trim();
    }
}