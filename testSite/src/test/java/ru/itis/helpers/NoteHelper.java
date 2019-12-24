package ru.itis.helpers;

import org.openqa.selenium.By;
import ru.itis.manager.ApplicationManager;
import ru.itis.datas.NoteData;

import java.util.concurrent.TimeUnit;

public class NoteHelper extends BaseHelper {


    public NoteHelper(ApplicationManager applicationManager) {
        super(applicationManager);
    }

    public void createNew(NoteData noteData) throws InterruptedException {
        driver.findElement(By.className("GJ1NOG4CCR")).click();
        driver.findElement(By.id("gwt-debug-NoteTitleView-textBox")).click();
        driver.findElement(By.id("gwt-debug-NoteTitleView-textBox")).clear();
        driver.findElement(By.id("gwt-debug-NoteTitleView-textBox")).sendKeys(noteData.getText());
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='+'])[1]/following::div[2]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[62]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[62]")).sendKeys("new");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.id("gwt-debug-NoteAttributes-doneButton")).click();
    }

    public void changeNote(NoteData noteData) throws InterruptedException {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Показывать текст'])[1]/following::div[9]")).click();
        driver.findElement(By.id("gwt-debug-NoteTitleView-textBox")).click();
        driver.findElement(By.id("gwt-debug-NoteTitleView-textBox")).clear();
        driver.findElement(By.id("gwt-debug-NoteTitleView-textBox")).sendKeys(noteData.getText());
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Показывать текст'])[1]/following::div[9]")).click();
        TimeUnit.SECONDS.sleep(2);
    }

    public void deleteNote() throws InterruptedException {
        driver.findElement(By.xpath("//div[@id='gwt-debug-notesListView']/div[2]/div/div/div[2]/div/div[2]/div/div/div[5]/div/div[4]/div")).click();
        TimeUnit.SECONDS.sleep(2);
        driver.findElement(By.id("gwt-debug-ConfirmationDialog-confirm")).click();
        TimeUnit.SECONDS.sleep(1);
    }

}
