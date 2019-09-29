package com.eternalgooner.domain;

import com.eternalgooner.enums.OutputMatchPeriod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public class FirstHalfMatchTime extends MatchTime {
    private static final int _45 = 45;
    private static final Logger LOGGER = LogManager.getLogger(FirstHalfMatchTime.class.getName());
    private static final String NO_ADDED_TIME_DETECTED = "no added time detected";
    private static final String ADDED_TIME_DETECTED = "added time detected";

    public FirstHalfMatchTime(String inputMatchTime, OutputMatchPeriod matchPeriod) {
        super(inputMatchTime, matchPeriod);
    }

    @Override
    protected void calculateAddedTime() {
        if(addedTimeApplies(_45)){
            int addedMinutes = minutes - _45;
            if(hasExtraSecondFromRoundedMilliseconds){
                ++seconds;
            }
            addedTime = new AddedTime(addedMinutes, seconds);
        }
    }
}
