package search;

import exceptions.OperatorFailedException;

public interface Transitionable {
    public abstract State transition(State currentState) throws OperatorFailedException;
}