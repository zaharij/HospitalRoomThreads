package com.company;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Zakhar on 05.03.2017.
 */
public class Display implements Observer {
    private final static String DOCTORS_DISPLAY = "Doctors: ";
    private final static String VISITORS_DISPLAY = "Visitors: ";
    private Room room;

    public Display(Room room){
        this.room = room;
        room.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        synchronized (room) {
            if (room.getHumansInRoom().size() != 0){
                if (room.getHumansInRoom().get(0) instanceof Doctor){
                    System.out.println(DOCTORS_DISPLAY + room.getHumansInRoom().size());
                } else if (room.getHumansInRoom().get(0) instanceof Visitor){
                    System.out.println(VISITORS_DISPLAY + room.getHumansInRoom().size());
                }
            }
        }
    }
}
