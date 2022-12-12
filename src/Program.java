public class Program {

    public static void programStart() {
        System.out.println("Let's start!");



        Encryptor.encryptFileWithKey();

        Encryptor.decryptFileWithKey();

        Encryptor.bruteForceFile();

        Encryptor.checkDecryptedFile();

        Encryptor.gatherStatisticFromFile();

        Encryptor.decryptFileUsingStatistics();

        FileBuffer.readFileFromDisk();

        FileBuffer.writeFileToDisk();




    }
}



