package com.lottogenerator.demo.model.service;

import com.lottogenerator.demo.model.Mini;
import com.lottogenerator.demo.model.Multi;

import java.util.*;

public class MiniRandom {

    public List<Integer> computerRandom () {

        Random number = new Random();

        Set<Integer> list = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();

        while (list.size() < 5) {
            Integer number1 = number.nextInt(42)+1;
            list.add(number1);
        }
        list1.addAll(list);
        return list1;
    }

    public List<Integer> userList(Mini lotto) {

        List<Integer> userList = new ArrayList<>();
        Set<Integer> list = new HashSet<>();

        list.add(lotto.getFirst());
        list.add(lotto.getSecond());
        list.add(lotto.getThird());
        list.add(lotto.getFourth());
        list.add(lotto.getFiveth());

        userList.addAll(list);

        return userList;
    }
}
