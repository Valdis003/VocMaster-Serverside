package main.java.entities;

import javax.persistence.*;

/**
 * Created by Valdis003
 * on 13.05.2017
 * for VocMasterDist
 */
@Entity
@Table(name = "word_table")
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String word;
    private String definition;
    private String audio_link;
    private String image_link;
    private String transcription;
    @OneToOne
    private Language language;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getAudio_link() {
        return audio_link;
    }

    public void setAudio_link(String audio_link) {
        this.audio_link = audio_link;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
