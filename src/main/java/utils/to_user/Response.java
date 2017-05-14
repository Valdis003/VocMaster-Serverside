
package main.java.utils.to_user;

import main.java.entities.Meaning;
import main.java.entities.Word;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private Word word;
    private List<Meaning> meanings = null;

    public Response() {
        meanings = new ArrayList<>();
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

}
