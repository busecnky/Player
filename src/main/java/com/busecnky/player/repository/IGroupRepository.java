package com.busecnky.player.repository;

import com.busecnky.player.repository.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IGroupRepository extends JpaRepository<Group, Long> {


    @Query("SELECT g FROM Group g WHERE g.jerseyNo = :id")
    Group findByJerseyNo(@Param("id") Long id);
}
