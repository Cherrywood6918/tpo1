package model;

public enum CameraMovementCharacteristic {
    SLOWLY("медленно"),
    FAST("быстро"),
    CHAOTIC("хаотично"),
    STEADILY("неуклонно");

    private String str;
    CameraMovementCharacteristic(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}
