package com.jjmining.miningsite.miningsite.controllers;

import com.jjmining.miningsite.miningsite.models.Part;
import com.jjmining.miningsite.miningsite.models.data.CustomerDao;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by jarrett on 8/14/2017.
 */
@Controller
@RequestMapping("owner")
public class OwnerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value = "")
    public String index(Model model) throws IOException {
        model.addAttribute("title", "Owner Info");
        model.addAttribute("btcPrice","$4001");
        model.addAttribute("ztcPrice","$206");

        /*
        String url = "https://pcpartpicker.com/product/Q9Gj4D/asus-motherboard-z170a";
        Document document = Jsoup.connect(url).get();

        String moboName = document.select(".title h1").text();
        String moboPrice = document.select("td.total a").first().text();

        Element link = document.select("td.total a").first();
        String moboLink = link.attr("abs:href");
        //
        model.addAttribute("moboName", moboName);
        model.addAttribute("moboPrice", moboPrice);
        model.addAttribute("moboLink",moboLink);
        */
        Part mobo = new Part("Motherboard","https://pcpartpicker.com/product/7VZ2FT/asus-prime-z270-a-atx-lga1151-motherboard-prime-z270-a");
        Part cpu = new Part("CPU","https://pcpartpicker.com/product/8gKhP6/intel-pentium-g4560-35ghz-dual-core-processor-bx80677g4560");
        Part ram = new Part("RAM","https://pcpartpicker.com/product/Z8KhP6/crucial-memory-bls4g4d240fsb");
        Part ssd = new Part("SSD","https://pcpartpicker.com/product/3kL7YJ/samsung-internal-hard-drive-mz75e250bam");
        Part gpu = new Part("GPU","https://pcpartpicker.com/product/cHFXsY/gigabyte-geforce-gtx-1080-ti-11gb-aorus-video-card-gv-n108taorus-11gd");
        Part psu = new Part("PSU","https://pcpartpicker.com/product/8LMFf7/evga-power-supply-120g21300xr");
        model.addAttribute("mobo",mobo);
        model.addAttribute("cpu",cpu);
        model.addAttribute("ram",ram);
        model.addAttribute("ssd",ssd);
        model.addAttribute("psu",psu);
        model.addAttribute("gpu",gpu);

        return "owner/home";
    }

    @RequestMapping(value="customer-list")
    public String customerList(Model model){
        model.addAttribute("title", "Customer List");
        model.addAttribute("customers", customerDao.findAll());

        return "owner/customer-list";
    }
}
