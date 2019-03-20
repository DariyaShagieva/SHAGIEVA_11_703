import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {

// использовалось для предложений
        Pars pars = new Pars();
        //алкоголь
        String url12 = "https://m.habr.com/ru/post/441252/";
        List<List<String>> documents = pars.pars(url12);










        TFIDFCalculator calculator = new TFIDFCalculator();
        HashSet<String> hashSet = new HashSet<String>();
        for (List<String> docs: documents) {

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            for (String word: docs) {
                if (!hashSet.contains(word)) {
                    double tfidf = calculator.tfIdf(docs, documents, word);
                    System.out.println("TF-IDF " + word + " = " + tfidf);
                    hashSet.add(word);
                }
            }
            hashSet.clear();

        }
    }
}
