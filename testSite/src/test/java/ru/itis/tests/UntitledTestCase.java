package ru.itis.tests;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.Test;
import ru.itis.datas.NoteData;

import java.util.concurrent.TimeUnit;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UntitledTestCase extends BaseAuth {


    @Test(dataProvider = "dataNode-provider")
    public void btestNote(String text) throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);
        NoteData noteData = new NoteData(text);
        applicationManager.getNoteHelper().createNew(noteData);
        noteData.changeNote("change");
        applicationManager.getNoteHelper().changeNote(noteData);
        applicationManager.getNoteHelper().deleteNote();

    }

    @Test void  ctestLogut() throws Exception {
        applicationManager.getLoginHelper().logout();
    }


}
