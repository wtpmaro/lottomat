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



    //Set values from List to object
    public void setComputerChoice(Lotto lotto, List<Integer> list) {

            lotto.setFirst(list.get(0));
            lotto.setSecond(list.get(1));
            lotto.setThird(list.get(2));
            lotto.setFourth(list.get(3));
            lotto.setFiveth(list.get(4));
            lotto.setSixth(list.get(5));

    }

    //Creation list chosen numbers
    public List<Integer> amountUniqueUserChoice(Lotto lotto){

        List<Integer> convertedList = new ArrayList<>();

        Set<Integer> uniqueList= new HashSet<>();
        uniqueList.add(lotto.getFirst());
        uniqueList.add(lotto.getSecond());
        uniqueList.add(lotto.getThird());
        uniqueList.add(lotto.getFourth());
        uniqueList.add(lotto.getFiveth());
        uniqueList.add(lotto.getSixth());

        convertedList.addAll(uniqueList);

        return convertedList;
        
    }

    //checking how many numbers have been predicted by user
    public Integer correctNumbers (List<Integer> amountUniqueUserChoice, List<Integer> computerRandom) {

        Integer correctNumbers = 0;
        for (int i=0; i < computerRandom.size(); i++) {
            for (int j=0; j < amountUniqueUserChoice.size(); j++) {
                if(computerRandom.get(i) == amountUniqueUserChoice.get(j)) {
                    correctNumbers+=1;
                }
            }
        }


        return correctNumbers;
    }

}
