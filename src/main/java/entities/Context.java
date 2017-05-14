package main.java.entities;

import javax.persistence.*;

/**
 * Created by Valdis003
 * on 13.05.2017
 * for VocMasterDist
 */
@Entity
@Table(name = "context_table")
public class Context {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
