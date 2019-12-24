package ru.itis.generate;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.datas.AccountData;
import ru.itis.datas.NoteData;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestData {

    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        System.out.println("Количество создаваемых объектов: ");
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        try {
            createAccountData(count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void createNoteData(int m) throws IOException {

        List<NoteData> list=new ArrayList<>();
        int n=15;
        for(int i=0;i<m;i++){
            list.add(new NoteData(getAlphaNumericString(n)));
        }
        mapper.writeValue(new File("testNoteData.txt"),list);
    }

    public static void createAccountData(int m) throws IOException {

        List<AccountData> list=new ArrayList<>();
        String login = "das5387@yandex.ru";
        int n=15;
        for(int i=0;i<m;i++){
            list.add(new AccountData(login,getAlphaNumericString(n)));
        }
        mapper.writeValue(new File("testAccountData.txt"),list);
    }

    private static String getAlphaNumericString(int n) {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"
                +"~!@#$%^&*()_+<,>.?/]}{[";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

}