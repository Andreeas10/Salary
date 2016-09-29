package salariu.pub_sub;

public interface IPublisher {
	public void subscribe(ISubscriber subscriber);

	public void unsubscribe(ISubscriber subscriber);

}
