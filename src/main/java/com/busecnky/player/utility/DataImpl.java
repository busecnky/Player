package com.busecnky.player.utility;


import com.busecnky.player.repository.entity.ETeam;
import com.busecnky.player.repository.entity.Player;
import com.busecnky.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataImpl implements ApplicationRunner {

    private final PlayerService playerService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
       //createPlayer();
    }


    public void createPlayer() {

        Player player6 = Player.builder()
                .name("Mert")
                .surname("Namsal")
                .jerseyNo(6L)
                .teamType(ETeam.MAIN)
                .build();

        Player player4 = Player.builder()
                .name("Ali")
                .surname("Öğütçen")
                .jerseyNo(4L)
                .teamType(ETeam.MAIN)
                .build();

        Player player8 = Player.builder()
                .name("Furkan")
                .surname("Türkmen")
                .jerseyNo(8L)
                .teamType(ETeam.MAIN)
                .build();

        Player player10 = Player.builder()
                .name("Melihcan")
                .surname("Öztürk")
                .jerseyNo(10L)
                .teamType(ETeam.MAIN)
                .build();

        Player player2 = Player.builder()
                .name("Buse")
                .surname("Çankaya")
                .jerseyNo(2L)
                .teamType(ETeam.MAIN)
                .build();

        Player player1 = Player.builder()
                .name("Murat")
                .surname("Kaya")
                .jerseyNo(1L)
                .teamType(ETeam.MAIN)
                .build();

        Player player3 = Player.builder()
                .name("Fatih")
                .surname("Er")
                .jerseyNo(3L)
                .teamType(ETeam.MAIN)
                .build();

        Player player5 = Player.builder()
                .name("Fahri")
                .surname("Şensoy")
                .jerseyNo(5L)
                .teamType(ETeam.MAIN)
                .build();

        Player player7 = Player.builder()
                .name("Baran")
                .surname("Mora")
                .jerseyNo(7L)
                .teamType(ETeam.MAIN)
                .build();

        Player player9 = Player.builder()
                .name("Gizem")
                .surname("Erdal")
                .jerseyNo(9L)
                .teamType(ETeam.MAIN)
                .build();
        playerService.saveAll(List.of(player1, player2, player3, player4, player5,player6, player7, player8, player9, player10));
    }

}
