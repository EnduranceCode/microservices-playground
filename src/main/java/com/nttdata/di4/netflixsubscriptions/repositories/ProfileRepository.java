package com.nttdata.di4.netflixsubscriptions.repositories;

import com.nttdata.di4.netflixsubscriptions.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
