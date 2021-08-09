package rumit.bigram;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/**
 * A Bigram parsing object to read in a file and create a histogram of bigrams
 * (Frequency that two words next to each other appear next to each other in the file)
 */
public class BigramParser {

    private String parseFile;
    private LinkedHashMap<String, Integer> mapa;

    /**
     * Constructor
     * @param inputFile - name of the input text file
     */
    public BigramParser(String inputFile) {
        parseFile = inputFile;
        mapa = new LinkedHashMap<>();
    }

    /**
     * Print out file name followed by the histogram of each bigram
     */
    public String printHistogram() {
        String result = "";
        System.out.println("'" + parseFile + "' Histogram of Bigrams:\n");
        return mapa.entrySet().stream().map((a)->a.getKey()+" = "+a.getValue()).collect(Collectors.joining());
    }

    /**
     * Read in the file and count the bigram frequencies
     * @return boolean if it successfully worked - unsuccessful returns for testing
     */
    public boolean parseFile(String bigramTarget) {
        try {
            String fileText = "";
            File file = new File(parseFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while( (str = br.readLine()) != null ) {
                fileText += str + " ";
            }

            fileText = fileText.toLowerCase().replaceAll("([a-zA-Z])[^a-zA-Z ]([a-zA-Z])", "$1$2").replaceAll("[^a-zA-Z ]", " ").replaceAll(" +", " ").trim();
            String[] words = fileText.split("\\s+", -1);
            int wordLength = words.length;

            if (bigramTarget == ""|| bigramTarget == null) bigramTarget = "invalid input was provided";
            for(int i = 1; i < wordLength; i++) {
                bigramTarget = bigramTarget.toLowerCase().replaceAll(" +", " ").trim();
                if(!mapa.containsKey(bigramTarget)) {
                    int frequency = this.getBigramFrequency(fileText, bigramTarget);
                    mapa.put(bigramTarget, frequency);
                }
            }
        }
        catch( Exception e ) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * internal helper function to get the frequency on a bigram in the give string
     * @param 'String' of the file text
     * @param 'String' of the bigram we want the frequency for
     * @return int of the frequency of given bigram
     */
    private int getBigramFrequency(String fullTxt, String bigram) {
        int bigRamFrequency = 0;
        int lastIndex = 0;
        int bigramLength = bigram.length();

        while(lastIndex != -1) {
            lastIndex = fullTxt.indexOf(bigram, lastIndex);
            if(lastIndex != -1) {
                bigRamFrequency++;
                lastIndex += bigramLength;
            }
        }
        return bigRamFrequency;
    }
    }


