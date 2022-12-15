import java.util.*;

public class Encryptor {

    public static final String ALPHABET = "абвгдеёжзиклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    private static int cypherKey = 0;

    public static int getCypherKey() {
        return cypherKey;
    }
    public static void setCypherKey(int cypherKey) {
        Encryptor.cypherKey = cypherKey;
    }

    public static void encryptFileWithKey() {
        ArrayList<Character> modifyAlphabetArrayList = new ArrayList<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            modifyAlphabetArrayList.add(ALPHABET.charAt(i));
        }
        String plainTextString = ("Абв \"очередь\" вызывает stu-.").toLowerCase();
        System.out.println(plainTextString);
        String encryptedString = "";
        setCypherKey(2);
        Collections.rotate(modifyAlphabetArrayList, -getCypherKey());
        for (int i = 0; i < plainTextString.length(); i++) {
            if (ALPHABET.indexOf(plainTextString.charAt(i)) < 0) {
                encryptedString = encryptedString + plainTextString.charAt(i);
            } else {
                encryptedString = encryptedString + (modifyAlphabetArrayList.get(ALPHABET.indexOf(plainTextString.charAt(i))));
            }
        }
        System.out.println(encryptedString);
        System.out.print("Method encryptFileWithKey finished\n\n");
    }


    public static void decryptFileWithKey() {
        ArrayList<Character> modifyAlphabetArrayList = new ArrayList<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            modifyAlphabetArrayList.add(ALPHABET.charAt(i));
        }
        String encryptedString = ("вгдб-рщжтжёю-бдэкэдвжфбstu?\"").toLowerCase();
        System.out.println(encryptedString);
        String decryptedString = "";
        setCypherKey(2);
        Collections.rotate(modifyAlphabetArrayList, -getCypherKey());
        for (int i = 0; i < encryptedString.length(); i++) {
            if (modifyAlphabetArrayList.indexOf(encryptedString.charAt(i)) < 0) {
                decryptedString = decryptedString + encryptedString.charAt(i);
            } else {
                decryptedString = decryptedString + (ALPHABET.charAt(modifyAlphabetArrayList.indexOf(encryptedString.charAt(i))));
            }
        }
        System.out.println(decryptedString);
        System.out.print("Method decryptFileWithKey finished\n\n");
    }


    public static void bruteForceFile() {
        ArrayList<Character> modifyAlphabetArrayList = new ArrayList<>();
        for (int i = 0; i < ALPHABET.length(); i++) {
            modifyAlphabetArrayList.add(ALPHABET.charAt(i));
        }
        int key = 0;
        String plainTextString = ("Абв \"очередь\" вызывает stu-.").toLowerCase();
        String encryptedString = ("вгдб-рщжтжёю-бдэкэдвжфбstu?\"").toLowerCase();
        System.out.println(encryptedString);
        for (var i = 0; i < ALPHABET.length(); i++) {
            String decryptedString = "";
            for (int j = 0; j < encryptedString.length(); j++) {
                if (modifyAlphabetArrayList.indexOf(encryptedString.charAt(j)) < 0) {
                    decryptedString = decryptedString + encryptedString.charAt(j);
                } else {
                    decryptedString = decryptedString + (ALPHABET.charAt(modifyAlphabetArrayList.indexOf(encryptedString.charAt(j))));
                }
            }
            if (checkDecryptedFile(plainTextString, decryptedString)) {
                System.out.println("checkDecryptedFile success!");
                System.out.println("the key was: " + key);
                System.out.println("plain text was: " + decryptedString);
                break;
            }
            Collections.rotate(modifyAlphabetArrayList, -1);
            key++;
        }
        System.out.println("Method bruteForceFile finished\n\n");
    }


    public static boolean checkDecryptedFile(String plainTextString, String decryptedString) {
        return plainTextString.equalsIgnoreCase(decryptedString);
    }

    public static void gatherStatisticFromFile() {
        System.out.println("Method gatherStatisticFromFile finished");
    }

    public static void decryptFileUsingStatistics() {
        System.out.println("Method decryptFileUsingStatistics finished");
    }
}
