package edu.cad.entities;

import com.google.gson.annotations.Expose;
import edu.cad.entities.interfaces.IDatabaseEntity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "form_of_education")
@Getter
@Setter
public class EducationForm implements IDatabaseEntity, Serializable {
    @Expose
    @Id
    @GenericGenerator(
        name = "assigned-identity", 
        strategy = "edu.cad.utils.hibernateutils.AssignedIdentityGenerator"
    )
    @GeneratedValue(generator = "assigned-identity")
    @Column(name = "id", unique = true, nullable = false)
    private int id;
    
    @Expose
    @Column(name = "denotation")
    private String denotation;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "educationForm")
    private Set<AcademicGroup> academicGroups = new HashSet<>(0);

    public EducationForm() {
    }

    public EducationForm(int id, String denotation) {
        this.id = id;
        this.denotation = denotation;
    }

    public void setAcademicGroups(Set<AcademicGroup> academicGroups) {
        this.academicGroups.clear();
        this.academicGroups.addAll(academicGroups);
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if ( !(obj instanceof EducationForm)) {
            return false;
        }
        final EducationForm other = (EducationForm) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return denotation;
    }
    
    
}
