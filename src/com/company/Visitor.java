package com.company;

/**
 * Created by Zakhar on 05.03.2017.
 */
class Visitor extends Human{
    private static final int TIME_IN = 1000;
    private Room room;

    public Visitor(Room room){
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
