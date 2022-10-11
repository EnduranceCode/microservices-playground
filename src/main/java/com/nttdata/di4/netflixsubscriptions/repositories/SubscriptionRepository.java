package com.nttdata.di4.netflixsubscriptions.repositories;

import com.nttdata.di4.netflixsubscriptions.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
