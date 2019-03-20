

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


public class Main {


    //language=SQL
    private static final String SQL_INSERT =
            "insert into data_set(word, coefficient, theme) values (?, ?, ?)";

    public static void main(String[] args) {

        Pars pars = new Pars();
        //спорт
        String url1 = "https://ru.wikipedia.org/wiki/%D0%A1%D0%BF%D0%BE%D1%80%D1%82";
        List<String> words1 = pars.parsText(url1);
//        искусство
       String url2 = "https://ru.wikipedia.org/wiki/%D0%98%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%BE";
       List<String> words2 = pars.parsText(url2);
//        пчеловодство
      String url3 = "https://ru.wikipedia.org/wiki/%D0%9F%D1%87%D0%B5%D0%BB%D0%BE%D0%B2%D0%BE%D0%B4%D1%81%D1%82%D0%B2%D0%BE";
       List<String> words3 = pars.parsText(url3);
        //программирование
        String url4 = "https://ru.wikipedia.org/wiki/%D0%9F%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5";
        List<String> words4 = pars.parsText(url4);
        //зоология
        String url5 = "https://ru.wikipedia.org/wiki/%D0%97%D0%BE%D0%BE%D0%BB%D0%BE%D0%B3%D0%B8%D1%8F";
        List<String> words5 = pars.parsText(url5);
        //путешествие
        String url6 = "https://ru.wikipedia.org/wiki/%D0%A2%D1%83%D1%80%D0%B8%D0%B7%D0%BC";
        List<String> words6 = pars.parsText(url6);
        //история
        String url7 = "https://ru.wikipedia.org/wiki/%D0%98%D1%81%D1%82%D0%BE%D1%80%D0%B8%D1%8F";
        List<String> words7 = pars.parsText(url7);
        //литература
        String url8 = "https://ru.wikipedia.org/wiki/%D0%9B%D0%B8%D1%82%D0%B5%D1%80%D0%B0%D1%82%D1%83%D1%80%D0%B0";
        List<String> words8 = pars.parsText(url8);
        //растения
        String url9 = "https://ru.wikipedia.org/wiki/%D0%A0%D0%B0%D1%81%D1%82%D0%B5%D0%BD%D0%B8%D1%8F";
        List<String> words9 = pars.parsText(url9);
        //аниме
        String url10 = "https://ru.wikipedia.org/wiki/%D0%90%D0%BD%D0%B8%D0%BC%D0%B5";
        List<String> words10 = pars.parsText(url10);
        //лингвистика
        String url11 = "https://ru.wikipedia.org/wiki/%D0%9B%D0%B8%D0%BD%D0%B3%D0%B2%D0%B8%D1%81%D1%82%D0%B8%D0%BA%D0%B0";
        List<String> words11 = pars.parsText(url11);
        //алкоголь
        String url12 = "https://ru.wikipedia.org/wiki/%D0%90%D0%BB%D0%BA%D0%BE%D0%B3%D0%BE%D0%BB%D1%8C%D0%BD%D1%8B%D0%B5_%D0%BD%D0%B0%D0%BF%D0%B8%D1%82%D0%BA%D0%B8";
        List<String> words12 = pars.parsText(url12);

        String[] themes = {"спорт","искусство","пчеловодство","программирование","зоология","туризм","история","литература","растения","аниме","лингвистика","алкоголь"};




        List<List<String>> documents = Arrays.asList(words1,words2,words3,words4,words5,words6,words7,words8,words9,words10,words11,words12);



        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();

        dataSource.setUrl("jdbc:postgresql://147.78.64.103:5432/spinach_python");
        dataSource.setUsername("spinach");
        dataSource.setPassword("spinachpassword");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int i = 0;
        TFIDFCalculator calculator = new TFIDFCalculator();
        HashSet<String> hashSet = new HashSet<String>();
        for (List<String> docs: documents) {

            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            for (String word: docs) {
                if (!hashSet.contains(word)) {
                    double tfidf = calculator.tfIdf(docs, documents, word);
                    System.out.println("TF-IDF " + word + " = " + tfidf + " " + calculator.getResult());
                    if (tfidf > 0) {
                        jdbcTemplate.update(SQL_INSERT, word, tfidf, themes[i]);
                    }
                    hashSet.add(word);
                }
            }
            hashSet.clear();
            i++;

        }







    }
}
