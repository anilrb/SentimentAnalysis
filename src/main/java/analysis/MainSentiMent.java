package analysis;

import java.io.IOException;

public class MainSentiMent {

    public static void main(String[] args) throws IOException {
      SentimentModal sentimentModal=  new SentimentText().getSentimentalAnalysis();


        System.out.println(sentimentModal);
    }
}
