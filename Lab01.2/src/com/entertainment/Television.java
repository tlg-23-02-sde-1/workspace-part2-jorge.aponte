package com.entertainment;

import java.util.Objects;

public class Television {
    private String brand;
    private int volume;

    // Television HAS_A Tuner, delegates all channel-related functionality to Tuner
    private final Tuner tuner = new Tuner(); // instantiated internally, not exposed

    public Television() {
    }

    public Television(String brand, int volume) {
        this.brand = brand;
        this.volume = volume;
    }

    public int getCurrentChannel() {
        return tuner.getChannel();
    }

    public void changeChannel(int channel) {
        tuner.setChannel(channel);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int hashCode() {
        // this is a poorly written hash function, because it easily results in "hash collisions"
        // a "hash collision" is when different objects (by equals()) have the SAME hashcode (dumb luck)
        // return getBrand().length() + getVolume();

        // we can use java.util.Objects to help us create a "scientifically correct" hash function,
        // i.e., one the minimizes the probability of hash collisions
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // proceed only if 'obj' is really a reference to a Television object
        if (obj instanceof Television) {
            // safely downcast to more specific type Television, so we can call Television methods
            Television other = (Television) obj;

            // do the checks: brands are the same AND volumes are the same
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe check
                    this.getVolume() == other.getVolume();           // volume is primitive int no need for null-safe
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s: [brand=%s, volume=%s, currentChannel=%s]"
                , getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());

    }
}