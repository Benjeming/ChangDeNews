package domain;

public class Aritcle {
private String title;
private String time;
private String url;
private String content;

    public Aritcle() {
    }

    public Aritcle(String title, String time, String url, String content) {
        this.title = title;
        this.time = time;
        this.url = url;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Aritcle{" +
                "title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
