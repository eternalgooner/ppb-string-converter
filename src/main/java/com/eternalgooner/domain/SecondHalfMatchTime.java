package com.eternalgooner.domain;

import com.eternalgooner.enums.OutputMatchPeriod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 29/09/2019
 **/

public class SecondHalfMatchTime extends MatchTime {

    public static final int _90 = 90;
    private static final Logger LOGGER = LogManager.getLogger(SecondHalfMatchTime.class.getName());

    public SecondHalfMatchTime(String inputMatchTime, OutputMatchPeriod matchPeriod) {
        super(inputMatchTime, matchPeriod);
    }

    @Override
    protected void calculateAddedTime() {
        if(addedTimeApplies()){
            int addedMinutes = minutes - _90;
            if(hasExtraSecondFromRoundedMilliseconds){
                ++seconds;
            }
            addedTime = new AddedTime(addedMinutes, seconds);
        }
    }

    @Override
    protected boolean addedTimeApplies() {
        if(minutes < _90){
            return false;
        }else if(minutes > _90){
            return true;
        }else if((minutes == _90) && ((seconds > 0) || (milliseconds > 0))){
            return true;
        }
        LOGGER.error("If this flow has been reached then the logic to calculate second half added time is incorrect");
        return false;
    }
}
