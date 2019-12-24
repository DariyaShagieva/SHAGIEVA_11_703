package ru.itis.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import ru.itis.datas.AccountData;
import ru.itis.datas.NoteData;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class BaseAuth extends BaseTest {
    @BeforeTest
    @Override
    public void setUp() throws Exception {
        super.setUp();
        AccountData accountData = new AccountData("das5387@yandex.ru", "dasfjfj55fjfj55");
       applicationManager.getLoginHelper().login(accountData);
    }




}
