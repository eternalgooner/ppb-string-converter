package com.eternalgooner.matchperiodcalculations;

import com.eternalgooner.domain.FirstHalfMatchTime;
import com.eternalgooner.domain.MatchTime;
import com.eternalgooner.enums.OutputMatchPeriod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author David Mackessy
 * @date 27/09/2019
 **/

public class FirstHalfPeriodCalculation implements MatchPeriodCalculation {

    private MatchTime newMatchTime;
    private static final Logger LOGGER = LogManager.getLogger(FirstHalfPeriodCalculation.class.getName());

    @Override
    public String calculateOutputMatchTime(String matchTime) {
        LOGGER.debug("rounding milliseconds to check whether to add extra second or not");
        newMatchTime = new FirstHalfMatchTime(matchTime, OutputMatchPeriod.FIRST_HALF);
        return getOutputMatchFormat(newMatchTime);
    }

    private String getOutputMatchFormat(MatchTime matchTime) {
        incrementSecondsByOneIfApplicable();
        if(!matchTime.isHasAddedTime()){
            return String.format("%02d:%02d - %s", matchTime.getMinutes(), matchTime.getSeconds(), OutputMatchPeriod.FIRST_HALF);
        }else{
            return String.format("45:00 +%02d:%02d - %s",
                    matchTime.getAddedTime().getMinutes(),
                    matchTime.getAddedTime().getSeconds(),
                    OutputMatchPeriod.FIRST_HALF);
        }
    }

    private void incrementSecondsByOneIfApplicable() {
        int finalSecondsToUse = newMatchTime.getSeconds();
        if(newMatchTime.isHasExtraSecondFromRoundedMilliseconds()){
            newMatchTime.setSeconds(++finalSecondsToUse);
        }
    }
}
