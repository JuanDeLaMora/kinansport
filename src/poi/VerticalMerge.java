package poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;

/**
 *
 * @author delamora
 */
public class VerticalMerge {
    public static void main(String[] args) {

        int rows = 7;
        int cols = 2;

        XWPFDocument document = new XWPFDocument();
        XWPFTable table = document.createTable(rows, cols);
        
        XWPFTableCell cellRow1 = table.getRow(0).getCell(0);
        XWPFTableCell cellRow2 = table.getRow(1).getCell(0);

        cellRow1.getCTTc().addNewTcPr();
        cellRow1.getCTTc().getTcPr().addNewGridSpan();
        cellRow1.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
        
        cellRow2.getCTTc().addNewTcPr();
        cellRow2.getCTTc().getTcPr().addNewGridSpan();
        cellRow2.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
        
        
        
        
        try {
            FileOutputStream out = new FileOutputStream("vertical merge.docx");
            document.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void fillTable(XWPFTable table) {
        for (int rowIndex = 0; rowIndex < table.getNumberOfRows(); rowIndex++) {
            XWPFTableRow row = table.getRow(rowIndex);

            for (int colIndex = 0; colIndex < row.getTableCells().size(); colIndex++) {
                XWPFTableCell cell = row.getCell(colIndex);
                cell.setText(" Data:\t\t");
            }
        }
    }

    private static void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {

        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {

            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);

            if ( rowIndex == fromRow ) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }
}
