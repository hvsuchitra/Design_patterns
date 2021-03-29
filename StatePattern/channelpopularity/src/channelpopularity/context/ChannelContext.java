package channelpopularity.context;
import channelpopularity.util.FileProcessor;
import channelpopularity.state.factory.SimpleStateFactoryI;
import channelpopularity.context.PopularityScore;
import channelpopularity.state.factory.*;
import channelpopularity.state.StateName;
import channelpopularity.state.VideoMetrics;
import channelpopularity.state.Request;
import channelpopularity.state.*;
import channelpopularity.context.InputParser;
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import channelpopularity.state.AbstractState;




import java.util.ArrayList;
import java.util.Iterator;

/**
 * ChannelContext initialises instances using simplestatefactory and sets current state
 */
public class ChannelContext implements ContextI {
    // public void setCurrentState(StateName nextState);
    // (store input parser obj)
    private SimpleStateFactoryI ssfObj; //(store SimpleStateFact Obj)
    private InputParser inputParser;
    private StateI stateObj;
    //(results obj to store output strings)
    //private finalResult;
    private StateI curState;
    Map<StateName, StateI> availableStates;
    //Map<VideoName, Popularity> popularityMapping;//(video -> Video popuarity mapping)
    // Map<VideoName, VideoMetrics> videoMetricsMap;//(video -> Video Metrics mapping)
    private int channelPopularity;

    public ChannelContext(SimpleStateFactoryI ssfObj, String inputFilePath, List<StateName> stateNames) throws IOException, FileNotFoundException {
        this.ssfObj = ssfObj;
        this.availableStates = new HashMap<>();
        //System.out.println("in ChannelContext");
        this.inputParser = new InputParser(inputFilePath, this);
        for (StateName stateName : stateNames) {
            //System.out.println("Statename" + stateName);
            stateObj = ssfObj.create(stateName);
            availableStates.put(stateName, stateObj);
        }
        // getInstance()

        this.curState = availableStates.get(StateName.UNPOPULAR);

    }
    public Map<String, VideoMetrics> videos;

    public Map<String, VideoMetrics> getVideos() {
        return videos;
    }

    //public void actions()
    /*public void addVideo(String videoName) {
        this.curState.addVideo(videoName, this);
    }*/
    /*public static ChannelContext getInstance(SimpleStateFactoryI ssfObj,String inputFilePath) throws IOException,FileNotFoundException
    {
        ChannelContext context = new ChannelContext(ssfObj, inputFilePath);
        currentState = ssfObj.create(StateName.UNPOPULAR);//, context);
        context.availableStates.put(StateName.UNPOPULAR, currentState);
        return context;
    }*/
    @Override
    public void setCurrentState(StateName nextState) {
        if (availableStates.containsKey(nextState)) { // for safety.
            curState = availableStates.get(nextState);
        }
    }

    public void initiate() throws IOException {
        inputParser.next();

    }


  /*  public Map<String, VideoMetrics> getVideos() {
        return videoMetrics;
    }
    public int computeChannelPopularity() {
        
        int totalNumVideos = videoMetrics.size();
        int totalVideoPopularity = 0;
        for (String videoName : videoMetrics.keySet()) {
            VideoMetrics v = videoMetrics.get(videoName);
            String popularyscore=getVideoMetrics().getViews() + 2 * (getVideoMetrics().getLikes() - getVideoMetrics().getDislikes());
            totalVideoPopularity += v.getPopularityScore();
        }

        this.channelPopularityScore = totalVideoPopularity / totalNumVideos;

        return getChannelPopularity();
    }*/
   /* public void recordMetrics(String videoName, VideoMetrics metrics) {
        this.curState.recordMetrics(videoName, metrics,this);
    }*/
}

/*public ChannelContext(String inputFilePath)
{
    try {
        FileProcessor fileProcessor = new FileProcessor(inputFilePath);
        String Line = fileProcessor.poll();
        //String[] arrOfVideos= new S;
        String addVideo="ADD";
        String metrics="METRICS";
        String adRequest="AD";
        String removeVideo="REMOVE";
        int views,likes,dislikes,length,videoCount,scoreVal=0;
        System.out.println(Line);
        ArrayList<String> alist = new ArrayList<String>();
        Iterator itr=alist.iterator();
       // System.out.println(stateName.name());
        while (Line != null)
        {
            //String[] arrOfStr = Line.split("\\W");
            String[] arrOfStr = Line.split("_|\\[|\\]|::|,|=");

            //for(int i=0;i<arrOfStr.length;i++) {
            if (addVideo.equals(arrOfStr[0]))
            {
                System.out.println("Video to be added is "+arrOfStr[2]);
                alist.add(arrOfStr[2]);
                //videoCount=videoCount+1;
            }
            else if(metrics.equals(arrOfStr[0]))
            {
                //value of video arrOfStr[2]
                videoCount=alist.size();
                views=Integer.parseInt(arrOfStr[5]);
                likes=Integer.parseInt(arrOfStr[7]);
                 dislikes=Integer.parseInt(arrOfStr[9]);
                 PopularityScore popularityScore= new PopularityScore(views,videoCount,likes,dislikes);
                 scoreVal= scoreVal+popularityScore.CalculateScore();
                 System.out.println("calculated score val"+scoreVal);
                 //System.out.println("no of views for the "+arrOfStr[2]+" is "+views);
                //System.out.println("no of likes for the "+arrOfStr[2]+" is "+likes);
                //System.out.println("no of dislikes for the "+arrOfStr[2]+" is "+dislikes);
                

            }
            else if(adRequest.equals(arrOfStr[0]))
            {
                //value of video arrOfStr[3]
                /*for(int i=0;i<arrOfStr.length;i++)
                {   System.out.println(i);
                    System.out.println(arrOfStr[i]);
                    i++;
                }*/
                //System.out.println("in request");--------
               /* length=Integer.parseInt(arrOfStr[5]);
                System.out.println("lenght of the add requested"+length);

            }
            else
            {
                if(removeVideo.equals(arrOfStr[0]))
                {
                    //value of video arrOfStr[2]
                    //System.out.println("in remove");
                    //scoreVal=scoreVal-popularityScore.CalculateScore();
                    System.out.println("the video to be removed is "+arrOfStr[2]);
                    alist.remove(arrOfStr[2]);
                }

            }
            Line = fileProcessor.poll();

        }
        //System.out.println("length of list"+alist.size());
        for (int i = 0; i<alist.size(); i++) {
           // System.out.println("total Videos in the list\n");
            System.out.println(alist.get(i));
        }
        //System.out.println(videoCount);
    }
    catch (Exception ex)
    {
        System.out.println(ex.getMessage());
        System.exit(0);
    }
}*/

