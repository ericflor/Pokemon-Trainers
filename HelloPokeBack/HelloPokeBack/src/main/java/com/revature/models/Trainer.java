package com.revature.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.MERGE;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tId;
    private String name;
    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = MERGE)
    @JsonManagedReference
    private List<Pokemon> party;

    public Trainer() {
    }

    public Trainer(int tId, String name) {
        this.tId = tId;
        this.name = name;
    }

    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trainer trainer = (Trainer) o;
        return tId == trainer.tId && Objects.equals(name, trainer.name) && Objects.equals(party, trainer.party);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tId, name, party);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "tId=" + tId +
                ", name='" + name + '\'' +
                ", party=" + party +
                '}';
    }
}
