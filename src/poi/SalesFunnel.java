package poi;

/**
 *
 * @author delamora
 */
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import javax.swing.ImageIcon;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;
import java.awt.Color;
import java.util.Locale;
import org.jfree.chart.annotations.XYBoxAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import java.text.NumberFormat;
import java.awt.Font;
import org.jfree.ui.TextAnchor;
import org.jfree.chart.plot.PlotOrientation;

public class SalesFunnel
    extends ApplicationFrame {
  private static JFreeChart jcSalesFunnelChart = null;

  public SalesFunnel(String s) {
    super(s);
    jcSalesFunnelChart = createSalesFunnelChart();
    JPanel jpanel = new ChartPanel(jcSalesFunnelChart);
    jpanel.setPreferredSize(new Dimension(620, 615));
    setContentPane(jpanel);
  }
  
  /**
   * Creates a sales funnel
   * @return JFreeChart
   */
  private static JFreeChart createSalesFunnelChart() {
    XYSeries xyseries1 = new XYSeries("Series");
    xyseries1.add(1D, 0.5D);
    xyseries1.add(1D, 3.0D);
    xyseries1.add(1D, 6.0D);
    xyseries1.add(1D, 9.0D);
    XYSeriesCollection xyseriescollection = new XYSeriesCollection();
    xyseriescollection.addSeries(xyseries1);
    JFreeChart jfChart = ChartFactory.createXYLineChart(null, "x", "y", xyseriescollection, PlotOrientation.VERTICAL, false, false, false);
    XYPlot xyplot = (XYPlot) jfChart.getPlot();
    XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer();
    xylineandshaperenderer.setSeriesLinesVisible(0, false);
    xylineandshaperenderer.setSeriesShapesVisible(0, true);
    xylineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Float( -5f, -5f, 10f, 10f));
    xylineandshaperenderer.setSeriesPaint(0, Color.blue);
    xyplot.setRenderer(xylineandshaperenderer);
    ImageIcon funnel = new ImageIcon("C:\\Workspaces\\Kinansport\\src\\images\\somatograma.jpg");
    xyplot.setBackgroundImage(funnel.getImage());
    NumberAxis numberAxis = (NumberAxis) xyplot.getRangeAxis();
    numberAxis.setVisible(false);
    numberAxis = (NumberAxis) xyplot.getDomainAxis();
    numberAxis.setLowerBound(0D);
    numberAxis.setUpperBound(2D);
    numberAxis.setVisible(false);
    xyplot.setRangeGridlinesVisible(false);
    xyplot.setDomainGridlinesVisible(false);
    return jfChart;
  }

  /**
   * Changes the values for the Sales Funnel States. The values have to be
   * passed in a Double Array with exactly 4 entries.
   * @param values Double[]
   */
  public static void setValuesForSalesFunnel(Double[] values) {
    NumberFormat numberFormatter = NumberFormat.getNumberInstance(Locale.getDefault());
    String s30 = "30% = " + numberFormatter.format(values[0]);
    String s60 = "60% = " + numberFormatter.format(values[1]);
    String s90 = "90% = " + numberFormatter.format(values[2]);
    String sRest = "Rest = " + numberFormatter.format(values[3]);

    XYPlot xyplot = (XYPlot) jcSalesFunnelChart.getPlot();
    xyplot.clearAnnotations();

    XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();

    XYBoxAnnotation xyboxannotation = new XYBoxAnnotation(0.98D, 0.3D, 1.02D, 0.7D, null, null, null);
    xyboxannotation.setToolTipText(s90);

    xylineandshaperenderer.addAnnotation(xyboxannotation);
    xyboxannotation = new XYBoxAnnotation(0.98D, 2.8D, 1.02D, 3.2D, null, null, null);
    xyboxannotation.setToolTipText(s60);
    xylineandshaperenderer.addAnnotation(xyboxannotation);
    xyboxannotation = new XYBoxAnnotation(0.98D, 5.8D, 1.02D, 6.2D, null, null, null);
    xyboxannotation.setToolTipText(s30);
    xylineandshaperenderer.addAnnotation(xyboxannotation);
    xyboxannotation = new XYBoxAnnotation(0.98D, 8.8D, 1.02D, 9.2D, null, null, null);
    xyboxannotation.setToolTipText(sRest);
    xylineandshaperenderer.addAnnotation(xyboxannotation);

    xyplot.addAnnotation(createXYTextAnnotation(s90, 1.00D, 0.2D, Color.RED));
    xyplot.addAnnotation(createXYTextAnnotation(s60, 1.00D, 2.7D, Color.RED));
    xyplot.addAnnotation(createXYTextAnnotation(s30, 1.00D, 5.7D, Color.RED));
    xyplot.addAnnotation(createXYTextAnnotation(sRest, 1.00D, 8.7D, Color.RED));
  }

  /**
   * Writes a text a the given coordinate in the specified colour. It uses the predefined Verdana font.
   * @param sText The text to be drawn.
   * @param x The x-coordinate.
   * @param y The y-coordinate.
   * @param color The color to use.
   * @return A XYTextAnnotation object with the given attributes.
   */
  public static XYTextAnnotation createXYTextAnnotation(String sText, double x, double y, Color color) {
    XYTextAnnotation xytextannotation = new XYTextAnnotation(sText, x, y);
    Font font = new Font("Verdana", Font.BOLD, 11);
    xytextannotation.setFont(font);
    xytextannotation.setTextAnchor(TextAnchor.CENTER);
    xytextannotation.setPaint(color);
    return xytextannotation;
  }

  public static void main(String args[]) {
    SalesFunnel salesFunnel = new SalesFunnel("Sales Funnel");
    Double[] daSalesFunnel = new Double[]{new Double(1D),new Double(2D),new Double(3D),new Double(4D)};
    salesFunnel.pack();
    RefineryUtilities.centerFrameOnScreen(salesFunnel);
    salesFunnel.setVisible(true);
    setValuesForSalesFunnel(daSalesFunnel);
  }
}
