package edu.hebeu.steam.pojo;
import cn.hutool.core.util.NumberUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Language {
    private List<String> names;
    private List<Double> value0;
    private List<Double> value1;
}
