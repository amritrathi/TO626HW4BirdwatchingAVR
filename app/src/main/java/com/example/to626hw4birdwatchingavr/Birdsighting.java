package com.example.to626hw4birdwatchingavr;

public class Birdsighting {
    public String createBirdname;
    public String createZipcode;
    public String createPersonName;

    public Birdsighting(String createBirdname, Integer createZipcode, String createPersonName) {
    }

    public Birdsighting(String createBirdname, String createZipcode, String createPersonName) {
        this.createBirdname = createBirdname;
        this.createZipcode = createZipcode;
        this.createPersonName = createPersonName;
    }
}
