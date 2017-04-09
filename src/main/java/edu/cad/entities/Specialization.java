package edu.cad.entities;

import javax.persistence.*;

@Entity
@Table(name = "specialization")
public class Specialization {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "denotation")
    private String denotation;

    public Specialization() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Specialization other = (Specialization) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}