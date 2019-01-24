package lecture2;
public interface Model {
  Runnable newRunnableConsumer();
  Runnable newRunnableProducer();
}