package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.temporal.ChronoUnit;
import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class CameraTest {
    private Person arthur;
    private Person professor;
    private Camera camera;
    private Thing controller;
    private Thing computer;
    @BeforeEach
    void prepare() {
        arthur = new Person("Артур", PersonFeeling.NORMAL,true);
        professor = new Person("Умникум", PersonFeeling.NORMAL, false);
        camera = new Camera(false, CameraMovement.NOT_MOVE);
        controller = new Thing("Пульт");
        computer = new Thing("Компьютер");
    }

    @Test
    void zoomIsWorkIfCameraIsOn() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        camera.zoom(new CameraMovementCharacteristic[]{CameraMovementCharacteristic.SLOWLY, CameraMovementCharacteristic.STEADILY});
        assertEquals(CameraMovement.ZOOM, camera.getMovement());
    }

    @Test
    void turnIsWorkIfCameraIsOn() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        camera.turn(new CameraMovementCharacteristic[]{CameraMovementCharacteristic.FAST, CameraMovementCharacteristic.CHAOTIC});
        assertEquals(CameraMovement.TURN, camera.getMovement());
    }

    @Test
    void stopMoveIsWorkIfCameraIsOn() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        camera.turn(new CameraMovementCharacteristic[]{CameraMovementCharacteristic.FAST, CameraMovementCharacteristic.CHAOTIC});
        camera.stopMove();
        assertEquals(CameraMovement.NOT_MOVE, camera.getMovement());
    }

    @Test
    void IfCameraMoveAndCameraIsOffThenExceptionMove() {
        assertThrows(CameraException.class, ()->{
            camera.zoom(null);
        });
        assertThrows(CameraException.class, ()->{
            camera.turn(null);
        });
    }

    @Test
    void ifTurnOffCameraAllSpectatorsRemove() throws CameraException {
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        professor.watchFilm(camera);
        arthur.turnOffCamera(camera);
        assertTrue(camera.getSpectators().isEmpty());
    }

    @Test
    void NumberOfSpectatorsTest() throws CameraException {
        camera.getThingsOnFrame().add(controller);
        arthur.turnOnCamera(camera);
        arthur.watchFilm(camera);
        professor.watchFilm(camera);
        assertEquals(2, camera.getNumberSpectators());
    }

    @Test
    void NumberOfSpectatorsIsSpectatorsDontExistTest() throws CameraException {
        camera.getThingsOnFrame().add(controller);
        arthur.turnOnCamera(camera);
        assertEquals(0, camera.getNumberSpectators());
    }

    @Test
    void ifTurnOffCameraNotMove() throws CameraException {
        arthur.turnOnCamera(camera);
        camera.zoom(new CameraMovementCharacteristic[]{});
        arthur.turnOffCamera(camera);
        assertEquals(camera.getMovement(), CameraMovement.NOT_MOVE);
    }


    @Test
    void NumberOfThingsTest() {
        camera.addThingOnFrame(controller);
        camera.addThingOnFrame(computer);
        assertEquals(2, camera.getNumberThingsOnFrame());
    }

    @Test
    void RemoveThingsTest() {
        camera.getThingsOnFrame().add(controller);
        camera.getThingsOnFrame().add(computer);
        camera.removeThingOnFrame(computer);
        camera.removeThingOnFrame(controller);
        assertEquals(0, camera.getNumberThingsOnFrame());
    }
}
