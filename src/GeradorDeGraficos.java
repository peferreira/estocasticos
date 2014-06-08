import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

public class GeradorDeGraficos {
	HistogramDataset dataset;
	static int num;
	void criaHistograma(double vetor[]) {
		dataset = new HistogramDataset();
		dataset.setType(HistogramType.RELATIVE_FREQUENCY);
		dataset.addSeries("Histogram", vetor, 10);

		String plotTitle = "Histogram";
		String xaxis = "number";
		String yaxis = "value";
		PlotOrientation orientation = PlotOrientation.VERTICAL;
		boolean show = false;
		boolean toolTips = false;
		boolean urls = false;
		JFreeChart chart = ChartFactory.createHistogram(plotTitle, xaxis,
				yaxis, dataset, orientation, show, toolTips, urls);
		int width = 500;
		int height = 300;
		try {
			ChartUtilities.saveChartAsPNG(new File("histogramAlbumCopa"+num+".PNG"), chart,
					width, height);
			num++;
		} catch (IOException e) {
		}
	}

}
