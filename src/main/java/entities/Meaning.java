
package main.java.entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Meaning {
    @Id
    @GeneratedValue
    private int id;
    private String translation;
    @ElementCollection
    private Collection<String> synonyms = null;
    @ElementCollection
    private Collection<String> altTranslations = null;

    public Meaning() {
        synonyms = new ArrayList<>();
        altTranslations = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Collection<String> getSynonyms() {
        return synonyms;
    }

    public void setSynonyms(Collection<String> synonyms) {
        this.synonyms = synonyms;
    }

    public Collection<String> getAltTranslations() {
        return altTranslations;
    }

    public void setAltTranslations(Collection<String> altTranslations) {
        this.altTranslations = altTranslations;
    }
}
