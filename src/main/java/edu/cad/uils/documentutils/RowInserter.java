package edu.cad.uils.documentutils;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

public class RowInserter {
    
    public static void insertRow(Sheet sheet, int position){
        int totalRows = sheet.getLastRowNum();
       
        Row oldRow = sheet.getRow(position - 1);

        List<CellRangeAddress> addresses = getMergedRegions(sheet, oldRow);
        
        sheet.shiftRows(position, totalRows, 1, true, false); 
        Row newRow = sheet.getRow(position);
        copyRow(oldRow, newRow);
        shiftMergedRegions(sheet, addresses, oldRow);
    }
    
    private static void copyRow(Row oldRow, Row newRow){
        newRow.setHeight(oldRow.getHeight());
        
        for(int i = 0; i < oldRow.getLastCellNum(); i++){
            newRow.createCell(i).setCellStyle(oldRow.getCell(i).getCellStyle());
            
           /* if(oldRow.getCell(i).getCellTypeEnum().equals(CellType.FORMULA)){
                newRow.getCell(i).setCellFormula("");
            }*/
        }
    }
    
    private static void shiftMergedRegions(Sheet sheet, List<CellRangeAddress> addresses, Row oldRow){ 
        for (CellRangeAddress cellRangeAddress : addresses) {
            int firstColumn = cellRangeAddress.getFirstColumn();
            int lastColumn = cellRangeAddress.getLastColumn();
            int firstRow = cellRangeAddress.getFirstRow() + 1;
            int lastRow = cellRangeAddress.getLastRow() + 1;

            CellRangeAddress address = new CellRangeAddress(firstRow, lastRow,
                    firstColumn, lastColumn);
                
            sheet.addMergedRegion(address);
        }
    }
    
    private static List<CellRangeAddress> getMergedRegions(Sheet sheet, Row firstRow){
        List<CellRangeAddress> addresses = new ArrayList<>();
        
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            CellRangeAddress cellRangeAddress = sheet.getMergedRegion(i);

            if (cellRangeAddress.getFirstRow() >= firstRow.getRowNum()) {
                addresses.add(cellRangeAddress.copy());
                if(cellRangeAddress.getFirstRow() != firstRow.getRowNum()){
                    sheet.removeMergedRegion(i--);
                }  
            }
        }

        return addresses;
    }
}