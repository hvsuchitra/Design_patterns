package channelpopularity.driver;
import channelpopularity.context.ChannelContext;
import channelpopularity.state.factory.SimpleStateFactory;

import java.util.Arrays;
import channelpopularity.state.StateName;

/**
 * @author John Doe
 *
 */
public class Driver {
	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 2;

	public static void main(String[] args) throws Exception {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 2) || (args[0].equals("${input}")) || (args[1].equals("${output}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
			System.exit(0);
		}
		System.out.println("Hello World! Lets get started with the assignment");
		try
		{	SimpleStateFactory simpleStateFactory = new SimpleStateFactory();
			//ChannelContext.getInstance(simpleStateFactory,args[0]);
			ChannelContext channelContext = new ChannelContext(simpleStateFactory,args[0],Arrays.asList(StateName.values()));
			//System.out.println("in try");
			channelContext.initiate();

		}
		catch (Exception ex)
		{
			//System.out.println("in catch");
			System.out.println("error message"+ ex.getMessage());
			System.exit(0);
		}
	}
}
