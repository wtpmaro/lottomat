package com.lottogenerator.demo.model.service;


import com.lottogenerator.demo.model.Lotto;
import com.lottogenerator.demo.model.Multi;

import java.util.*;

public class MultiRandom {

    public List<Integer> computerRandom () {

        Random number = new Random();

        Set<Integer> list = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();

        while (list.size() < 20) {
            Integer number1 = number.nextInt(80)+1;
            list.add(number1);
        }
        list1.addAll(list);
        return list1;
    }

    public List<Integer> userList(Multi lotto) {

        List<Integer> userList = new ArrayList<>();
        Set<Integer> list = new HashSet<>();

        list.add(lotto.getFirst());
        list.add(lotto.getSecond());
        list.add(lotto.getThird());
        list.add(lotto.getFourth());
        list.add(lotto.getFiveth());
        list.add(lotto.getSixth());
        list.add(lotto.getSeventh());
        list.add(lotto.getEight());
        list.add(lotto.getNineth());
        list.add(lotto.getTen());

        userList.addAll(list);

        return userList;
    }

}
