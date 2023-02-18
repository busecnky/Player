package com.busecnky.player.service;

import com.busecnky.player.dto.request.PlayersCreateRequestDto;
import com.busecnky.player.dto.response.PlayersFindAllResponseDto;
import com.busecnky.player.mapper.IPlayersMapper;
import com.busecnky.player.repository.IPlayerRepository;
import com.busecnky.player.repository.entity.ETeam;
import com.busecnky.player.repository.entity.Player;
import com.busecnky.player.utility.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService extends ServiceManager<Player,Long> {
    @Autowired
    GroupService groupService;
    @Autowired
    IPlayerRepository repository;

    public PlayerService(IPlayerRepository jpaRepository) {
        super(jpaRepository);
    }

    public void save(PlayersCreateRequestDto dto){
        save(IPlayersMapper.INSTANCE.toPlayer(dto));
    }

    public List<PlayersFindAllResponseDto> findAllResponseDtos(){

        List<PlayersFindAllResponseDto> result = new ArrayList<>();

        findAll().forEach(x->{

            result.add(IPlayersMapper.INSTANCE.playersFindAllResponseDto(x));
        });
        return result;
    }

    public void delete2JerseyNo(Long jerseyNo) {
        Player player = findByJerseyNo(jerseyNo);
        deleteById(player.getId());
    }


    public Player findByJerseyNo(Long jerseyNo) {
        return repository.findByJerseyNo(jerseyNo);
    }
}
