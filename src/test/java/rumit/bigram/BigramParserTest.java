package rumit.bigram;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BigramParserTest {

    public static void main(String[] args) {
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/someFile.txt");
        if(!bp.parseFile("Java")) System.out.println("This failed because the file does exist.\n");
        else System.out.println("Should have failed for non-existing file.\n");
        bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("Java");
        bp.printHistogram();
    }

    @Test
    public void testWithNotExistingFile(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/someFile.txt");
        bp.parseFile("Java");
        Assert.assertTrue(!bp.parseFile("Java"));
    }

    @Test
    public void testWithExistingFile(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("Java");
        Assert.assertTrue(bp.parseFile("Java"));
    }

    @Test
    public void HappyPathTestWithKeyWords1(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("Java");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam > 15);
    }

    @Test
    public void HappyPathTestWithKeyWords2(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile(" JAVA");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam > 15);
    }

    @Test
    public void HappyPathTestWithKeyWords3(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("TiMur");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 1);
    }

    @Test
    public void HappyPathTestWithKeyWords4(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("timur ");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 1);
    }

    @Test
    public void HappyPathTestWithKeyWords5(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile(" TIMUR");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 1);
    }

    @Test
    public void HappyPathTestWithKeyWords6(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("dzhIGkAev");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 3);
    }

    @Test
    public void HappyPathTestWithKeyWords7(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 0);
    }

    @Test
    public void HappyPathTestWithKeyWords8(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("Timur DzhigkaeV");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 1);
    }

    @Test
    public void HappyPathTestWithKeyWords9(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile(null);
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 0);
    }

    @Test
    public void HappyPathTestWithKeyWords10(){
        BigramParser bp = new BigramParser("src/test/java/rumit/bigram/resume.txt");
        bp.parseFile("Education: Northern Ossetian State University named after K.L.Hetagurov  (Mathematics and Computer Science)");
        String result = bp.printHistogram();
        int numberOfFrequencyThatAppearTheBigRam = Integer.parseInt(result.substring(result.indexOf("=")+1).trim());
        Assert.assertTrue(numberOfFrequencyThatAppearTheBigRam == 0);
    }

}
