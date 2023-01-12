package edu.hebeu.steam.pojo.hive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gamedata2 {
    int appid;
    String name;
    String developer;
    String score_rank;
    int positive;
    int negative;
    String userscore;
    String owners;
    int average_forever;
    int average_2weeks;
    int median_forever;
    int median_2weeks;
    double price;
    double initialprice;
    int discount;
    int ccu;
    String languages;
    String genre;
    String tags;
}
