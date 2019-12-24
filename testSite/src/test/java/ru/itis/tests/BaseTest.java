package ru.itis.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import ru.itis.datas.AccountData;
import ru.itis.datas.NoteData;
import ru.itis.manager.ApplicationManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;


public class BaseTest {

    protected ApplicationManager applicationManager;

    protected ObjectMapper mapper = new ObjectMapper();
    @BeforeTest
    public void setUp() throws Exception {

        applicationManager = ApplicationManager.getInstance();
    }

    @AfterTest
    public void tearDown() throws Exception {
       applicationManager.stop();
    }
    @DataProvider(name="dataAccount-provider")
    public Object[][] accountDataProviderMethod() throws IOException {
        File file=new File("testAccountData.txt");
        FileReader fileReader=new FileReader(file);
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            line=bufferedReader.readLine() ;
        }
        System.out.println(line);
        List<AccountData> string= Arrays.asList(mapper.readValue(line,AccountData[].class ));

        return new Object[][] { { (string.get(0)).getLogin(),(string.get(0)).getPassword() }, { (string.get(1)).getLogin(),(string.get(1)).getPassword()}};
    }
    @DataProvider(name="dataNode-provider")
    public Object[][] noteDataProviderMethod() throws IOException {
        File file=new File("testNoteData.txt");
        FileReader fileReader=new FileReader(file);
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            line=bufferedReader.readLine() ;
        }
        System.out.println(line);
        List<NoteData> string= Arrays.asList(mapper.readValue(line,NoteData[].class ));
        return new Object[][] { { (string.get(0)).getText() }, { (string.get(1)).getText()},{ (string.get(2)).getText()}};
    }




}
