package main;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import singleton.OrderManager;
import factory.*;
import decorator.*;
import adapter.*;
import proxy.*;
import state.Order;
import mediator.*;


public class RestaurantApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<OrderItem> currentOrder = new ArrayList<>();
    private static boolean isVIP = false;

    private static final Set<String> VALID_DRINK_TYPES = new HashSet<>();
    private static final Set<String> VALID_PIZZA_TYPES = new HashSet<>();
    private static final Set<String> VALID_BURGER_TYPES = new HashSet<>();
    private static final Set<String> VALID_SALAD_TYPES = new HashSet<>();


    static {
        VALID_DRINK_TYPES.add("cola");
        VALID_DRINK_TYPES.add("juice");
        VALID_DRINK_TYPES.add("water");
        VALID_DRINK_TYPES.add("coffee");

        VALID_PIZZA_TYPES.add("margherita");
        VALID_PIZZA_TYPES.add("pepperoni");
        VALID_PIZZA_TYPES.add("vegetarian");

        VALID_BURGER_TYPES.add("classic");
        VALID_BURGER_TYPES.add("cheese");
        VALID_BURGER_TYPES.add("deluxe");

        VALID_SALAD_TYPES.add("caesar");
        VALID_SALAD_TYPES.add("greek");
        VALID_SALAD_TYPES.add("garden");
    }

    public static void main(String[] args) {
        System.out.println("=== SELAMAT DATANG DI SISTEM MANAJEMEN RESTORAN ===");

        while (true) {
            displayMainMenu(); 
            int choice = scanner.nextInt(); 
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    viewOrderStatus();
                    break;
                case 4:
                    setVIPStatus(); 
                    break;
                case 5:
                    demonstrateMediator(); 
                    break;
                case 6:
                    System.out.println("Terima kasih telah berkunjung!"); 
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi."); 
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Lihat Menu");
        System.out.println("2. Buat Pesanan");
        System.out.println("3. Lihat Status Pesanan");
        System.out.println("4. Atur Status VIP");
        System.out.println("5. Demonstrasikan Operasi Restoran");
        System.out.println("6. Keluar");
        System.out.print("Masukkan pilihan Anda: ");
    }

   
    private static void viewMenu() {
        MenuProxy menuProxy = new MenuProxy(isVIP);
        menuProxy.displayMenu();

        if (isVIP) {
            System.out.print("\nLihat menu VIP? (y/n): ");
            String vipChoice;
            while (true) {
                vipChoice = scanner.nextLine().trim().toLowerCase();
                if (vipChoice.equals("y") || vipChoice.equals("n")) {
                    break;
                } else {
                    System.out.print("Pilihan tidak valid. Masukkan 'y' atau 'n': ");
                }
            }

            if (vipChoice.equals("y")) {
                menuProxy.displaySpecialMenu();
            }
        }
    }

    private static void createOrder() {
        currentOrder.clear(); 
        boolean ordering = true; 

        while (ordering) {
            System.out.println("\n=== BUAT PESANAN ===");
            System.out.println("1. Tambah Pizza");
            System.out.println("2. Tambah Burger");
            System.out.println("3. Tambah Salad");
            System.out.println("4. Tambah Minuman");
            if (isVIP) {
                System.out.println("5. Tambah Item VIP");
                System.out.println("6. Lihat Pesanan Saat Ini");
                System.out.println("7. Checkout");
                System.out.println("8. Batalkan Pesanan");
                System.out.print("Masukkan pilihan Anda: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addMenuItem("pizza");
                        break;
                    case 2:
                        addMenuItem("burger");
                        break;
                    case 3:
                        addMenuItem("salad");
                        break;
                    case 4:
                        addMenuItem("drink");
                        break;
                    case 5:
                        addMenuItem("vip");
                        break;
                    case 6:
                        viewCurrentOrder();
                        break;
                    case 7:
                        if (checkout()) {
                            ordering = false;
                        }
                        break;
                    case 8:
                        currentOrder.clear();
                        System.out.println("Pesanan dibatalkan.");
                        ordering = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } else { 
                System.out.println("5. Lihat Pesanan Saat Ini");
                System.out.println("6. Checkout");
                System.out.println("7. Batalkan Pesanan");
                System.out.print("Masukkan pilihan Anda: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); 

                switch (choice) {
                    case 1:
                        addMenuItem("pizza");
                        break;
                    case 2:
                        addMenuItem("burger");
                        break;
                    case 3:
                        addMenuItem("salad");
                        break;
                    case 4:
                        addMenuItem("drink");
                        break;
                    case 5:
                        viewCurrentOrder();
                        break;
                    case 6:
                        if (checkout()) {
                            ordering = false;
                        }
                        break;
                    case 7:
                        currentOrder.clear();
                        System.out.println("Pesanan dibatalkan.");
                        ordering = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            }
        }
    }

    private static void addMenuItem(String category) {
        int type;
        String scan;
        if (category.equalsIgnoreCase("vip")) {
            System.out.println("--- PILIH ITEM VIP ---");
            System.out.println("1. Wagyu Steak Rp.300.000");
            System.out.println("2. Lobster Thermidor Rp.350.000");
            System.out.println("3. Truffle Pasta Rp.120.000");
            System.out.println("4. Vintage Wine Selection Rp.500.000");
            System.out.print("Masukkan tipe item VIP: ");
            type = scanner.nextInt();
            scanner.nextLine();
            
            String description;
            double cost;

            switch (type) {
                case 1:
                    description = "Wagyu Steak";
                    cost = 300.000;
                    break;
                case 2:
                    description = "Lobster Thermidor";
                    cost = 350.000;
                    break;
                case 3:
                    description = "Truffle Pasta";
                    cost = 120.000;
                    break;
                case 4:
                    description = "Vintage Wine Selection";
                    cost = 500.000; 
                    break;
                default:
                    System.out.println("Error: Tipe item VIP tidak dikenal.");
                    return;
            }
            OrderItem vipOrderItem = new SimpleOrder(description, cost);
            currentOrder.add(vipOrderItem);
            System.out.println("Ditambahkan: " + vipOrderItem.getDescription() + " - Rp." + String.format("%.3f", vipOrderItem.getCost()));
            return; 
        }

        if (category.equalsIgnoreCase("drink")) {
            System.out.print("Masukkan tipe minuman (cola, juice, water, coffee): ");
            while (true) {
                scan = scanner.nextLine().trim().toLowerCase();
                if (VALID_DRINK_TYPES.contains(scan)) {
                    break;
                } else {
                    System.out.print("Tipe minuman tidak valid. Masukkan (cola, juice, water, coffee): ");
                }
            }
            MenuItem item = MenuItemFactory.createMenuItem(category, scan);
            OrderItem orderItem = new BaseMenuItem(item);
            currentOrder.add(orderItem);
            System.out.println("Ditambahkan: " + orderItem.getDescription() + " - Rp." + String.format("%.3f", orderItem.getCost()));
            return; 
        }

        System.out.print("Masukkan tipe (");
        Set<String> currentValidTypes;
        switch (category.toLowerCase()) {
            case "pizza":
                currentValidTypes = VALID_PIZZA_TYPES;
                System.out.print("margherita, pepperoni, vegetarian): ");
                break;
            case "burger":
                currentValidTypes = VALID_BURGER_TYPES;
                System.out.print("classic, cheese, deluxe): ");
                break;
            case "salad":
                currentValidTypes = VALID_SALAD_TYPES;
                System.out.print("caesar, greek, garden): ");
                break;
            default:
                System.out.println("Kategori tidak dikenal untuk validasi.");
                return;
        }

        while (true) {
            scan = scanner.nextLine().trim().toLowerCase();
            if (currentValidTypes.contains(scan)) {
                break;
            } else {
                System.out.print("Tipe " + category + " tidak valid. Masukkan salah satu dari (" + String.join(", ", currentValidTypes) + "): ");
            }
        }
        
        try {
            MenuItem item = MenuItemFactory.createMenuItem(category, scan);
            OrderItem orderItem = new BaseMenuItem(item);

            String response;

            System.out.print("Tambahkan keju ekstra? (y/n): ");
            while (true) {
                response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("y") || response.equals("n")) {
                    break;
                } else {
                    System.out.print("Pilihan tidak valid. Masukkan 'y' atau 'n': ");
                }
            }
            if (response.equals("y")) {
                orderItem = new ExtraCheeseDecorator(orderItem);
            }

            System.out.print("Tambahkan saus spesial? (y/n): ");
            while (true) {
                response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("y") || response.equals("n")) {
                    break;
                } else {
                    System.out.print("Pilihan tidak valid. Masukkan 'y' atau 'n': ");
                }
            }
            if (response.equals("y")) {
                orderItem = new SpecialSauceDecorator(orderItem);
            }

            System.out.print("Buat ukuran ekstra besar? (y/n): ");
            while (true) {
                response = scanner.nextLine().trim().toLowerCase();
                if (response.equals("y") || response.equals("n")) {
                    break;
                } else {
                    System.out.print("Pilihan tidak valid. Masukkan 'y' atau 'n': ");
                }
            }
            if (response.equals("y")) {
                orderItem = new ExtraLargeDecorator(orderItem);
            }

            currentOrder.add(orderItem);
            System.out.println("Ditambahkan: " + orderItem.getDescription() + " - Rp." + String.format("%.3f", orderItem.getCost()));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewCurrentOrder() {
        if (currentOrder.isEmpty()) {
            System.out.println("Pesanan Anda kosong.");
            return;
        }

        System.out.println("\n=== PESANAN SAAT INI ===");
        double total = 0;
        for (OrderItem item : currentOrder) {
            System.out.println("- " + item.getDescription() + ": Rp." + String.format("%.3f", item.getCost()));
            total += item.getCost();
        }
        System.out.println("Total: Rp." + String.format("%.3f", total));
    }

    private static boolean checkout() {
        if (currentOrder.isEmpty()) {
            System.out.println("Pesanan Anda kosong. Tambahkan item terlebih dahulu.");
            return false;
        }

        viewCurrentOrder();
        StringBuilder orderDesc = new StringBuilder();
        double total = 0;
        for (OrderItem item : currentOrder) {
            if (orderDesc.length() > 0) orderDesc.append(", ");
            orderDesc.append(item.getDescription());
            total += item.getCost();
        }

        int orderId = OrderManager.getInstance().placeOrder(orderDesc.toString());

        System.out.println("\n=== PEMBAYARAN ===");
        System.out.println("1. PayPal");
        System.out.println("2. Gopay");
        System.out.print("Pilih metode pembayaran: ");

        int paymentChoice = scanner.nextInt();
        scanner.nextLine(); 

        PaymentProcessor payment;
        if (paymentChoice == 1) {
            payment = new PayPalAdapter(); 
        } else if (paymentChoice == 2) {
            payment = new GopayAdapter(); 
        } else {
            System.out.println("Pilihan pembayaran tidak valid.");
            return false;
        }

        boolean paymentSuccess = payment.pay(total); 

        if (paymentSuccess) {
            System.out.println("Pembayaran berhasil menggunakan " + payment.getPaymentMethod());

            Order order = new Order(orderId);
            System.out.println(order.getStatus());
            order.next();
            System.out.println(order.getStatus());
            order.next();
            System.out.println(order.getStatus());
            order.next(); 
            System.out.println(order.getStatus());

            currentOrder.clear(); 
            return true;
        } else {
            System.out.println("Pembayaran gagal. Silakan coba lagi.");
            return false;
        }
    }

    private static void viewOrderStatus() {
        List<String> orders = OrderManager.getInstance().getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("Tidak ada pesanan ditemukan.");
        } else {
            System.out.println("\n=== SEMUA PESANAN ===");
            for (String order : orders) {
                System.out.println(order);
            }
        }
    }

    private static void setVIPStatus() {
        System.out.print("Apakah Anda anggota VIP? (y/n): ");
        String vipStatusChoice;
        while (true) {
            vipStatusChoice = scanner.nextLine().trim().toLowerCase();
            if (vipStatusChoice.equals("y") || vipStatusChoice.equals("n")) {
                break;
            } else {
                System.out.print("Pilihan tidak valid. Masukkan 'y' atau 'n': ");
                }
        }
        isVIP = vipStatusChoice.equals("y");
        System.out.println("Status VIP diatur ke: " + isVIP);
    }

    private static void demonstrateMediator() {
        System.out.println("\n=== DEMO OPERASI RESTORAN ===");

        Kitchen kitchen = new Kitchen();
        Waiter waiter = new Waiter();
        PaymentDesk paymentDesk = new PaymentDesk();

        RestaurantMediator mediator = new RestaurantMediatorImpl(kitchen, waiter, paymentDesk);

        kitchen.setMediator(mediator);
        waiter.setMediator(mediator);
        paymentDesk.setMediator(mediator);

        waiter.takeOrder();
        System.out.println("---");
        paymentDesk.processPayment();
    }
}
