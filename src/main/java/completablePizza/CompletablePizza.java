package completablePizza;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class CompletablePizza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client name: (or type q to quit)");

        while (true) {
            String clientName = scanner.nextLine();
            if (clientName == null || clientName.trim().isEmpty()) {
                System.out.println("Error! Please enter a valid name!");
                continue;
            }
            if (clientName.equalsIgnoreCase("q")) {
                break;
            }

            CompletableFuture.supplyAsync(() -> {
                System.out.println("The kitchen is preparing " + clientName + "'s order.");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return clientName;
            }).thenAccept(client -> System.out.println("-> " + client + "'s order is out for delivery!"));
        }
    }
}
