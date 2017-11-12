package interfaces;

import java.util.List;

public interface ActorController {
	public void onUpdatedSensors(List<Sensor> sensors);
	public void changeActorState(int newValue);
}
