package channelpopularity.state;

public class VideoMetrics{

    private int views;
    private int likes;
    private int dislikes;
    public VideoMetrics(int views, int likes, int dislikes) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
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
    public int getViews() {
        return this.views;
    }
    public int getLikes() {
        return this.likes;
    }
    public int getDislikes() {
        return this.dislikes;
    }
}