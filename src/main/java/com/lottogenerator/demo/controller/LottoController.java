package com.lottogenerator.demo.controller;

import com.lottogenerator.demo.model.Lotto;
import com.lottogenerator.demo.model.service.LottoRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("lotto")
public class LottoController {


    @PostMapping("")
    public String see (Model model,@ModelAttribute Lotto lottoUser) {


        Lotto lottoComp = new Lotto();
        LottoRandom computer = new LottoRandom();

        if((computer.amountUniqueUserChoice(lottoUser).size() != 6) ||
        (computer.amountUniqueUserChoice(lottoUser).contains(null))){
            return "lottoForm";
        }

        //Drawing numbers by computer
        List<Integer> listComp= new ArrayList<>();
        listComp = computer.computerRandom();

        //User list (user choice)
        List<Integer> listUser = computer.amountUniqueUserChoice(lottoUser);

        //Set values from list to Lotto Object
        computer.setComputerChoice(lottoComp, listComp);

        //Creating result
        Integer result = computer.correctNumbers(listUser, listComp);

        model.addAttribute("lotto",lottoComp);
        model.addAttribute("lotto2",lottoNumberList());
        model.addAttribute("lotto3",lottoUser);
        model.addAttribute("lotto4",result);

        return "index";
    }

    @GetMapping("")
    public String choice (Model model) {

        model.addAttribute("lotto", new Lotto());

        return "lottoForm";
    }

    @ModelAttribute("lotto2")
    List<Integer> lottoNumberList() {

        List<Integer> list = new ArrayList<>();
        for (Integer i=1; i < 50; i++) {
            list.add(i);
        }
        return list;
    }
}
