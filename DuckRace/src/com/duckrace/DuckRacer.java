package com.duckrace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class DuckRacer {
    private final int id;
    private String name;
    private final List<Reward> rewards = new ArrayList<>();

    // ctor
    public DuckRacer(int id, String name) {
        setName(name);
        this.id = id;
    }

    // business methods
    public void win(Reward reward){
        rewards.add(reward);
    }

    // accessor methods
    // a derived property, we can " calculate" the number of wins from the 'rewards' collection
    public int getWins() {
        return rewards.size();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // NOTE: we are returning a read-only view of our List<Reward>
    // the client can't mess with it (add/remove/clear), but it is a "live" view of the List
    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    @Override
    public String toString() {
        return String.format("%s: id=%s, name=%s, wins=%s, rewards=%s"
                , getClass().getSimpleName(), getId(), getName(), getWins(), getRewards());
    }
}