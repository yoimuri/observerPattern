package observerPattern;

import java.util.Scanner;

public class NewsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NewsAgency newsAgency = new NewsAgency();

        while (true) {
            System.out.println("\n*** News Subscription Service ***");
            System.out.println("1. Subscribe to the news service");
            System.out.println("2. Unsubscribe from the news service");
            System.out.println("3. Publish breaking news");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter your name to subscribe: ");
                    String subscribeName = scanner.nextLine();
                    Subscriber newSubscriber = new Subscriber(subscribeName);
                    newsAgency.subscribe(newSubscriber);
                    System.out.println(subscribeName + " has subscribed to the news service.");
                    break;

                case 2:
                    System.out.print("Enter your name to unsubscribe: ");
                    String unsubscribeName = scanner.nextLine();
                    boolean found = false;
                    for (Observer subscriber : newsAgency.subscribers) {
                        if (((Subscriber) subscriber).getName().equalsIgnoreCase(unsubscribeName)) {
                            newsAgency.unsubscribe(subscriber);
                            System.out.println(unsubscribeName + " has unsubscribed from the news service.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Subscriber with name " + unsubscribeName + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the news to publish: ");
                    String news = scanner.nextLine();
                    newsAgency.publishNews(news);
                    break;

                case 4:
                    System.out.println("Exiting the news service.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}