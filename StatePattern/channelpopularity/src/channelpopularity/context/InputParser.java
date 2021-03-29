package channelpopularity.context;
import java.io.IOException;
import java.io.FileNotFoundException;
import channelpopularity.state.StateName;
import channelpopularity.operation.Operation;
import java.util.regex.Pattern;
import channelpopularity.state.Request;
import channelpopularity.state.VideoMetrics;
import channelpopularity.context.ChannelContext;
import java.util.regex.Matcher;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import channelpopularity.util.FileProcessor;

import static channelpopularity.operation.Operation.ADD_VIDEO;
import static channelpopularity.operation.Operation.AD_REQUEST;
import static channelpopularity.operation.Operation.METRICS;
import static channelpopularity.operation.Operation.REMOVE_VIDEO;

/**
 * InputParser calls validates the each line and does the respective action
 * else throws an exception
 */
public class InputParser {
    private String inputFilePath;
    private FileProcessor fileProcessor;
    private  ChannelContext channelContext;
    public InputParser(String inputFilePath,ChannelContext conObj) throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
        this.inputFilePath = inputFilePath;
        this.channelContext=conObj;
        this.fileProcessor = new FileProcessor(this.inputFilePath);
    }
    public void next() throws IOException{
        String input;
        String value;
        String vname;
        String operation;

        Pattern pattern=Pattern.compile("\\[VIEWS=([+-]?[0-9]+),LIKES=([+-]?[0-9]+),DISLIKES=([+-]?[0-9]+)\\]");
        try
        {

        while((input=fileProcessor.poll())!=null)
        {    //System.out.println(input);
            if(input.isEmpty())
            {
                throw new Exception("Empty Line");
            }
            String[] arrOfStr = input.split("::");
            if(arrOfStr.length!=2)
            {
                throw new Exception("input line is not in format");
            }
            operation=arrOfStr[0];
            //System.out.println(operation);
            value=arrOfStr[1];
            //System.out.println(value);
            if(ADD_VIDEO.name().equals(operation))
            {
                System.out.println(value + "is added");
               // channelContext.addVideo(value);
            }
            else if(REMOVE_VIDEO.name().equals(operation))
            {
                System.out.println(value+" is removed");
                //channelContext.removeVideo(value);
            }
            else if(operation.contains(AD_REQUEST.name()))
            {
                System.out.println(" in AD_Request");
            }
            else if(operation.contains(METRICS.name()))
            {
            String[] metrics= operation.split("__");
              vname=metrics[1];
               // System.out.println("Video to be metrics is ");
                Matcher val = pattern.matcher(value);
                if (val.find()) {
                    String views = (val.group(1));
                    String likes = (val.group(2));
                    String dislikes = (val.group(3));
                    Request request = new Request(vname);
                    request.setViews(Integer.parseInt(views));
                    request.setLikes(Integer.parseInt(likes));
                    request.setDislikes(Integer.parseInt(dislikes));
                    request.setVideoName(vname);
                    //System.out.println("Video views "+request.getViews());
                    //VideoMetrics videometrics = new VideoMetrics(request.getViews(), request.getLikes(), request.getDislikes());
                    //System.out.println("video name" +request.getVideoName());
                   // System.out.println("video Views" +videometrics.getViews());
                    
                    //PopularityScore popularityScore = new PopularityScore(videometrics.getViews(),videometrics.getLikes(),videometrics.getDislikes());
                    //popularityScore()

                    //channelContext.matricsValue(vname,videometrics,channelContext);
                }
                else{
                    System.out.println("format not correct");
                }

            }
            else
            {
                throw new Exception("no such operation");
            }

        }
        }
        catch (Exception ex)
        {
            //System.out.println("in parse");
            System.out.println( ex.getMessage());
            System.exit(0);
        }

        
    }
}