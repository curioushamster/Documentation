package edu.cad.entities;

import edu.cad.entities.interfaces.IDatabaseEntity;
import javax.persistence.*;

@Entity
@Table(name = "dict_control")
public class ControlDictionary implements IDatabaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Column(name = "denotation")
    private String denotation;

    public ControlDictionary() {
    }

    public ControlDictionary(int id, String denotation) {
        this.id = id;
        this.denotation = denotation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenotation() {
        return denotation;
    }

    public void setDenotation(String denotation) {
        this.denotation = denotation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final ControlDictionary other = (ControlDictionary) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    } 

    @Override
    public String toString() {
        return "ControlDictionary{denotation=" + denotation + '}';
    }
    
    
}
