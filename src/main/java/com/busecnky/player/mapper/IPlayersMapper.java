package com.busecnky.player.mapper;

import com.busecnky.player.dto.request.PlayersCreateRequestDto;
import com.busecnky.player.dto.response.PlayersFindAllResponseDto;
import com.busecnky.player.repository.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPlayersMapper {

    IPlayersMapper INSTANCE = Mappers.getMapper(IPlayersMapper.class);

    Player toPlayer(final PlayersCreateRequestDto dto);

    PlayersFindAllResponseDto playersFindAllResponseDto(final Player player);

    PlayersCreateRequestDto playersCreateRequestDto(final Player player);
}
