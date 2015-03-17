package com.wave.state;


public interface StateDao {

    public StateData getStateData(Long id);
    public void saveStateData(StateData itemData);
}
