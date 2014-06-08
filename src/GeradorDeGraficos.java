import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYDataImageAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.DomainOrder;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GeradorDeGraficos {
	HistogramDataset dataset;
	CategoryDataset dataset2;
	static int num;

	private CategoryDataset createDataset(double vetor[]) {

        final DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
		dataset3.addValue(vetor[1],"album copa do mundo","0");

        for(int i = 1; i < vetor.length-1; i++){
			if((i-1)%50 == 0){
			dataset3.addValue(vetor[i],"album copa do mundo",""+(i-1)+"");
			}

		}
		dataset3.addValue(vetor[648],"album copa do mundo","648");

		return dataset3;

	}

	void criaPlotDePontos(double vetor[]) {
		dataset2 = createDataset(vetor);
		
		final JFreeChart chart = ChartFactory.createLineChart(
				"Vetor de tempo esperado", // chart title
				"X: número de figurinhas coladas", // x axis label
				"Y: tempo esperado", // y axis label 
				dataset2, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
				);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		chart.setBackgroundPaint(Color.white);
		int width = 700;
		int height = 300;
		try {
			ChartUtilities.saveChartAsPNG(new File("tEsperadoAlbumCopa" + num
					+ ".PNG"), chart, width, height);
			num++;
		} catch (IOException e) {
		}
	}

	void criaHistograma(double vetor[]) {
		dataset = new HistogramDataset();
		dataset.setType(HistogramType.RELATIVE_FREQUENCY);
		dataset.addSeries("Histogram", vetor, 10);

		String plotTitle = "Histograma";
		String xaxis = "numbero de pacotinhos";
		String yaxis = "porcentagem";
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		boolean show = false;
		boolean toolTips = false;
		boolean urls = false;
		JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, dataset, orientation, show, toolTips, urls);
		chart.setBackgroundPaint(Color.white);
		int width = 500;
		int height = 300;
		try {
			ChartUtilities.saveChartAsPNG(new File("histogramaAlbumCopa" + num
					+ ".PNG"), chart, width, height);
			num++;
		} catch (IOException e) {
		}
	}

}
