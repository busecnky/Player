package com.busecnky.player.repository;

import com.busecnky.player.repository.entity.Group;
import com.busecnky.player.repository.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p WHERE p.jerseyNo = :id")
    Player findByJerseyNo(@Param("id") Long id);
}
