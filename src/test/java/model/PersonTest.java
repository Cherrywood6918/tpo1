package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    private Person arthur;
    private Person professor;
    private Camera camera;
    private Thing controller;

    @BeforeEach
    void prepare() {
        arthur = new Person("Артур", PersonFeeling.NORMAL,true);
        professor = new Person("Умникум", PersonFeeling.NORMAL, false);
        camera = new Camera(false, CameraMovement.NOT_MOVE);
        controller = new Thing("Пульт");
    }

    @Test
    void ifTurnOnCameraWhenCameraIsOffThenCameraIsOn() throws CameraException {
        arthur.turnOnCamera(camera);
        assertTrue(camera.isOn());
    }

    @Test
    void ifTurnOffCameraWhenCameraIsOnThenCameraIsOff() throws CameraException {
        camera.setOn(true);
        arthur.turnOffCamera(camera);
        assertFalse(camera.isOn());
    }

    @Test
    void ifTurnOnCameraWhenCameraIsOnThenException() {
        camera.setOn(true);
        assertThrows(CameraException.class, () -> {
            arthur.turnOnCamera(camera);
        });
    }

    @Test
    void ifTurnOffCameraWhenCameraIsOffThenException()  {
        assertThrows(CameraException.class, () -> {
            arthur.turnOffCamera(camera);
        });
    }

    @Test
    void ifCameraIsOnThenPersonCanWatch() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        assertEquals(camera.getSpectators().get(0), arthur);
    }

    @Test
    void ifCameraIsOffThenPersonCantWatch() {
        assertThrows(CameraException.class, ()-> {
            arthur.watchFilm(camera);
        });
    }

    @Test
    void ifPersonStopWatchThenPersonIsNotSpectator() {
        arthur.stopWatch(camera);
        assertFalse(camera.getSpectators().contains(arthur));
    }

    @Test
    void reactionOnZoomCamera() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        professor.watchFilm(camera);
        camera.zoom(new CameraMovementCharacteristic[]{CameraMovementCharacteristic.SLOWLY, CameraMovementCharacteristic.STEADILY});
        assertEquals(PersonFeeling.HAIR_STARING, arthur.getFeeling());
        assertEquals(PersonFeeling.WIND_ON_BALD, professor.getFeeling());
    }

    @Test
    void reactionOnTurnCamera() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        professor.watchFilm(camera);
        camera.turn(new CameraMovementCharacteristic[]{CameraMovementCharacteristic.FAST, CameraMovementCharacteristic.CHAOTIC});
        assertEquals(PersonFeeling.DIZZINESS, arthur.getFeeling());
        assertEquals(PersonFeeling.DIZZINESS, professor.getFeeling());
    }

    @Test
    void reactionOnStopCamera() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        camera.zoom(null);
        camera.stopMove();
        assertEquals(PersonFeeling.NORMAL, arthur.getFeeling());
    }
}
