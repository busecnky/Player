package com.busecnky.player.dto.response;

import com.busecnky.player.repository.entity.ETeam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupFindAllResponseDto {

    Long jerseyNo;
    String name;
    String surname;
    ETeam team;
}
