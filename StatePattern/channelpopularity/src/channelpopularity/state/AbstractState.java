package channelpopularity.state;
import channelpopularity.context.ChannelContext;
import channelpopularity.context.ContextI;
import channelpopularity.state.VideoMetrics;
//import channelpopularity.state.DoOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractState implements StateI {
protected ContextI context;

public AbstractState(ChannelContext context)
{
    this.context = context;
}

   /* @Override
    public void addVideo(String videoName, ContextI context) {
        Map<String, VideoMetrics> currentVideos = new HashMap<>();
        currentVideos=getVideos();
        if (currentVideos.containsKey(videoName)) {
            System.out.println(videoName + " already exists.");
        } else {
            Request request = new Request(videoName);
            currentVideos.put(videoName, request);
        }
        int ChannelPopularity=CaculatePopularity();
        SettingNextState(context);
        String currStateN=getCurrentStateName();
        System.out.println(currStateN+"__VIDEO_ADDED::"+videoName);
        //Results results = context.getResults();
        //results.recordData(getCurrentStateName() + VIDEO_ADDED + videoName);
    }
    private void SettingNextState(ContextI context) {
        StateName nextState = null;
        int channelPopularity = context.computeChannelPopularity();

        if (channelPopularity >=0 && channelPopularity <= 1000) {
            nextState = StateName.UNPOPULAR;
        } else if (channelPopularity > 1000 && channelPopularity <= 10_000) {
            nextState = StateName.MILDLY_POPULAR;
        } else if (channelPopularity > 10_000 && channelPopularity <= 100_000) {
            nextState = StateName.HIGHLY_POPULAR;
        } else if (channelPopularity > 100_000 && channelPopularity <= Integer.MAX_VALUE) {
            nextState = StateName.ULTRA_POPULAR;
        }

        context.setCurrentState(nextState);
    }*/

}


