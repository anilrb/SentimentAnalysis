package analysis;

import edu.stanford.nlp.ling.*;
import edu.stanford.nlp.pipeline.*;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.*;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
@Service
public class SentimentText {

    public SentimentText(){

    }
    public SentimentModal getSentimentalAnalysis() throws IOException {

        int pos=0;

        int neg=0;

        int netural=0;
        ArrayList<String>  stringArrayList=new ArrayList<String>();
        File file= ResourceUtils.getFile("classpath:card.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringArrayList.add(line);
        }
        fileReader.close();
        bufferedReader.close();


        Map<String,ArrayList>stringArrayListMap=new HashMap<String,ArrayList>();

        stringArrayListMap.put("card",stringArrayList);


        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, parse, sentiment");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        ArrayList<String > arrayList=stringArrayListMap.get("card");
        for (String card:arrayList) {
            Annotation annotation = (Annotation) pipeline.process(card);
            List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);
            for (CoreMap sentence : sentences) {
                String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
                if (sentiment.equalsIgnoreCase("Positive")){
                    pos++;
                }
                else if (sentiment.equalsIgnoreCase("Negative")){
                    neg++;
                }
                else if (sentiment.equalsIgnoreCase("Very Positive")){
                    pos++;
                }
                else {
                    netural++;
                }
            }
        }
        SentimentModal sentimentModal=new SentimentModal();
        sentimentModal.setNatural(netural);
        sentimentModal.setPostive(pos);
        sentimentModal.setNegative(neg);
        return sentimentModal;

    }
}
