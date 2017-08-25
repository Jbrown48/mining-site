package com.jjmining.miningsite.miningsite.models;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

/**
 * Created by jarrett on 8/24/2017.
 */
public class CryptoPrice {

    private String name;
    private String price;

    public CryptoPrice(String name) throws IOException {
        this.name = name;
        this.price = getPrice(name);
    }

    public CryptoPrice() {
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

    public static String getPrice(String coin) throws IOException {
        String upCoin = coin.toUpperCase();
        String url = "https://min-api.cryptocompare.com/data/price?fsym="+upCoin+"&tsyms=USD";
        String doc = Jsoup.connect(url).ignoreContentType(true).execute().body();
        String price = doc.replaceAll("[^0-9.]", "");
        String fullPrice = upCoin+" $"+price;

        return(fullPrice);
    }

}
