package com.busecnky.player.service;

import com.busecnky.player.dto.request.GroupCreateRequestDto;
import com.busecnky.player.dto.request.PlayersCreateRequestDto;
import com.busecnky.player.dto.response.GroupFindAllResponseDto;
import com.busecnky.player.mapper.IGroupMapper;
import com.busecnky.player.mapper.IPlayersMapper;
import com.busecnky.player.repository.IGroupRepository;
import com.busecnky.player.repository.IPlayerRepository;
import com.busecnky.player.repository.entity.ETeam;
import com.busecnky.player.repository.entity.Group;
import com.busecnky.player.repository.entity.Player;
import com.busecnky.player.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupService extends ServiceManager<Group,Long> {

    @Autowired
    IPlayerRepository playerRepository;
    @Autowired
    IGroupRepository groupRepository;
    public GroupService(IGroupRepository jpaRepository) {
        super(jpaRepository);
    }

    public void save(GroupCreateRequestDto dto){
        save(IGroupMapper.INSTANCE.toGroup(dto));
    }

    public List<GroupFindAllResponseDto> findAllResponseDtos(){

        List<GroupFindAllResponseDto> result = new ArrayList<>();

        findAll().forEach(x->{

            result.add(IGroupMapper.INSTANCE.groupFindAllResponseDto(x));
        });
        return result;
    }

    public void saveTwo(Long jerseyNo) {
        System.out.println("xxxx" + jerseyNo);
        Player player = playerRepository.findByJerseyNo(jerseyNo);
        System.out.println(jerseyNo);
        GroupCreateRequestDto dto = IGroupMapper.INSTANCE
                .groupCreateRequestDto(IGroupMapper.INSTANCE.playertoGroup(player));
        System.out.println(dto);
        dto.setTeam(ETeam.TEAM2);
        save(dto);

    }

    public Group findByJerseyNo(Long jerseyNo) {
        return groupRepository.findByJerseyNo(jerseyNo);
    }

}
