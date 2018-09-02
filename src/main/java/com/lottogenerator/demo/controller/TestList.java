package com.lottogenerator.demo.controller;

import com.lottogenerator.demo.model.Lotto;
import com.lottogenerator.demo.model.service.LottoRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("")
public class TestList {


    @GetMapping
    public String see (Model model) {

        Lotto lottoComp = new Lotto();
        LottoRandom computer = new LottoRandom();

        List<Integer> list= new ArrayList<>();
        list = computer.computerRandom();
        lottoComp.setFirst(list.get(0));
        lottoComp.setSecond(list.get(1));
        lottoComp.setThird(list.get(2));
        lottoComp.setFourth(list.get(3));
        lottoComp.setFiveth(list.get(4));
        lottoComp.setSixth(list.get(5));


        model.addAttribute("lotto",lottoComp);
        model.addAttribute("lotto1",list.toString());

        return "index";
    }
}
