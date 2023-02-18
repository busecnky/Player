package com.busecnky.player.mvccontroller.model;

import com.busecnky.player.dto.response.GroupFindAllResponseDto;
import com.busecnky.player.dto.response.PlayersFindAllResponseDto;
import com.busecnky.player.repository.entity.ETeam;
import com.busecnky.player.repository.entity.Group;
import com.busecnky.player.repository.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerIndexModel {

    String title;

    List<PlayersFindAllResponseDto> playerDtoList;
    List<GroupFindAllResponseDto> group1DtoList;
    List<GroupFindAllResponseDto> group2DtoList;
    ETeam team;

    String btnekle;
    String btnsil;

}
