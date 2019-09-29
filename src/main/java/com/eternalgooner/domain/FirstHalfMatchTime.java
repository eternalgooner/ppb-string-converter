package com.eternalgooner.domain;

import com.eternalgooner.enums.OutputMatchPeriod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public class FirstHalfMatchTime extends MatchTime {
    public static final int _45 = 45;
    private static final Logger LOGGER = LogManager.getLogger(FirstHalfMatchTime.class.getName());

    public FirstHalfMatchTime(String inputMatchTime, OutputMatchPeriod matchPeriod) {
        super(inputMatchTime, matchPeriod);
    }

    @Override
    protected void calculateAddedTime() {
        if(addedTimeApplies()){
            int addedMinutes = minutes - _45;
            if(hasExtraSecondFromRoundedMilliseconds){
                ++seconds;
            }
            addedTime = new AddedTime(addedMinutes, seconds);
        }
    }

    @Override
    protected boolean addedTimeApplies() {
        if(minutes < _45){
            return false;
        }else if(minutes > _45){
             return true;
        }else if((minutes == _45) && ((seconds > 0) || (milliseconds > 0))){
            return true;
        }
        LOGGER.error("If this flow has been reached then the logic to calculate first half added time is incorrect");
        return false;
    }
}
