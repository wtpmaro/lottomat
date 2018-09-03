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

    public List<Integer> userList(Lotto lotto) {

        List<Integer> userList = new ArrayList<>();
        Set<Integer> list = new HashSet<>();

        list.add(lotto.getFirst());
        list.add(lotto.getSecond());
        list.add(lotto.getThird());
        list.add(lotto.getFourth());
        list.add(lotto.getFiveth());
        list.add(lotto.getSixth());

        userList.addAll(list);

        return userList;
    }

    public void setComputerChoice(Lotto lotto, List<Integer> list) {

            lotto.setFirst(list.get(0));
            lotto.setSecond(list.get(1));
            lotto.setThird(list.get(2));
            lotto.setFourth(list.get(3));
            lotto.setFiveth(list.get(4));
            lotto.setSixth(list.get(5));

    }

    public Integer amountUniqueUserChoice(Lotto lotto){


        Set<Integer> uniqueList= new HashSet<>();
        uniqueList.add(lotto.getFirst());
        uniqueList.add(lotto.getSecond());
        uniqueList.add(lotto.getThird());
        uniqueList.add(lotto.getFourth());
        uniqueList.add(lotto.getFiveth());
        uniqueList.add(lotto.getSixth());

        return uniqueList.size();
        
    }

}
