package channelpopularity.state.factory;
//import channelpopularity.state.AbstractState;
//import channelpopularity.state.StateName;
import channelpopularity.context.ChannelContext;

import channelpopularity.state.*;
//import channelpopularity.state.MILDLY_POPULAR;
//import channelpopularity.state.Highly_Popular;
//import channelpopularity.state.UnPopular;


public class SimpleStateFactory implements SimpleStateFactoryI {
    StateI currentState;
    @Override
    public StateI create(StateName stateName)
    {
        if(stateName.equals(StateName.UNPOPULAR))
        {
           UnPopular currentState = new UnPopular();
            //return new UnPopular();
        }

        else if(stateName.equals(StateName.MILDLY_POPULAR))
        {
            MildlyPopular currentState = new MildlyPopular();
            //return  new MildlyPopular();
        }

       else  if(stateName.equals(StateName.HIGHLY_POPULAR))
        {
            HighlyPopular currentState = new HighlyPopular();
            //return  new HighlyPopular();

        }

       /*else if(stateName.equals(StateName.ULTRA_POPULAR))
        {
            return new UltraPopular();
        }*/


      return currentState;
    }

}
