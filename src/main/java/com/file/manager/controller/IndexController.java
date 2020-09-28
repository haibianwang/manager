package com.file.manager.controller;


import com.file.manager.util.FileDto;
import com.file.manager.util.FileUtil;
import com.file.manager.util.Tree;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller

public class IndexController {
    @Value("${file.dir}")
    private String dir;

    @RequestMapping(value = "/doindex",method = RequestMethod.POST)
    public String index(Model model) throws FileNotFoundException {
        FileDto fileDto=FileUtil.get(dir);
        String url="index";

        model.addAttribute("file", fileDto);

       return url;
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(Model model,String dir){
        this.dir=dir;
        return "forward:/doindex";
    }
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dologin(Model model,String username,String password) throws FileNotFoundException {
        //FileDto fileDto=FileUtil.get(dir);
        String url="";
        if (username!=null&&password!=null) {
            //model.addAttribute("file", fileDto);
            if (username.equals("hequ") && password.equals("hequhecong")) {
                return "forward:/doindex";
            } else {
                url = "login";
            }
        }else {
            url="login";
        }
        return url;
    }
    @RequestMapping("/")
    public String login(Model model) throws FileNotFoundException {
        return "login";

    }
    @RequestMapping("/player")
    public String player(Model model,String path) throws FileNotFoundException {
        //FileDto fileDto=FileUtil.get(dir);
        model.addAttribute("path",path);
        return "player";

    }
    @RequestMapping("/open")
    @ResponseBody
    public List<FileDto> open(String path,int parenid,Model model)  {

        List<FileDto> list=FileUtil.list(path,parenid);



        return list;

    }
}
