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

        if(computer.amountUniqueUserChoice(lottoUser) != 6) {
            return "lottoForm";
        }

        List<Integer> list= new ArrayList<>();
        list = computer.computerRandom();

        computer.setComputerChoice(lottoComp, list);

        model.addAttribute("lotto",lottoComp);
        model.addAttribute("lotto2",lottoNumberList());
        model.addAttribute("lotto3",lottoUser);

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
