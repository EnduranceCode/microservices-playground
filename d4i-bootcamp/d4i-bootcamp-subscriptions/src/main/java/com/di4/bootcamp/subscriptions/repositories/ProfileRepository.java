package com.di4.bootcamp.subscriptions.repositories;

import com.di4.bootcamp.subscriptions.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
