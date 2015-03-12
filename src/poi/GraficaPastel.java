package poi;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author delamora
 */
public class GraficaPastel {

    public GraficaPastel(String nombre, String grasa, String muscular, String oseo, String residual) throws IOException{
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue(grasa + "% Grasa", Double.valueOf(grasa));
        data.setValue(muscular + "% Muscular", Double.valueOf(muscular));
        data.setValue(oseo + "% Óseo", Double.valueOf(oseo));
        data.setValue(residual + "% Residual", Double.valueOf(residual));
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Composición corporal real", data, true, true, false);
        
        // Mostrar Grafico
        /*ChartFrame frame = new ChartFrame("JFreeChart", chart);
        frame.pack();
        frame.setVisible(true);*/
        
        ChartUtilities.saveChartAsPNG(new File(nombre + "\\" + nombre + "_pastel.png"), chart, 500, 500);
    }
}
