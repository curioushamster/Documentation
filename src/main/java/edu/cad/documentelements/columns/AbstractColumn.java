package edu.cad.documentelements.columns;

import edu.cad.documentelements.AbstractDocumentElement;
import edu.cad.entities.CurriculumSubject;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public abstract class AbstractColumn extends AbstractDocumentElement {
    protected final int columnNumber;
    
    public AbstractColumn(Row row, String token) {
        columnNumber = findInRow(row, token);
    }
    
    public abstract void fill(Row row, CurriculumSubject record);
    
    public void fill(Row row, String value){
        row.getCell(columnNumber).setCellValue(value);
    }
    
    public void fill(Row row, double value){
        row.getCell(columnNumber).setCellValue(value);
        row.getCell(columnNumber).setCellType(CellType.NUMERIC);
    }
    
    public void clear(Row row){
        row.getCell(columnNumber).setCellType(CellType.BLANK);
    }
    
    public int getColumnNumber(){
        return columnNumber;
    }
}