package com.jjmining.miningsite.miningsite.models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by jarrett on 8/15/2017.
 */

@Entity
public class Part {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String type;

    @NotNull
    private String name;

    @NotNull
    private String price;

    @NotNull
    private String link;

    @NotNull
    private String pcUrl;

    //Need to look into adding all parts to arraylist?
   /// private ArrayList<Part> part = new ArrayList<Part>();

    public Part(String type, String pcUrl) throws IOException {
        this.type = type;
        this.pcUrl = pcUrl;
        Document document = Jsoup.connect(pcUrl).get();
        String partName = document.select(".title h1").text();
        String partPrice = document.select("td.total a").first().text();
        Element partLink = document.select("td.total a").first();
        String relHref = partLink.attr("href");
        String absHref = partLink.attr("abs:href");
        this.name = partName;
        this.price = partPrice;
        this.link = absHref;
    }

    public Part() {
        ++id;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPcUrl() {
        return pcUrl;
    }
/*
    //Need to look into adding all parts to arraylist?
    public void setPcUrl(String pcUrl) {
        this.pcUrl = pcUrl;
    }

    public ArrayList<Part> getPart() {
        return part;
    }
 */
}
