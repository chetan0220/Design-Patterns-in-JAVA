import java.util.*;
import java.lang.System;

interface Subject{
	void subsribe(Observer ob);
	void unsubsribe(Observer ob);
	void notifyChanges();
}

class Channel implements Subject{
	List<Observer> subscribers = new ArrayList<Observer>();

	public void subsribe(Observer ob){
		subscribers.add(ob);
	}
	public void unsubsribe(Observer ob){
		subscribers.remove(ob);
	}
	public void notifyChanges(){
		for(Observer ob : subscribers){
			ob.notified();
		}
	}

}

interface Observer{
	void notified();
}

class Subscriber implements Observer{
	public void notified(){
		System.out.println("Subscriber notified");
	}
}

public class Main{
	public static void main(String[] args){
		Channel channel = new Channel();
		
		Subscriber aman = new Subscriber();
		Subscriber sanam = new Subscriber();

		channel.subsribe(aman);
		channel.subsribe(sanam);
		channel.notifyChanges();
	}
}


/*
Output: 
	
Subscriber notified
Subscriber notified
*/
