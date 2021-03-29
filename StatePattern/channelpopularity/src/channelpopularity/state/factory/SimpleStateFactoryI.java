package channelpopularity.state.factory;
import channelpopularity.state.StateName;
import channelpopularity.context.ChannelContext;
import channelpopularity.state.*;


public interface SimpleStateFactoryI {
    public StateI create(StateName stateName);
}
