package com.pluralsight.sneakerdrops;

import com.pluralsight.sneakerdrops.data.BrandRepository;
import com.pluralsight.sneakerdrops.data.SneakerRepository;
import com.pluralsight.sneakerdrops.models.Brand;
import com.pluralsight.sneakerdrops.models.Sneaker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StartupRunner implements CommandLineRunner {

    private BrandRepository brandRepository;
    private SneakerRepository sneakerRepository;

    public StartupRunner(BrandRepository brandRepository, SneakerRepository sneakerRepository) {
        this.brandRepository = brandRepository;
        this.sneakerRepository = sneakerRepository;
    }

    @Override
    public void run(String... args) {
        seedData();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1) List all sneakers");
            System.out.println("0) Quit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> listSneakers();
                case 0 -> running = false;
                default -> System.out.println("Invalid option.");
            }
        }

        System.out.println("Goodbye!");
    }

    private void seedData() {
        if (brandRepository.count() == 0) {
            brandRepository.save(new Brand("Nike"));
            brandRepository.save(new Brand("Adidas"));
            brandRepository.save(new Brand("New Balance"));
        }

        if (sneakerRepository.count() == 0) {
            sneakerRepository.save(new Sneaker("Air Force 1", 110.00, 1982));
            sneakerRepository.save(new Sneaker("Stan Smith", 85.00, 1973));
            sneakerRepository.save(new Sneaker("990v5", 175.00, 2019));
        }
    }

    private void listSneakers() {
        System.out.println("\nTotal sneakers: " + sneakerRepository.count());
        for (Sneaker s : sneakerRepository.findAll()) {
            System.out.println(s);
        }
    }
}