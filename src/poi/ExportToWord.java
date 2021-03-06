package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

/**
 * @author delamora
 */
public class ExportToWord {
    
    
    public static void exportation(Paciente paciente) throws Exception {
    //public static void main(String[] args) throws Exception {
        try {
            
            File theDir = new File(paciente.getNombre());

            // if the directory does not exist, create it
            if (!theDir.exists()) {
                  theDir.mkdir();
            }
            
            XWPFDocument doc = new XWPFDocument();
            XWPFParagraph p1 = doc.createParagraph();
            
            CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();//Márgenes del documento
            CTPageMar pageMar = sectPr.addNewPgMar();
            pageMar.setLeft(BigInteger.valueOf(1125L));
            pageMar.setTop(BigInteger.valueOf(700L));
            pageMar.setRight(BigInteger.valueOf(1125L));
            pageMar.setBottom(BigInteger.valueOf(600L));

            XWPFRun r = p1.createRun();
            
            int format = XWPFDocument.PICTURE_TYPE_JPEG;
            
            InputStream encabezado = InputStream.class.getResourceAsStream(("/images/Encabezado.jpg"));
            
            r.addPicture(encabezado, format, "Encabezado.jpg", Units.toEMU(502), Units.toEMU(110)); 
                        
            r.setFontFamily("Andalus");
            r.setFontSize(12);
            r.setBold(false);
            r.setText("Nombre: " + paciente.getNombre() + "   ");
            String sexo = paciente.getSexo() ? "Masculino  " : "Femenino  ";
            r.setText("Sexo: " + sexo);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm");
            Date date = new Date();
            r.setText(" Fecha: " + dateFormat.format(date));
            r.addCarriageReturn();
            r.setText("Edad: " + paciente.getEdad() + "   ");
            r.setText("Actividad física: " + paciente.getActividadFisica() + "   ");
            r.setText("Nivel:");//preguntar a brenda
            r.addCarriageReturn();
            r.setText("Peso: " + paciente.getPeso() + "   ");
            r.setText("Estatura: " + paciente.getEstatura());
            r.addCarriageReturn();
            
            XWPFRun r2 = p1.createRun();
            
            r2.setFontFamily("Arial Rounded MT Bold");
            r2.setFontSize(13);
            r2.setBold(true);
            r2.setText("Resultado de peso con estatura (IMC)            Complexión                       ICC");
            r2.addCarriageReturn();
            
            format = XWPFDocument.PICTURE_TYPE_PNG;
            
            double IMC = Double.valueOf(paciente.getImc());
            String imgIMC;
            
            if (IMC < 18.5){
                imgIMC = "/images/IMC/IMC_infrapeso.png";
            } else if (IMC < 25){
                imgIMC = "/images/IMC/IMC_normal.png";
            } else if (IMC < 30){
                imgIMC = "/images/IMC/IMC_sobrepeso.png";
            } else if (IMC < 35){
                imgIMC = "/images/IMC/IMC_obesidad.png";
            } else if (IMC < 40){
                imgIMC = "/images/IMC/IMC_obesidad2.png";
            } else {
                imgIMC = "/images/IMC/IMC_obesidad3.png";
            }
            
            InputStream imagenIMC = InputStream.class.getResourceAsStream((imgIMC));
            
            r2.addPicture(imagenIMC, format, "IMC", Units.toEMU(240), Units.toEMU(110));
            r2.addTab();
            
            sexo = sexo.equals("Masculino") ? "Hombre" : "Mujer";
            String imgComplexion = "/images/Complexion/Complexion" + sexo + paciente.getComplexion() + ".png";
            InputStream imagenComplexion = InputStream.class.getResourceAsStream((imgComplexion));
            r2.addPicture(imagenComplexion, format, "Complexion", Units.toEMU(140), Units.toEMU(110));
            r2.addTab();
            
            format = XWPFDocument.PICTURE_TYPE_JPEG;
            
            String imgICC = "/images/" + paciente.getIcc() + ".jpg";
            InputStream imagenICC = InputStream.class.getResourceAsStream((imgICC));
            r2.addPicture(imagenICC, format, "ICC", Units.toEMU(100), Units.toEMU(110));
            
            r2.addCarriageReturn();
            
            GraficaPastel.CreaGrafica(paciente.getNombre(), paciente.getPorcentajeGrasaReal(), 
                              paciente.getPorcentajeMusculoReal(), paciente.getPorcentajeOseoReal(), 
                              paciente.getPorcentajeResidualReal() );
            
            format = XWPFDocument.PICTURE_TYPE_PNG;
            r2.addPicture(new FileInputStream(paciente.getNombre()+ "\\" + paciente.getNombre() + "_pastel.png"), format, "Grasa", Units.toEMU(180), Units.toEMU(180));
            
            XWPFTable table = doc.createTable(7, 3);
            
            XWPFTableCell cellRow1 = table.getRow(0).getCell(0);
            XWPFTableCell cellRow2 = table.getRow(1).getCell(0);

            cellRow1.getCTTc().addNewTcPr();
            cellRow1.getCTTc().getTcPr().addNewGridSpan();
            cellRow1.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
            
            cellRow1 = table.getRow(0).getCell(2);
            cellRow1.getCTTc().newCursor().removeXml();

            cellRow2.getCTTc().addNewTcPr();
            cellRow2.getCTTc().getTcPr().addNewGridSpan();
            cellRow2.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
            
            cellRow1 = table.getRow(1).getCell(2);
            cellRow1.getCTTc().newCursor().removeXml();
            
            mergeCellsVertically(table, 1, 0, 1);
            
            table.getRow(0).getCell(0).setText("Real");
            table.getRow(1).getCell(0).setText("Kg. Masa Magra: " + paciente.getMasaMagra());
            table.getRow(2).getCell(0).setText("Kg. Grasa: " + paciente.getKgGrasa());
            table.getRow(3).getCell(0).setText("Kg. Músculo: " + paciente.getKgMusculo());
            table.getRow(4).getCell(0).setText("Kg. Óseo: " + paciente.getKgOseo());
            table.getRow(5).getCell(0).setText("Kg. Residual: " + paciente.getKgResidual());
            table.getRow(6).getCell(0).setText("Kg. Peso: " + paciente.getPeso());
            
            table.getRow(2).getCell(1).setText("% Grasa: " + paciente.getPorcentajeGrasaReal());
            table.getRow(3).getCell(1).setText("% Músculo: " + paciente.getPorcentajeMusculoReal());
            table.getRow(4).getCell(1).setText("% Óseo: " + paciente.getPorcentajeOseoReal());
            table.getRow(5).getCell(1).setText("% Residual: " + paciente.getPorcentajeResidualReal());
            table.getRow(6).getCell(1).setText("% 100: ");
            
            table.getRow(0).getCell(1).setText("Recomendado");
            table.getRow(0).getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
            table.getRow(2).getCell(2).setText("% Grasa: " + paciente.getPorcentajeGrasaRCD());
            table.getRow(3).getCell(2).setText("% Músculo: " + paciente.getPorcentajeMusculoRCD());
            table.getRow(4).getCell(2).setText("% Óseo: " + paciente.getPorcentajeOseoRCD());
            table.getRow(5).getCell(2).setText("% Residual: " + paciente.getPorcentajeResidualRCD());
                        
            XWPFParagraph p3 = doc.createParagraph();
            XWPFRun r3 = p3.createRun();
            
            new GraficaXY(paciente.getNombre(), paciente.getEndomorfia(), paciente.getMesomorfia(), 
                            paciente.getEctomorfia(), paciente.getEndomorfiaRCD(), paciente.getMesomorfiaRCD(), 
                            paciente.getEctomorfiaRCD());
            
            r3.addPicture(new FileInputStream(paciente.getNombre()+ "\\" + paciente.getNombre() + "_somatograma.png"), format, "Somatograma", Units.toEMU(180), Units.toEMU(180));
            
            XWPFTable table3 = doc.createTable(5, 3);
            
            XWPFTableCell cellRow = table3.getRow(0).getCell(0);
            
            cellRow.getCTTc().addNewTcPr();
            cellRow.getCTTc().getTcPr().addNewGridSpan();
            cellRow.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(3L));
            
            cellRow = table3.getRow(0).getCell(2);
            cellRow.getCTTc().newCursor().removeXml();
            cellRow = table3.getRow(0).getCell(1);
            cellRow.getCTTc().newCursor().removeXml();
            
            table3.getRow(0).getCell(0).setText("Somatotipo\t");
            table3.getRow(2).getCell(0).setText("Endomorfia");
            table3.getRow(3).getCell(0).setText("Mesomorfia");
            table3.getRow(4).getCell(0).setText("Ectomorfia");
            
            table3.getRow(1).getCell(1).setText("Real\t");
            table3.getRow(2).getCell(1).setText(paciente.getEndomorfia());
            table3.getRow(3).getCell(1).setText(paciente.getMesomorfia());
            table3.getRow(4).getCell(1).setText(paciente.getEctomorfia());
            
            table3.getRow(1).getCell(2).setText("Recomendado");
            table3.getRow(2).getCell(2).setText(paciente.getEndomorfiaRCD());
            table3.getRow(3).getCell(2).setText(paciente.getMesomorfiaRCD());
            table3.getRow(4).getCell(2).setText(paciente.getEctomorfiaRCD());
            
            table3.setStyleID("Medium Shading 1");
            
            XWPFParagraph p2 = doc.createParagraph();
            p2.createRun();
            
            XWPFTable table4 = doc.createTable(1, 1);
            
            CTTbl commentTable = table4.getCTTbl();
            CTTblPr pr = commentTable.getTblPr();
            CTTblWidth tblW = pr.getTblW();
            tblW.setW(BigInteger.valueOf(5000));
            tblW.setType(STTblWidth.PCT);
            pr.setTblW(tblW);
            commentTable.setTblPr(pr);
            
            table4.getRow(0).getCell(0).setText("Comentarios:");
               
            FileOutputStream out = new FileOutputStream(paciente.getNombre()+ "\\" + paciente.getNombre() + ".docx");
            doc.write(out);
            out.close();
            
            File graficaPastel = new File(paciente.getNombre()+ "\\" + paciente.getNombre() + "_pastel.png");
            graficaPastel.delete();
            File graficaXY = new File(paciente.getNombre()+ "\\" + paciente.getNombre() + "_somatograma.png");
            graficaXY.delete();
                
        } catch (Exception ex) {
            Logger.getLogger(ExportToWord.class.getName()).log(Level.SEVERE, null, ex);
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
