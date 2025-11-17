package com.k23cnt2.nht.k23cnt2.nht.lesson05.controller;

import com.k23cnt2.nht.k23cnt2.nht.lesson05.entity.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.ArrayList;
@Controller
@RequestMapping
public class HomeController {
    @GetMapping
    public String home() {
        return "index";
    }
        @GetMapping("/profile")
        public String profile(Model model) {

            List<Info> profile = new ArrayList<>();
            profile.add(new Info(
                    "DevMaster Academy",
                    "nht",
                    "thongub14@gmail.com",
                    "https://devmaster.edu.vn"
            ));

            model.addAttribute("profile", profile);

            return "profile";
    }
}
