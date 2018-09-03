package com.lottogenerator.demo.model;

public class Multi extends Lotto{

    Integer seventh;

    Integer eight;

    Integer nineth;

    Integer ten;

    public Multi (Integer first, Integer second, Integer third, Integer fourth, Integer fiveth, Integer sixth, Integer seventh,
           Integer eight, Integer nineth, Integer ten) {
        super(first,second,third,fourth,fiveth,sixth);
        this.seventh=seventh;
        this.eight=eight;
        this.nineth=nineth;
        this.ten=ten;

    }

    public Integer getSeventh() {
        return seventh;
    }

    public void setSeventh(Integer seventh) {
        this.seventh = seventh;
    }

    public Integer getEight() {
        return eight;
    }

    public void setEight(Integer eight) {
        this.eight = eight;
    }

    public Integer getNineth() {
        return nineth;
    }

    public void setNineth(Integer nineth) {
        this.nineth = nineth;
    }

    public Integer getTen() {
        return ten;
    }

    public void setTen(Integer ten) {
        this.ten = ten;
    }
}
