package com.eternalgooner.domain;

import com.eternalgooner.enums.OutputMatchPeriod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public class SecondHalfMatchTime extends MatchTime {

    private static final int _90 = 90;
    private static final Logger LOGGER = LogManager.getLogger(SecondHalfMatchTime.class.getName());
    private static final String NO_ADDED_TIME_DETECTED = "no added time detected";
    private static final String ADDED_TIME_DETECTED = "added time detected";

    public SecondHalfMatchTime(String inputMatchTime, OutputMatchPeriod matchPeriod) {
        super(inputMatchTime, matchPeriod);
    }

    @Override
    protected void calculateAddedTime() {
        if(addedTimeApplies(_90)){
            int addedMinutes = minutes - _90;
            if(hasExtraSecondFromRoundedMilliseconds){
                ++seconds;
            }
            addedTime = new AddedTime(addedMinutes, seconds);
        }
    }

/*    @Override
    protected boolean addedTimeApplies() {
        if(minutes < _90){
            LOGGER.debug(NO_ADDED_TIME_DETECTED);
            return false;
        }else if(addedTimeDetected()){
            LOGGER.debug(ADDED_TIME_DETECTED);
            return true;
        }
        LOGGER.error("If this flow has been reached then the logic to calculate second half added time is incorrect");
        return false;
    }

    private boolean addedTimeDetected() {
       return (minutes > _90) || ((minutes == _90) && ((seconds > 0) || (milliseconds > 0)));
    }*/
}
