package wordPlay.driver;
import wordPlay.util.FileProcessor;
import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;
import java.io.File;
/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
		try
		{
			
				WordRotator wordRotator = new WordRotator(args[0],args[1]);
				wordRotator.wordRotateWrite();
				MetricsCalculator metricsCalculator = new MetricsCalculator(args[0],args[2]);
				metricsCalculator.wordMetricStdOutput();


			//metricsCalculator.wordMetricWrite();
		}
		catch (Exception ex)
		{
			System.out.println(ex.getMessage());
		}

	}
}
