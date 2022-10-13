package com.di4.bootcamp.subscriptions.repositories;

import com.di4.bootcamp.subscriptions.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
