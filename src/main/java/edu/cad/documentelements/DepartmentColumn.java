package edu.cad.documentelements;

import edu.cad.entities.CurriculumSubject;
import edu.cad.entities.Subject;
import edu.cad.entities.SubjectDictionary;
import org.apache.poi.ss.usermodel.Row;

public class DepartmentColumn extends AbstractColumn {
    
    public DepartmentColumn(Row row) {
        super(row, "#department");
    }

    @Override
    public void fill(Row row, CurriculumSubject record) {
        SubjectDictionary subject = record.getSubject().getSubject();
        row.getCell(columnNumber).setCellValue(subject.getDepartment().getDenotation());
    }
    
}