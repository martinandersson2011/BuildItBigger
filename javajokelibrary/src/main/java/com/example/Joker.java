package com.example;

import java.util.Random;

public class Joker {

    public String getJoke() {
        int randomNumber = new Random().nextInt(10);
        String joke;

        switch (randomNumber) {
            case 0:
                joke = "This is joke number 1";
                break;
            case 1:
                joke = "This is joke number 2";
                break;
            case 2:
                joke = "This is joke number 3";
                break;
            case 3:
                joke = "This is joke number 4";
                break;
            case 4:
                joke = "This is joke number 5";
                break;
            case 5:
                joke = "This is joke number 6";
                break;
            case 6:
                joke = "This is joke number 7";
                break;
            case 7:
                joke = "This is joke number 8";
                break;
            case 8:
                joke = "This is joke number 9";
                break;
            case 9:
                joke = "This is joke number 10";
                break;
            default:
                joke = "No joke found";
                break;

        }

        return joke;
    }
}
