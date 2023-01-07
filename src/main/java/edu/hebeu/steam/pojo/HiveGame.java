package edu.hebeu.steam.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class HiveGame {
    int id;
    int gamelink;
    String gamename;
    String gamepic;
    Date releasedate;
    double price;
    int owners;
    String playtime;
    String developers;
    String publishers;
    String playtime_me;
}
