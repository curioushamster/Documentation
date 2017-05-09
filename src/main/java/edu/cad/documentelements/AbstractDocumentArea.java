package edu.cad.documentelements;

import edu.cad.entities.Curriculum;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class AbstractDocumentArea extends AbstractDocumentElement {
    int rowNumber;
    
    public AbstractDocumentArea(Sheet sheet, String token, int startRow) {
        do{
            rowNumber = findInRow(sheet.getRow(startRow++), token);
        } while(rowNumber < 0);
    }
    
    public abstract void fill(Curriculum curriculum);
}