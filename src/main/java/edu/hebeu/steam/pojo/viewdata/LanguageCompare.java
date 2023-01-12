package edu.hebeu.steam.pojo.viewdata;

import cn.hutool.core.util.NumberUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageCompare {
    String word;
    double value0;
    double value1;
    public void setValue0(double value0)
    {
        this.value0 = NumberUtil.round(value0 * 100,2).doubleValue();
    }
    public void setValue1(double value1)
    {
        this.value1 = NumberUtil.round(value1 * 100,2).doubleValue();
    }
}
