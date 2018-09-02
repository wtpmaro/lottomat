package com.lottogenerator.demo.model.service;

import com.lottogenerator.demo.model.Lotto;

import java.util.*;

public class LottoRandom {

    public List<Integer> computerRandom () {

        Random number = new Random();

        Set<Integer> list = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();

        while (list.size() < 6) {
            Integer number1 = number.nextInt(49)+1;
            list.add(number1);
        }
        list1.addAll(list);
        return list1;
    }

}
