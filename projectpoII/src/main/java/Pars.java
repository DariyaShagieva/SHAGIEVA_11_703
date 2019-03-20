import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pars {

    private Document doc;

    public Pars() {

    }

// использовалось для парсинга статей

    public List<String> parsText(String url) {

        String text;
        List<String> words;
        Porter porter = new Porter();
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

            text = doc.body().getElementsByTag("p").text();
            text = text.replaceAll("[\\p{P}\\p{S}]", "");
            text = text.replaceAll("[0-9]","");
            words = Arrays.asList(text.split(" "));
          for (int i = 0; i < words.size(); i++) {
              words.set(i,porter.stem(words.get(i)));


        }

        return words;

    }


//    парсинг статьи и разбивание ее на предложения
    public List<List<String>>  pars(String url){
        String text;
        List<String> words;

        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = doc.body().getElementsByTag("p").text();
        words = Arrays.asList(text.split("\\."));
        return parsWords(words);
    }

//    разбивание на слова и удаление лишних символов
    private List<List<String>>  parsWords(List<String> text){
        List<List<String>> words = new ArrayList<List<String>>();
        for (int i = 0; i <text.size() ; i++) {

            Porter porter = new Porter();
            String str = text.get(i).replaceAll("[\\p{P}\\p{S}]", "");
            str = str.replaceAll("[0-9]","");

            List<String> word = Arrays.asList(str.split(" "));
            for (int j = 0; j < word.size(); j++) {
                word.set(j, porter.stem(word.get(j)));
            }
            words.add(word);
        }
        return words;
    }


}
