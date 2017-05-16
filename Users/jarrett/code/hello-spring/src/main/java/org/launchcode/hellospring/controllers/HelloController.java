package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.launchcode.hellospring.methods.HelloMessage.createMessage;


/**
 * Created by jarrett on 5/15/2017.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){

        String name = request.getParameter("name");

        if (name ==null) {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value= "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select lang='select' name='lang'>" +
                    "<option value='en'>English</option>" +
                    "<option value='fr'>French</option>" +
                    "<option value='sp'>Spanish</option>" +
                    "<option value='se'>Serbian</option>" +
                    "<option value='ge'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";

        return html;
    }

    @RequestMapping( value= "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){

        String name = request.getParameter("name");
        String language = request.getParameter("lang");

        return createMessage(language, name);
    }


    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye(){
        return "redirect:/" ;

    }

}
