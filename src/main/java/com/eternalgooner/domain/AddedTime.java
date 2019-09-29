package com.eternalgooner.domain;

import java.util.Objects;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public class AddedTime {

    private int minutes;
    private int seconds;

    public AddedTime(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return "AddedTime{" +
                "minutes=" + minutes +
                ", seconds=" + seconds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddedTime addedTime = (AddedTime) o;
        return minutes == addedTime.minutes &&
                seconds == addedTime.seconds;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, seconds);
    }
}
