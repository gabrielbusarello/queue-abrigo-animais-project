
public interface Queue {
	
	long size();
	boolean isEmpty();
	void enqueue(Raca e);
	Raca dequeueAny();
	Dog dequeueDog();
	Cat dequeueCat();
	Raca front();

}
