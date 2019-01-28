import java.util.ArrayList;

interface Subject {
	public void registerObserver(Observe o);
	public void removeObserver(Observe o);
	public void notifyAllObservers();
}

interface Observe {
	public void update(Subject s);
}

class VideoSite implements Subject {
	private ArrayList<Observe> userList;
	private ArrayList<String> videos;

	public VideoSite() {
		userList = new ArrayList<>();
		videos = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observe o) {
		userList.add(o);
	}

	@Override
	public void removeObserver(Observe o) {
		userList.remove(o);
	}

	@Override
	public void notifyAllObservers() {
		for (Observe o : userList) {
			o.update(this);
		}
	}

	public void addVideos(String video) {
		this.videos.add(video);
		notifyAllObservers();
	}

	public ArrayList<String> getVideos() {
		return videos;
	}

	public String toString() {
		return videos.toString();
	}
}

class VideoFan implements Observe {
	private String name;

	public VideoFan(String name) {
		this.name = name;
	}

	@Override
	public void update(Subject s) {
		System.out.println(this.name + ", new videos are available! ");
		System.out.println(s);
	}
}

public class Observer {
	public static void main(String[] args) {
		VideoSite vs = new VideoSite();
		vs.registerObserver(new VideoFan("Siri"));
		vs.registerObserver(new VideoFan("Alexa"));
		vs.registerObserver(new VideoFan("Cornor"));
		vs.addVideos("Big Bang Theories");
	}
}