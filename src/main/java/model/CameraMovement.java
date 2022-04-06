package model;

public enum CameraMovement {
    ZOOM("приближается"),
    TURN("поворачивает"),
    NOT_MOVE("не двигается");

    private String str;
    CameraMovement(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
