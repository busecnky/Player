package com.busecnky.player.mapper;

import com.busecnky.player.dto.request.GroupCreateRequestDto;
import com.busecnky.player.dto.response.GroupFindAllResponseDto;
import com.busecnky.player.repository.entity.Group;
import com.busecnky.player.repository.entity.Player;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IGroupMapper {


        IGroupMapper INSTANCE = Mappers.getMapper(IGroupMapper.class);

        Group toGroup(final GroupCreateRequestDto dto);
        Group playertoGroup(final Player player);

        GroupFindAllResponseDto groupFindAllResponseDto(final Group group);
        GroupCreateRequestDto groupCreateRequestDto(final Group group);
}
