package model;

import java.util.ArrayList;
import java.util.List;

public class Camera {
    private final String name = "Камера";
    private boolean isOn;
    private CameraMovement movement;
    private List<Person> spectators;
    private List<Thing> thingsOnFrame;

    public Camera(boolean isOn, CameraMovement movement) {
        this.isOn = isOn;
        this.movement = movement;
        this.spectators = new ArrayList<>();
        this.thingsOnFrame = new ArrayList<>();
    }

    public void move(CameraMovementCharacteristic[] characteristics, CameraMovement movement) throws CameraException {

        if (this.isOn) {
            this.movement = movement;
            System.out.print("Камера " + movement.getStr());
           if(characteristics != null) {
               for (CameraMovementCharacteristic move: characteristics) {
                   System.out.print(" " + move.getStr());
               }
           }
            System.out.println();
            spectators.forEach(spectator -> {
                spectator.react(this);
            });
        } else
            throw new CameraException("Камера выключена");
    }

    public void zoom(CameraMovementCharacteristic[] characteristics) throws CameraException {
        move(characteristics, CameraMovement.ZOOM);
    }

    public void turn(CameraMovementCharacteristic[] characteristics) throws CameraException {
        move(characteristics, CameraMovement.TURN);
    }

    public void stopMove() throws CameraException {
        move(null, CameraMovement.NOT_MOVE);
    }

    public void clearSpectators () {
        spectators.forEach(spectator -> {
            System.out.println(spectator.getName() + " прекращает просмотр");
        });
        spectators.clear();
    }


    public void clearFrame() {
        thingsOnFrame.clear();
    }

    public int getNumberSpectators() {
        return spectators.size();
    }

    public int getNumberThingsOnFrame() {
        return thingsOnFrame.size();
    }

    public void addThingOnFrame(Thing thing) {
        thingsOnFrame.add(thing);
    }

    public void removeThingOnFrame(Thing thing) {
        thingsOnFrame.remove(thing);
    }


    public List<Person> getSpectators() {
        return spectators;
    }

    public void setSpectators(List<Person> spectators) {
        this.spectators = spectators;
    }

    public List<Thing> getThingsOnFrame() {
        return thingsOnFrame;
    }

    public void setThingsOnFrame(List<Thing> thingsOnFrame) {
        this.thingsOnFrame = thingsOnFrame;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getName() {
        return name;
    }

    public CameraMovement getMovement() {
        return movement;
    }

    public void setMovement(CameraMovement movement) {
        this.movement = movement;
    }

}
