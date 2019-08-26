
public class ArrayQueue implements Queue {

	protected int fDog = 0;
	protected int fCat = 0;
	protected int rDog = 0;
	protected int rCat = 0;

	public static final int CAPACITY = 1000;
	protected int capacity;
	private int lastId = 0;

	protected Dog dog[];
	protected Cat cat[];
	public ArrayQueue() {
		this(CAPACITY);
	}
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		dog = new Dog[this.capacity];
		cat = new Cat[this.capacity];
	}

	@Override
	public long size() {
		// TODO Auto-generated method stub
		return (sizeDog() + sizeCat());
	}
	
	private long sizeDog() {
		return (capacity-fDog+rDog)%capacity;
	}
	
	private long sizeCat() {
		return (capacity-fCat+rCat)%capacity;
	}

	@Override
	public boolean isEmpty() {
		if (isEmptyDog() && isEmptyCat()) {
			return true;
		}

		return false;
	}
	
	private boolean isEmptyDog() {
		return fDog == rDog;
	}

	private boolean isEmptyCat() {
		return fCat == rCat;
	}

	@Override
	public void enqueue(Raca e) {
		if (size() == capacity - 1) {
			throw new FullQueueException("A fila está cheia");
		}
		
		e.setId(lastId);
		if (e instanceof Dog) {
			dog[rDog] = (Dog) e;
			rDog = (rDog + 1)%capacity;
		} else {
			cat[rCat] = (Cat) e;
			rCat = (rCat + 1)%capacity;
		}
		lastId++;
	}

	@Override
	public Raca dequeueAny() {
		if (isEmpty()) {
			throw new EmptyQueueException("Não há elementos");
		}
		
		Raca temp;
		if (dog[fDog].getId() < cat[fCat].getId()) {
			temp = dog[fDog];
			dog[fDog] = null;
			fDog = (fDog + 1)%capacity;
		} else {
			temp = cat[fCat];
			cat[fCat] = null;
			fCat = (fCat + 1)%capacity;
		}

		return temp;
	}

	@Override
	public Dog dequeueDog() {
		if (isEmptyDog()) {
			throw new EmptyQueueException("Não há elementos");
		}

		Dog temp = dog[fDog];
		dog[fDog] = null;
		fDog = (fDog + 1)%capacity;
		return temp;
	}

	@Override
	public Cat dequeueCat() {
		if (isEmptyCat()) {
			throw new EmptyQueueException("Não há elementos");
		}

		Cat temp = cat[fCat];
		cat[fCat] = null;
		fCat = (fCat + 1)%capacity;
		return temp;
	}

	@Override
	public Raca front() {
		if (isEmpty()) {
			throw new EmptyQueueException("Não há elementos");
		}
		if (dog[fDog].getId() < cat[fCat].getId()) {
			return dog[fDog];
		} else {
			return cat[fCat];
		}
	}
}
