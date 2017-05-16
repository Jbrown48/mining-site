package org.launchcode.hellospring.methods;

/**
 * Created by jarrett on 5/15/2017.
 */
public class HelloMessage {

    public static String createMessage(String lang, String name){
        if (lang.equals("fr")){
            return "Bon Jour, " + name;
        }else if(lang.equals("sp")){
            return "Buenos Dias, " + name;
        }else if(lang.equals("se")){
            return "dobar dan, " + name;
        }else if(lang.equals( "ge")){
            return "Guten Tag, " + name;
        }else{
            return "Hello, " + name;
        }
    }
}
