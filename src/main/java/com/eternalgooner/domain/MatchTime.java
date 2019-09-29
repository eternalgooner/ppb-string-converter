package com.eternalgooner.domain;

import com.eternalgooner.enums.OutputMatchPeriod;
import com.eternalgooner.utils.MatchTimeUtils;

import java.util.Objects;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public abstract class MatchTime {

    protected int minutes;
    protected int seconds;
    protected int milliseconds;
    protected OutputMatchPeriod matchPeriod;
    protected boolean hasAddedTime;
    protected boolean hasExtraSecondFromRoundedMilliseconds;
    protected AddedTime addedTime;

    public MatchTime(String inputMatchTime, OutputMatchPeriod matchPeriod){
        this.minutes = MatchTimeUtils.getMatchMinutesFromMatchTime(inputMatchTime);
        this.seconds = MatchTimeUtils.getMatchSecondsFromMatchTime(inputMatchTime);
        this.milliseconds = MatchTimeUtils.getMatchMillisecondsFromMatchTime(inputMatchTime);
        this.matchPeriod = matchPeriod;
        this.hasExtraSecondFromRoundedMilliseconds = MatchTimeUtils.millisecondsGreaterThanOrEqualTo500(inputMatchTime);
        this.hasAddedTime = addedTimeApplies();
        calculateAddedTime();
    }

    protected abstract void calculateAddedTime();

    protected abstract boolean addedTimeApplies();

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

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public OutputMatchPeriod getMatchPeriod() {
        return matchPeriod;
    }

    public void setMatchPeriod(OutputMatchPeriod matchPeriod) {
        this.matchPeriod = matchPeriod;
    }

    public boolean isHasAddedTime() {
        return hasAddedTime;
    }

    public void setHasAddedTime(boolean hasAddedTime) {
        this.hasAddedTime = hasAddedTime;
    }

    public boolean isHasExtraSecondFromRoundedMilliseconds() {
        return hasExtraSecondFromRoundedMilliseconds;
    }

    public void setHasExtraSecondFromRoundedMilliseconds(boolean hasExtraSecondFromRoundedMilliseconds) {
        this.hasExtraSecondFromRoundedMilliseconds = hasExtraSecondFromRoundedMilliseconds;
    }

    public AddedTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(AddedTime addedTime) {
        this.addedTime = addedTime;
    }

    @Override
    public String toString() {
        return "MatchTime{" +
                "minutes=" + minutes +
                ", seconds=" + seconds +
                ", milliseconds=" + milliseconds +
                ", matchPeriod=" + matchPeriod +
                ", hasAddedTime=" + hasAddedTime +
                ", hasExtraSecondFromRoundedMilliseconds=" + hasExtraSecondFromRoundedMilliseconds +
                ", addedTime=" + addedTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchTime matchTime = (MatchTime) o;
        return minutes == matchTime.minutes &&
                seconds == matchTime.seconds &&
                milliseconds == matchTime.milliseconds &&
                hasAddedTime == matchTime.hasAddedTime &&
                hasExtraSecondFromRoundedMilliseconds == matchTime.hasExtraSecondFromRoundedMilliseconds &&
                matchPeriod == matchTime.matchPeriod &&
                Objects.equals(addedTime, matchTime.addedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes, seconds, milliseconds, matchPeriod, hasAddedTime, hasExtraSecondFromRoundedMilliseconds, addedTime);
    }
}
