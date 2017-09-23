package com.theironyard.eventlog;

import java.util.ArrayList;
import java.util.List;

public class EventLog {
    private List<Event> eventList;

    public EventLog () {
        //which initializes the list
        this.eventList = new ArrayList<>();
    }

    public boolean addEvent(Event event) {
        if (event == null ||
                event.getAction() == null ||
                event.getName() == null) {
            throw new IllegalArgumentException("Event is not fully formed");
        }

//        switch(event.getAction()) {
//            case "Face2Face":
//            case "PhoneCall":
//            case "TextMessaging":
//            case "Unknown":
//                break;
//            default:
//                throw new IllegalArgumentException("Event action is invalid.");
//        }

        String action = event.getAction();

        if (!(action.equals("Face2Face") ||
                action.equals("PhoneCall") ||
                action.equals("TextMessaging") ||
                action.equals("Unknown"))) {
            throw new IllegalArgumentException("Event Action is invalid");
        }

        System.out.println(event);
        eventList.add(event);
        return true;
    }

    public int getNumEvents () {
        return eventList.size();
    }


}
