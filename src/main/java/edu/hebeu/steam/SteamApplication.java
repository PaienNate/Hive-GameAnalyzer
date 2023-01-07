package edu.hebeu.steam;

import com.lukaspradel.steamapi.core.exception.SteamApiException;
import com.lukaspradel.steamapi.data.json.appnews.GetNewsForApp;
import com.lukaspradel.steamapi.data.json.ownedgames.Game;
import com.lukaspradel.steamapi.data.json.ownedgames.GetOwnedGames;
import com.lukaspradel.steamapi.webapi.client.SteamWebApiClient;
import com.lukaspradel.steamapi.webapi.request.GetNewsForAppRequest;
import com.lukaspradel.steamapi.webapi.request.GetOwnedGamesRequest;
import com.lukaspradel.steamapi.webapi.request.GetRecentlyPlayedGamesRequest;
import com.lukaspradel.steamapi.webapi.request.SteamWebApiRequestHandler;
import com.lukaspradel.steamapi.webapi.request.builders.SteamWebApiRequestFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SteamApplication {

    public static void main(String[] args) throws SteamApiException {

        SpringApplication.run(SteamApplication.class, args);
    }

}
