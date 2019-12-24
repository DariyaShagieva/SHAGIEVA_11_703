package ru.itis.datas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NoteData {
    private String text;

    public void changeNote(String string){
        this.text = string;
    }
}
