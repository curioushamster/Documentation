package edu.cad.documentelements.k3columns;

import edu.cad.documentelements.columns.AbstractColumn;
import edu.cad.utils.documentutils.CellWithTokenValidator;
import edu.cad.utils.documentutils.ColumnTokenStringSplitter;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;

public class AllK3ColumnsFactory {
    
    private static final String K3_WP =
            ColumnTokenStringSplitter.K3_WP_TOKEN_BEGINNING;
    private static final String K3_ST = 
            ColumnTokenStringSplitter.K3_ST_LOAD_TOKEN_BEGINNING;
    
    public static void createAndAddColumn(Map<Class, List<AbstractColumn>> dest,
            Cell cell) {
        
        if (null != CellWithTokenValidator.getContentIfCellValid(cell, K3_WP)){
            System.out.println("HUI");
            dest.get(AbstractK3Column.class)
                    .add(K3WPColumnsFactory.createColumn(cell));
        }
        else if (null != CellWithTokenValidator.getContentIfCellValid(cell, K3_ST)) {
            dest.get(StudyLoadColumn.class)
                    .add(StudyLoadColumnFactory.createColumnAndSetFormula(cell));
        }
                    
    }
}
