package main.java.entities;

import javax.persistence.*;

/**
 * Created by Valdis003
 * on 13.05.2017
 * for VocMasterDist
 */
@Entity
@Table(name = "card_table")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne
    private Word word;
    @OneToOne
    private Meaning meaning;
    @OneToOne
    private Context context;
    private String source;
    private String translation;

    public Card() {
        meaning = new Meaning();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public Meaning getMeaning() {
        return meaning;
    }

    public void setMeaning(Meaning meaning) {
        this.meaning = meaning;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }
}
