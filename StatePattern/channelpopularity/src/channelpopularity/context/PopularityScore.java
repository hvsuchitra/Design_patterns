package channelpopularity.context;
/**
 * PopularityScore calculates the popularyscore for the channel and videos
 */
public class PopularityScore
{
    public int views,totalVideos,likes,dislikes;
    public int popularityVal;

    public  PopularityScore(int views,int totalVideos,int likes,int dislikes)
    {
        this.views=views;
        this.totalVideos=totalVideos;
        this.likes=likes;
        this.dislikes=dislikes;
    }
    public int CalculateScore()
    {
        System.out.println("calculating");

         int temp=views+(2*(likes-dislikes));
         popularityVal=temp/totalVideos;
         int channelapopularity=popularityVal/totalVideos;
         return popularityVal;

    }

}