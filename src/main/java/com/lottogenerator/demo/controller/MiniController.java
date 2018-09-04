package com.lottogenerator.demo.controller;

import com.lottogenerator.demo.model.Mini;
import com.lottogenerator.demo.model.Multi;
import com.lottogenerator.demo.model.service.LottoRandom;
import com.lottogenerator.demo.model.service.MiniRandom;
import com.lottogenerator.demo.model.service.MultiRandom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("mini")
public class MiniController {


    @GetMapping("")
    public String miniLotto (Model model) {

        model.addAttribute("lotto",new Mini(2,3,4,5,6));
        return "miniForm";
    }

    @ModelAttribute("lotto2")
    List<Integer> lottoNumberList() {

        List<Integer> list = new ArrayList<>();
        for (Integer i=1; i < 43; i++) {
            list.add(i);
        }
        return list;
    }

    @PostMapping("")
    public String miniLottoResult(Model model,@ModelAttribute Mini lottoUser) {

        Mini multi = new Mini(1, 2, 3, 4, 5);

        //Drawing by computer
        MiniRandom miniRandom = new MiniRandom();

        List<Integer> computerList = miniRandom.computerRandom();

        //Set userList
        //User list (user choice)
        List<Integer> listUser = miniRandom.userList(lottoUser);

        //Creating result
        LottoRandom lottoRandom = new LottoRandom();
        Integer result = lottoRandom.correctNumbers(listUser, computerList);

        model.addAttribute("lists",computerList);
        model.addAttribute("listUser",listUser);
        model.addAttribute("result",result);

        return "index2";
    }
}
