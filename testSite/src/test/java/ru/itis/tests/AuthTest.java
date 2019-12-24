package ru.itis.tests;

import org.testng.annotations.Test;
import ru.itis.datas.AccountData;

public class AuthTest extends BaseTest {

    @Test(dataProvider = "dataAccount-provider")
    public void atestUntitledTestCase(String login, String password) throws Exception {
        String rightPassword = "dasfjfj55fjfj55";
        AccountData accountData = new AccountData(login, password);
        applicationManager.getLoginHelper().login(accountData);
        Boolean isLoggedIn = rightPassword.equals(accountData.getPassword());
        applicationManager.getLoginHelper().isLoggedIn(isLoggedIn);
        if (isLoggedIn) applicationManager.getLoginHelper().logout();
    }


}
