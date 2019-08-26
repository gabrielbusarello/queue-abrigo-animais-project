
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ArrayQueueTests {
	
	@Test
	public void isEmpty() {	
		ArrayQueue queue = new ArrayQueue();
		assertEquals("A fila deve estar vazia",true,queue.isEmpty());
	}
	
	@Test
	public void size() {
		ArrayQueue queue = new ArrayQueue();
		assertEquals("O tamanho da fila deve ser zero",0,queue.size());
	}
	
	@Test
	public void enqueue() {
		Dog dog = new Dog();
		dog.setNome("Filisbino");
		Cat cat = new Cat();
		cat.setNome("Pimpona");

		ArrayQueue queue = new ArrayQueue();
		queue.enqueue(dog);
		queue.enqueue(cat);

		assertEquals("Fila deve conter um elemento",2,queue.size());
	}
	
	@Test
	public void front() {
		Dog dog = new Dog();
		dog.setNome("Filisbino");
		Cat cat = new Cat();
		cat.setNome("Pimpona");

		Dog dog1 = new Dog();
		dog1.setNome("Filisbina");
		Cat cat1 = new Cat();
		cat1.setNome("Pimp�o");

		ArrayQueue queue = new ArrayQueue();
		queue.enqueue(dog);
		queue.enqueue(cat);
		queue.enqueue(dog1);
		queue.enqueue(cat1);

		assertEquals("Front deve retornar o elemento Filisbino","Filisbino",queue.front().getNome());
	}
	
	@Test
	public void dequeueAny() {
		Dog dog = new Dog();
		dog.setNome("Filisbino");
		Cat cat = new Cat();
		cat.setNome("Pimpona");

		ArrayQueue queue = new ArrayQueue();
		queue.enqueue(dog);
		queue.enqueue(cat);

		assertEquals("Front deve retornar o elemento Filisbino","Filisbino", queue.dequeueAny().getNome());
		assertEquals("Fila deve conter um elemento",1,queue.size());
	}
	
	@Test
	public void dequeueThrowsException() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		try {
			queue.dequeue();
			fail("Fila deve gerar exceçao EmptyQueueException");
		}catch(EmptyQueueException ignored) {
		}
	}
	
	@Test
	public void frontThrowsException() {
		Queue<Integer> queue = new ArrayQueue<Integer>();
		try {
			queue.front();
			fail("Fila deve gerar exceçao EmptyQueueException");
		}catch(EmptyQueueException ignored) {
		}
	}
	
	@Test
	public void enqueueThrowsException() {
		Queue<Integer> queue = new ArrayQueue<Integer>(1);
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			fail("Fila deve gerar exceçao FullQueueException");
		}catch(FullQueueException ignored) {
		}
	}

}
