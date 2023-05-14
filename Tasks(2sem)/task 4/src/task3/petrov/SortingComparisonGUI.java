package task3.petrov;

import javax.swing.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class SortingComparisonGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel chartPanel;

    public SortingComparisonGUI(XYSeries insertSortComp, XYSeries binaryInsertSortComp, XYSeries insertSortSwap, XYSeries binaryInsertSortSwap, XYSeries insertSortTime, XYSeries binaryInsertSortTime) {

        setTitle("Сравнение сортировок");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);

        chartPanel = createChartPanel(insertSortComp, binaryInsertSortComp, insertSortSwap, binaryInsertSortSwap, insertSortTime, binaryInsertSortTime);
        add(chartPanel);

        setVisible(true);
    }

    private JPanel createChartPanel(XYSeries insertSortComp, XYSeries binaryInsertSortComp, XYSeries insertSortSwap, XYSeries binaryInsertSortSwap, XYSeries insertSortTime, XYSeries binaryInsertSortTime) {
        // create dataset
        XYSeriesCollection dataset = new XYSeriesCollection();

        // add data to dataset
        dataset.addSeries(insertSortSwap);
        dataset.addSeries(binaryInsertSortComp);
        dataset.addSeries(insertSortComp);
        dataset.addSeries(binaryInsertSortSwap);
        dataset.addSeries(insertSortTime);
        dataset.addSeries(binaryInsertSortTime);

        // create chart
        JFreeChart chart = createXYChart(dataset, "Сравнения в процессе сортировки", "Количество элементов", "Количество Сравнений/Замен,Время");

        // create panel to display chart
        ChartPanel panel = new ChartPanel(chart);
        return panel;
    }

    private JFreeChart createXYChart(XYDataset dataset, String chartTitle, String xAxisLabel, String yAxisLabel) {
        // create plot
        XYPlot plot = new XYPlot();
        plot.setDataset(dataset);

        // create renderer
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        plot.setRenderer(renderer);

        // set axis labels
        NumberAxis xAxis = new NumberAxis(xAxisLabel);
        NumberAxis yAxis = new NumberAxis(yAxisLabel);
        plot.setDomainAxis(xAxis);
        plot.setRangeAxis(yAxis);

        // create chart
        JFreeChart chart = new JFreeChart(plot);
        chart.setTitle(chartTitle);

        return chart;
    }

    public static void main(XYSeries insertSortComp, XYSeries binaryInsertSortComp, XYSeries insertSortSwap, XYSeries binaryInsertSortSwap, XYSeries insertSortTime, XYSeries binaryInsertSortTime) {
        new SortingComparisonGUI(insertSortComp, binaryInsertSortComp, insertSortSwap, binaryInsertSortSwap, insertSortTime, binaryInsertSortTime);
    }
}
