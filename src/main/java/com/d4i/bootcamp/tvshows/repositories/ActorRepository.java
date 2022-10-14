package com.d4i.bootcamp.tvshows.repositories;

import com.d4i.bootcamp.tvshows.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

}
