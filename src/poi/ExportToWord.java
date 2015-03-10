package poi;

import poi.Paciente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.BreakClear;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.LineSpacingRule;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

/**
 * @author delamora
 */
public class ExportToWord {
    
    
    public static void exportation(Paciente paciente) throws Exception {
    //public static void main(String[] args) throws Exception {
        try {
            XWPFDocument doc = new XWPFDocument();
            XWPFParagraph p1 = doc.createParagraph();
            
            CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();//Márgenes del documento
            CTPageMar pageMar = sectPr.addNewPgMar();
            pageMar.setLeft(BigInteger.valueOf(1125L));
            pageMar.setTop(BigInteger.valueOf(1150L));
            pageMar.setRight(BigInteger.valueOf(1125L));
            pageMar.setBottom(BigInteger.valueOf(1150L));

            XWPFRun r = p1.createRun();
            
            int format = XWPFDocument.PICTURE_TYPE_BMP;
            String imgEncabezado = "src/images/Encabezado.bmp";
            
            r.addPicture(new FileInputStream(imgEncabezado), format, imgEncabezado, Units.toEMU(502), Units.toEMU(120)); 
                        
            r.setFontFamily("Andalus");
            r.setFontSize(12);
            r.setBold(false);
            r.setText("Nombre: " + paciente.getNombre() + "\t");
            String sexo = paciente.getSexo() ? "Masculino" : "Femenino";
            r.setText("Sexo: " + sexo);
            r.addCarriageReturn();
            r.setText("Edad: " + paciente.getEdad() + "\t");
            r.setText("Actividad física: " + paciente.getActividadFisica());
            r.setText("Nivel: ");//preguntar a brenda
            r.addCarriageReturn();
            r.setText("Peso: " + paciente.getPeso() + "\t");
            r.setText("Estatura: " + paciente.getEstatura());
            r.addCarriageReturn();
            
            XWPFRun r2 = p1.createRun();
            
            r2.setFontFamily("Arial Rounded MT Bold");
            r2.setFontSize(13);
            r2.setBold(true);
            r2.setText("Resultado de peso con estatura (IMC)");
            r2.addCarriageReturn();
            
            format = XWPFDocument.PICTURE_TYPE_PNG;
            
            double IMC = Double.valueOf(paciente.getImc());
            String imgIMC = null;
            
            if (IMC < 18.5){
                imgIMC = "src/images/IMC/IMC_infrapeso.png";
            } else if (IMC < 25){
                imgIMC = "src/images/IMC/IMC_normal.png";
            } else if (IMC < 30){
                imgIMC = "src/images/IMC/IMC_sobrepeso.png";
            } else if (IMC < 35){
                imgIMC = "src/images/IMC/IMC_obesidad.png";
            } else if (IMC < 40){
                imgIMC = "src/images/IMC/IMC_obesidad2.png";
            } else {
                imgIMC = "src/images/IMC/IMC_obesidad3.png";
            }
            
            r2.addPicture(new FileInputStream(imgIMC), format, imgIMC, Units.toEMU(240), Units.toEMU(114));
            r2.addCarriageReturn();
            
            XWPFRun r3 = p1.createRun();
            
            r3.setFontFamily("Arial Rounded MT Bold");
            r3.setFontSize(13);
            r3.setBold(true);
            r3.setText("Complexión");
            r3.addCarriageReturn();
            
            format = XWPFDocument.PICTURE_TYPE_PNG;
            sexo = sexo.equals("Masculino") ? "Hombre" : "Mujer";
            String imgComplexion = "src/images/Complexion/Complexion" + sexo + paciente.getComplexion() + ".png";
            
            r3.addPicture(new FileInputStream(imgComplexion), format, imgComplexion, Units.toEMU(56), Units.toEMU(122));
            r3.addCarriageReturn();
            
            XWPFRun r4 = p1.createRun();
            
            r4.setFontFamily("Arial Rounded MT Bold");
            r4.setFontSize(13);
            r4.setBold(true);
            r4.setText("ICC");
            r4.addCarriageReturn();
            
            format = XWPFDocument.PICTURE_TYPE_PNG;
            String imgICC = "src/images/Ginecoide.png";
            
            r4.addPicture(new FileInputStream(imgICC), format, imgICC, Units.toEMU(50), Units.toEMU(120));
            r4.addCarriageReturn();
            
            XWPFTable table = doc.createTable(7, 2);
        
            XWPFTableCell cellRow1 = table.getRow(0).getCell(0);
            XWPFTableCell cellRow2 = table.getRow(1).getCell(0);

            cellRow1.getCTTc().addNewTcPr();
            cellRow1.getCTTc().getTcPr().addNewGridSpan();
            cellRow1.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));

            cellRow2.getCTTc().addNewTcPr();
            cellRow2.getCTTc().getTcPr().addNewGridSpan();
            cellRow2.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(2L));
            
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
            
            //r.addBreak(BreakType.TEXT_WRAPPING);
            //r.addCarriageReturn();
            //r.addBreak();
        
            XWPFParagraph p2 = doc.createParagraph();
            p2.createRun();
            
            XWPFTable table2 = doc.createTable(5, 1);
            
            table2.getRow(0).getCell(0).setText("Recomendado");
            table2.getRow(1).getCell(0).setText("% Grasa: " + paciente.getPorcentajeGrasaRCD());
            table2.getRow(2).getCell(0).setText("% Músculo: " + paciente.getPorcentajeMusculoRCD());
            table2.getRow(3).getCell(0).setText("% Óseo: " + paciente.getPorcentajeOseoRCD());
            table2.getRow(4).getCell(0).setText("% Residual: " + paciente.getPorcentajeResidualRCD());
            
            XWPFParagraph p3 = doc.createParagraph();
            p3.createRun();
            
            XWPFTable table3 = doc.createTable(5, 3);
            
            XWPFTableCell cellRow = table3.getRow(0).getCell(0);
            
            cellRow.getCTTc().addNewTcPr();
            cellRow.getCTTc().getTcPr().addNewGridSpan();
            cellRow.getCTTc().getTcPr().getGridSpan().setVal(BigInteger.valueOf(3L));
            
            table3.getRow(0).getCell(0).setText("Complexión\t");
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
                        
            FileOutputStream out = new FileOutputStream(paciente.getNombre() + ".docx");
            doc.write(out);
            out.close();
        } catch (Exception ex) {
            Logger.getLogger(ExportToWord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        
}
