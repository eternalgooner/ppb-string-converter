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

   /* @Override
    protected boolean addedTimeApplies() {
        if(minutes < _45){
            LOGGER.debug("no added time detected");
            return false;
        }else if(addedTimeDetected()){
            LOGGER.debug(ADDED_TIME_DETECTED);
            return true;
        }
        LOGGER.error("If this flow has been reached then the logic to calculate first half added time is incorrect");
        return false;
    }*/

   /* private boolean addedTimeDetected() {
        return (minutes > _45) || ((minutes == _45) && ((seconds > 0) || (milliseconds > 0)));
    }*/
}
