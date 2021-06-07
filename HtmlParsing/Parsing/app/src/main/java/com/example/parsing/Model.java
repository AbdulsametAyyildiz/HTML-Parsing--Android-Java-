package com.example.parsing;

public class Model {
    private String txt,h3,ol,h4,cite,kaynak,h2,imageUrl,imageTxt;

    public Model(String txt, String h3, String ol, String h4, String cite, String kaynak, String h2, String imageUrl, String imageTxt) {
        this.txt = txt;
        this.h3 = h3;
        this.ol = ol;
        this.h4 = h4;
        this.cite = cite;
        this.kaynak = kaynak;
        this.h2 = h2;
        this.imageUrl = imageUrl;
        this.imageTxt = imageTxt;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getH3() {
        return h3;
    }

    public void setH3(String h3) {
        this.h3 = h3;
    }

    public String getOl() {
        return ol;
    }

    public void setOl(String ol) {
        this.ol = ol;
    }

    public String getH4() {
        return h4;
    }

    public void setH4(String h4) {
        this.h4 = h4;
    }

    public String getCite() {
        return cite;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public String getKaynak() {
        return kaynak;
    }

    public void setKaynak(String kaynak) {
        this.kaynak = kaynak;
    }

    public String getH2() {
        return h2;
    }

    public void setH2(String h2) {
        this.h2 = h2;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageTxt() {
        return imageTxt;
    }

    public void setImageTxt(String imageTxt) {
        this.imageTxt = imageTxt;
    }
}
