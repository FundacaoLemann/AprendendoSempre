package org.aprendendosempre.app.main;

public class Site {

    private String title;
    private int img;
    private String url;

    public Site(String title, int img, String url){
        this.title = title;
        this.img = img;
        this.url = url;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getImg(){
        return img;
    }

    public void setImg(int img){
        this.img = img;
    }

    public String getUrl(){
        return url;
    }
}


