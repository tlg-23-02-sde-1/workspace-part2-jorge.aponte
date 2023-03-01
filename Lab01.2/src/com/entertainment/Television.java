package com.entertainment;

import java.util.Objects;

/*
 * Natural order is defined by 'brand' (String) and volume (int) when tied on brand.
 *
 * To be "consistent with equals," our sort key(s) must align with what was chosen
 * for equals() and hashCode().
 */

public class Television implements Comparable<Television> {
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
    public boolean equals(Object obj) {
        // if I am the same physical object as obj return true ex: tv1.equals(tv1);
        if (this == obj) return true;

        // if obj is null  OR  I and obj are not the same EXACT type ex: tv1.equals(null); || tv1.equals("hello");
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Television that = (Television) obj;
        return this.getVolume() == that.getVolume() && this.getBrand().equals(that.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getVolume());
    }

    /*
    @Override
    public int hashCode() {
        // this is a poorly written hash function, because it easily results in "hash collisions"
        // a "hash collision" is when different objects (by equals()) have the SAME hashcode (dumb luck)

        // we can use java.util.Objects to help us create a "scientifically correct" hash function,
        // i.e., one the minimizes the probability of hash collisions
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // proceed only if 'obj' is really a reference to a Television object
        if (this.getClass() == obj.getClass() && obj != null) {    // okay to use == for Class Objects and Enums
            // safely downcast to more specific type Television, so we can call Television methods
            Television other = (Television) obj;

            // do the checks: brands are the same AND volumes are the same
            result = Objects.equals(this.getBrand(), other.getBrand()) &&   // null-safe check
                    this.getVolume() == other.getVolume();           // volume is primitive int no need for null-safe
        }
        return result;
    }
*/

    /*
     * Natural order is defined by 'brand' (String) and then volume (int) when tied on brand.
     * Since brand (String) is already Comparable, just delegate to its compareTo() method.
     */
    @Override
    public int compareTo(Television that) {
        if (this.getBrand().compareTo(that.getBrand()) == 0) {
            return Integer.compare(this.getVolume(), that.getVolume());
        }
        return this.getBrand().compareTo(that.getBrand());
    }

    @Override
    public String toString() {
        return String.format("%s: [brand=%s, volume=%s, currentChannel=%s]"
                , getClass().getSimpleName(), getBrand(), getVolume(), getCurrentChannel());

    }
}