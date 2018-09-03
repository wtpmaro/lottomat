package com.lottogenerator.demo.controller;

import com.lottogenerator.demo.model.Multi;
import com.lottogenerator.demo.model.service.LottoRandom;
import com.lottogenerator.demo.model.service.MultiRandom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("multi")
public class MultiController {


    @PostMapping("")
    public String multi (Model model, @ModelAttribute Multi lottoUser) {

        Multi multi = new Multi(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //Drawing by computer
        MultiRandom multiRandom = new MultiRandom();

        List<Integer> computerList = multiRandom.computerRandom();

        //Set userList
        //User list (user choice)
        List<Integer> listUser = multiRandom.userList(lottoUser);

        //Creating result
        LottoRandom lottoRandom = new LottoRandom();
        Integer result = lottoRandom.correctNumbers(listUser, computerList);

        model.addAttribute("lists",computerList);
        model.addAttribute("listUser",listUser);
        model.addAttribute("result",result);

        return "index1";
    }

    @GetMapping("")
    public String choiceUser(Model model) {

        model.addAttribute("lotto",new Multi(null, null, null, null, null, null, null, null, null, null));
        return "multiForm";
    }

    @ModelAttribute("lotto2")
    List<Integer> lottoNumberList() {

        List<Integer> list = new ArrayList<>();
        for (Integer i=1; i < 81; i++) {
            list.add(i);
        }
        return list;
    }
}
