package edu.hebeu.steam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JWTToken {
    private String token;

    private String exipreAt;

    public JWTToken(String token) {
        this.token = token;
    }
}
