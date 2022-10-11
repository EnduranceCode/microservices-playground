package com.nttdata.di4.netflixsubscriptions.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfileDto implements Serializable {

    private static final long serialVersionUID = -4542714954677891619L;

    private Long id;
    private String name;
    private String alias;
    private String avatar;
    private SubscriptionDto subscriptions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public SubscriptionDto getSubscriptions() {
        return subscriptions;
    }

    public void setSubscriptions(SubscriptionDto subscriptions) {
        this.subscriptions = subscriptions;
    }
}
