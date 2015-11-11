package poi;
/**
 *
 * @author delamora
 */

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
//import org.jfree.ui.RefineryUtilities;

public class GraficaXY extends ApplicationFrame {
    /**
     * Construye la gráfica del Somatograma.
     *
     */
    public GraficaXY(String nombre, String endomorfismoReal, String mesomorfismoReal, String ectomorfismoReal, 
                        String endomorfismoRCD, String mesomorfismoRCD, String ectomorfismoRCD) throws IOException {

        super("Somatograma");
        XYDataset dataset = createDataset(endomorfismoReal, mesomorfismoReal, ectomorfismoReal, 
                                            endomorfismoRCD, mesomorfismoRCD, ectomorfismoRCD );
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Somatograma",
            "",
            "",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            false,
            false
        );
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Float( -7f, -7f, 12f, 12f));
        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);
        renderer.setSeriesPaint(1, Color.PINK);
        renderer.setSeriesShape(1, new java.awt.geom.Ellipse2D.Float( -9f, -9f, 17f, 17f));
        renderer.setSeriesLinesVisible(2, false);
        renderer.setSeriesShapesVisible(2, false);
        renderer.setSeriesLinesVisible(3, false);
        renderer.setSeriesShapesVisible(3, false);
        ImageIcon somatograma = new ImageIcon(getClass().getResource("/images/somatograma.jpg"));
        plot.setBackgroundImage(somatograma.getImage());
        plot.setRenderer(renderer);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(620, 615));
        setContentPane(chartPanel);
        
        ChartUtilities.saveChartAsPNG(new File(nombre + "\\" + nombre + "_somatograma.png"), chart, 620, 615);

    }
    
    /**
     * Crea el set de datos para la gráfica
     * 
     * @return set de datos graficados.
     */
    private XYDataset createDataset(String endomorfismoReal, String mesomorfismoReal, String ectomorfismoReal, 
                                        String endomorfismoRCD, String mesomorfismoRCD, String ectomorfismoRCD) {
        
        double xReal = Double.valueOf(ectomorfismoReal) - Double.valueOf(endomorfismoReal);
        double yReal = (Double.valueOf(mesomorfismoReal)*2) - (Double.valueOf(endomorfismoReal) + Double.valueOf(ectomorfismoReal));
        
        double xRCD = Double.valueOf(ectomorfismoRCD) - Double.valueOf(endomorfismoRCD);
        double yRCD = (Double.valueOf(mesomorfismoRCD)*2) - (Double.valueOf(endomorfismoRCD) + Double.valueOf(ectomorfismoRCD));
        
        XYSeries series1 = new XYSeries("Real");
        series1.add(xReal, yReal);
        XYSeries series2 = new XYSeries("Recomendado");
        series2.add(xRCD, yRCD);
        XYSeries series3 = new XYSeries("");//Usados para hacer la gráfica grande
        series3.add(8.0, 17.0);//Usados para cuadrar la gráfica
        series3.add(-8.0, -10.0);//Usados para cuadrar la gráfica
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        
        return dataset;
    }
    
    /*public static void main(final String[] args) {

        final GraficaXY demo = new GraficaXY(
            "XYLineAndShapeRenderer Demo"
        );
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }*/
}
