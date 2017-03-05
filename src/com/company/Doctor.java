package com.company;

/**
 * Created by Zakhar on 05.03.2017.
 */
class Doctor extends Human{
    private static final int TIME_IN = 1000;
    private Room room;

    public Doctor(Room room){
        super(TIME_IN);
        this.room = room;
    }

    @Override
    void enter() {
        room.entrance(this);
    }

    @Override
    void exit() {
        room.exit(this);
    }
}
