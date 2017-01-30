package iut.myfirstapp.model;

import java.util.ArrayList;

/**
 * Created by amanda on 30/01/2017.
 */

public class MessageObject {
    long timeStamp;

    public CityObject getCity() {
        return city;
    }

    public void setCity(CityObject city) {
        this.city = city;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ArrayList<IaqiObject> getIaqui() {
        return iaqui;
    }

    public void setIaqui(ArrayList<IaqiObject> iaqui) {
        this.iaqui = iaqui;
    }

    CityObject city;
    ArrayList<IaqiObject> iaqui;
}
