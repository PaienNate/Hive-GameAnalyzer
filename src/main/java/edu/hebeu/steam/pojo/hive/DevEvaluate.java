package edu.hebeu.steam.pojo.hive;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevEvaluate {
    String dev;
    String name;
    int owner;
    int price;
    int avgTime;
    int avgPositive;
    String poname;
    double povalue;
    String ccuname;
    int ccuvalue;
}
