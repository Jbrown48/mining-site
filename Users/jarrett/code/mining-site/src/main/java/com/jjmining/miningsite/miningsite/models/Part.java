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
import java.util.List;
import java.util.Objects;

/**
 * Created by jarrett on 8/15/2017.
 */

@Entity
public class Part {

    @Id
    @GeneratedValue
    private int id = 0;//trying to figure out how to make this iterate each new part

    private static int counter = 0;

    @NotNull
    private String type;

    @NotNull
    private String name;

    @NotNull
    private Double price;

    @NotNull
    private String link;

    @NotNull
    private String pcUrl;

    //Need to look into adding all parts to arraylist?
    private static List<Part> allParts = new ArrayList<>();

    public Part(String type, String pcUrl) throws IOException {
        this.type = type;
        this.pcUrl = pcUrl;
        Document document = Jsoup.connect(pcUrl).get();
        String partName = document.select(".title h1").text();

        // can i get top three prices to show?
        String partPriceString = document.select("td.total a").first().text();
        Double partPrice = Double.valueOf(partPriceString.replaceAll("[$,+]", ""));
        Element partLink = document.select("td.total a").first();
        String relHref = partLink.attr("href");
        String absHref = partLink.attr("abs:href");
        this.name = partName;
        this.price = partPrice;
        this.link = absHref;
        if (!allParts.contains(this)){
            allParts.add(this);
        }
         ///Still not working as intended adding but adding part multiple time.
    }

    public Part() {
        ++counter;
        this.id=counter;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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

    public static List<Part> getAllParts() {
        return allParts;
    }

}
