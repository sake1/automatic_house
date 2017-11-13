package abstracts;

import java.util.ArrayList;
import java.util.List;

import actors.AirConditioner;
import interfaces.Actor;
import interfaces.ActorController;
import interfaces.Sensor;

public abstract class AbstractActorController implements ActorController {

	private List<Actor> actors;
	
	public AbstractActorController() {
		actors = new ArrayList<Actor>();
	}
	
	public List<Actor> getActors() {
		return actors;
	}

	public void addActor(Actor a) {
		actors.add(a);
	}
	
	public abstract void onUpdatedSensors(List<Sensor> sensors);

	public void changeActorState(int newValue) {
		for(Actor a : getActors()) {
			((AbstractActor) a).getProperties().setValue(newValue);
		}
	}
}
