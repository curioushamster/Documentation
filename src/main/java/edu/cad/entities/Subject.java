package edu.cad.entities;

import edu.cad.entities.interfaces.IDatabaseEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "academic_subject")
public class Subject implements IDatabaseEntity{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "semester")
    private int semester; 
    
    @Column(name = "semesters_duration")
    private int semestersDuration;
    
    @Column(name = "lections")
    private int lections;
    
    @Column(name = "labs")
    private int labs;
    
    @Column(name = "practices")
    private int practices;
    
    @Column(name = "ECTS")
    private float ects;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    private SubjectDictionary subject;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "subject")
    private Set<Control> controls = new HashSet<>();
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.subject", cascade = CascadeType.ALL)
    private Set<CurriculumSubject> curriculumSubjects = new HashSet<>();

    public Subject() {
    }

    public Subject(int id, int semester, int semestersDuration, int lections, 
                int labs, int practices, float ects, SubjectDictionary subject) {
        this.id = id;
        this.semester = semester;
        this.semestersDuration = semestersDuration;
        this.lections = lections;
        this.labs = labs;
        this.practices = practices;
        this.ects = ects;
        this.subject = subject;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSemestersDuration() {
        return semestersDuration;
    }

    public void setSemestersDuration(int semestersDuration) {
        this.semestersDuration = semestersDuration;
    }

    public int getLections() {
        return lections;
    }

    public void setLections(int lections) {
        this.lections = lections;
    }

    public int getLabs() {
        return labs;
    }

    public void setLabs(int labs) {
        this.labs = labs;
    }

    public int getPractices() {
        return practices;
    }

    public void setPractices(int practices) {
        this.practices = practices;
    }

    public float getEcts() {
        return ects;
    }

    public void setEcts(float ects) {
        this.ects = ects;
    }

    public SubjectDictionary getSubject() {
        return subject;
    }

    public void setSubject(SubjectDictionary subject) {
        this.subject = subject;
    }

    public Set<Control> getControls() {
        return controls;
    }

    public void setControls(Set<Control> controls) {
        this.controls = controls;
    }

    public Set<CurriculumSubject> getCurriculumSubjects() {
        return curriculumSubjects;
    }

    public void setCurriculumSubjects(Set<CurriculumSubject> curriculumSubjects) {
        this.curriculumSubjects = curriculumSubjects;
    }
    
    public Set<Control> getControlsByType(ControlDictionary type){
        Set<Control> result = new HashSet<>();
        
        for(Control control : controls){
            if(control.getType().equals(type)){
                result.add(control);
            }
        }
        
        return result;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.id;
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
        /*if (getClass() != obj.getClass()) {
            return false;
        }*/
        final Subject other = (Subject) obj;
        if (this.id != other.getId()) {
            return false;
        }
        return true;
    }
}
