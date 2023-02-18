package com.busecnky.player.dto.request;

import com.busecnky.player.repository.entity.ETeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayersCreateRequestDto {

    Long jerseyNo;
    String name;
    String surname;

    ETeam team;
}
