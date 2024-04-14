package org.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    //------------------------Defining Common View for all-------------------------------
    @RequestMapping(value = "open-view")
    public String openView(@RequestParam(name="view") String view){

        return view;

    }
    //------------------------Finding Sum-------------------------------
    @RequestMapping(value = "/sum")
    public String findSum(@RequestParam(name = "n1")int n1, @RequestParam(name = "n1")int n2, Model model){
        String result = n1+"+"+n2+"="+(n1+n2);
        model.addAttribute("result", result);
        return "Show";
    }
    //------------------------Finding Difference-------------------------------
    @RequestMapping(value = "/diff")
    public String findDiff(@RequestParam(name = "n1")int n1, @RequestParam(name = "n1")int n2, Model model){
        String result = n1+"-"+n2+"="+(n1-n2);
        model.addAttribute("result", result);
        return "Show";
    }
    //------------------------Finding Product-------------------------------
    @RequestMapping(value = "/product")
    public String findProduct(@RequestParam(name = "n1")int n1, @RequestParam(name = "n1")int n2, Model model){
        String result = n1+"*"+n2+"="+(n1*n2);
        model.addAttribute("result", result);
        return "Show";
    }
    //------------------------Finding Remainder-------------------------------
    @RequestMapping(value = "/rem")
    public String findRem(@RequestParam(name = "n1")int n1, @RequestParam(name = "n1")int n2, Model model){
        String result = n1+"/"+n2+"="+(n1/n2);
        model.addAttribute("result", result);
        return "Show";
    }
    //------------------------Finding Largest Number-------------------------------
    @RequestMapping(value = "/largest")
    public String findLargestNo(@RequestParam(name = "n1")int n1, @RequestParam(name = "n1")int n2, Model model){
        if(n1>n2){
            String result= "Largest No is :"+n1;
            model.addAttribute("result", result);

        }
        else {
            String result= "Largest No is :"+n2;
            model.addAttribute("result", result);

        }
        return "Show";
    }
    //------------------------Finding Smallest Number-------------------------------
    @RequestMapping(value = "/smallest")
    public String findSmallestNo(@RequestParam(name = "n1")int n1, @RequestParam(name = "n1")int n2, Model model){
        if(n1>n2){
            String result= "Smallest No is :"+n1;
            model.addAttribute("result", result);

        }
        else {
            String result= "smallest No is :"+n2;
            model.addAttribute("result", result);

        }
        return "Show";
    }
}
