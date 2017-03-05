package com.company;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by Zakhar on 05.03.2017.
 */
class Room extends Observable{
    private ArrayList<Human> humansInRoom = new ArrayList<>();
    private static final int MAX_DOCTORS = 1;
    private static final int MAX_VISITORS = 4;

    public synchronized void notifyDisplay(){
        setChanged();
        notifyObservers();
    }

    public ArrayList<Human> getHumansInRoom() {
        return humansInRoom;
    }

    public synchronized void entrance(Human human){
        if (human instanceof Doctor){
            if (humansInRoom.size() <= 0 || (humansInRoom.size() < MAX_DOCTORS && humansInRoom.get(0) instanceof Doctor)){
                humansInRoom.add(human);
                notifyDisplay();
            }
        } else if (human instanceof Visitor){
            if (humansInRoom.size() <= 0 || (humansInRoom.size() < MAX_VISITORS && humansInRoom.get(0) instanceof Visitor)){
                humansInRoom.add(human);
                notifyDisplay();
            }
        }
    }

    public void exit(Human human){
        humansInRoom.remove(human);
        notifyDisplay();
    }
}
