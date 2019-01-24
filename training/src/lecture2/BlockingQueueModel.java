package lecture2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueModel implements Model {
 
	private final BlockingQueue<Task> queue;
	private final AtomicInteger increTaskNo = new AtomicInteger(0);

	public BlockingQueueModel(int cap) {
		this.queue = new LinkedBlockingQueue<>(cap);
	}

	@Override
	public Runnable newRunnableConsumer() {
		return new CustomerImpl();
	}

	@Override
	public Runnable newRunnableProducer() {
		return new ProducerImpl();
	}

	private class CustomerImpl extends AbstractConsumer implements Consumer, Runnable {
		@Override
		public void consume() throws InterruptedException {
			
			if (queue.size() == 0) {
				System.out.println("************");
			}
			Task task = queue.take();
			System.out.println(task.no);
			Thread.sleep(500 + (long) (Math.random() * 500));
			System.out.println("consume: " + task.no);
		}
	}

	private class ProducerImpl extends AbstractProducer implements Producer, Runnable {

		@Override
		public void produce() throws InterruptedException {
			Thread.sleep((long) (Math.random() * 1000));
			Task task = new Task(increTaskNo.getAndIncrement());
			queue.put(task);
			System.out.println("produce: " + task.no);
		}

	}

	public static void main(String[] args) {
		Model model = new BlockingQueueModel(3);
		for (int i = 0; i < 5; i++) {
			new Thread(model.newRunnableConsumer()).start();
		}
		for (int i = 0; i < 1; i++) {
			new Thread(model.newRunnableProducer()).start();
		}
	}
}