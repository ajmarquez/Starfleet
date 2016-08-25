package com.ninjarobot.abelardo.starshipfleet.utils.function;

/**
 * Created by ajmarquez on 22/08/16.
 */

@FunctionalInterface
public interface Consumer<T> {
    void consume(T t);
}
