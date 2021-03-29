package channelpopularity.state;
import channelpopularity.operation.Operation;

public class Request{
    private String videoName;
    private int views;
    private int likes;
    private int dislikes;
    private int popularityScore;
    private Operation operationType;
    private VideoMetrics videoMetrics;
    private String name;

    public Request(String name) {
        this.name = name;
        this.popularityScore = 0;
        this.videoMetrics = new VideoMetrics(0,0,0);
    }

    public void setVideoName(String vName) {
        this.videoName = vName;
    }
    public void setViews(int view) {
        this.views=view;
    }
    public void setLikes(int like) {
        this.likes=like;
    }
    public void setDislikes(int dislike) {
        this.dislikes=dislike;
    }
    public void setOperation(Operation otype) {
        this.operationType=otype;
    }
    public String getVideoName() {
        return this.videoName;
    }
    public int getViews() {
        return this.views;
    }
    public int getLikes() {
        return this.likes;
    }
    public int getDislikes() {
       return this.dislikes;
    }
    public Operation getOperation() {
        return this.operationType;
    }

}