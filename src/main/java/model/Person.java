package model;

public class Person {
    private String name;
    private PersonFeeling feeling;
    private boolean isHair;

    public Person(String name, PersonFeeling feeling, boolean isHair) {
        this.name = name;
        this.feeling = feeling;
        this.isHair = isHair;
    }

    public void turnOnCamera(Camera camera) throws CameraException {
        if (!camera.isOn()) {
            camera.setOn(true);
            System.out.println(this.name + " включил " + camera.getName());
        } else
            throw new CameraException("Камера уже включена");
    }

    public void turnOffCamera(Camera camera) throws CameraException {
        if (camera.isOn()) {
            camera.setOn(false);
            System.out.println(this.name + " выключил " + camera.getName());
            camera.clearSpectators();
            camera.clearFrame();
            camera.setMovement(CameraMovement.NOT_MOVE);
        } else
            throw new CameraException("Камера уже выключена");
    }

    public void watchFilm(Camera camera) throws CameraException {
        if (camera.isOn()) {
            camera.getSpectators().add(this);
            System.out.println(this.name + " смотрит пленку");
            camera.getThingsOnFrame().forEach(thing -> {
                System.out.println(this.name + " видит " + thing.getName());
            });
        } else
            throw new CameraException("Камера выключена");
    }

    public void stopWatch(Camera camera) {
        camera.getSpectators().remove(this);
        System.out.println(this.name + " прекращает просмотр");
    }

    public void react(Camera camera) {
        switch (camera.getMovement()) {
            case ZOOM:
                if(this.isHair)
                    this.feeling = PersonFeeling.HAIR_STARING;
                else
                    this.feeling = PersonFeeling.WIND_ON_BALD;
                break;
            case TURN:
                    this.feeling = PersonFeeling.DIZZINESS;
                break;
            case NOT_MOVE:
            default:
                this.feeling = PersonFeeling.NORMAL;
        }
        System.out.println(this.name + " чувствует " + this.feeling.getStr());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHair() {
        return isHair;
    }

    public void setHair(boolean hair) {
        isHair = hair;
    }

    public PersonFeeling getFeeling() {
        return feeling;
    }

    public void setFeeling(PersonFeeling feeling) {
        this.feeling = feeling;
    }

}
