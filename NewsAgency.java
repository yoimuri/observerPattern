package observerPattern;
import java.util.ArrayList;
import java.util.List;

public class NewsAgency implements Subject {
    List<Observer> subscribers;
    private String news;

    public NewsAgency() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer subscriber : subscribers) {
            subscriber.update(news);
        }
    }

    public void publishNews(String news) {
        this.news = news;
        System.out.println("News Agency: New breaking news published!");
        notifyObservers();
    }
}