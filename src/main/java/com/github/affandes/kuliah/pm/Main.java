package com.github.affandes.kuliah.pm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final ArrayList<String> history;

    public Main() {
        history = new ArrayList<>();
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong");
        } else {
            System.out.println("History Browser (dari paling baru):");
            for (int i = history.size() - 1; i >= 0; i--) {
                System.out.println((history.size() - i) + ". " + history.get(i));
            }
        }
    }

    public void browse(String website) {
        history.add(website);
        System.out.println("Website '" + website + "' telah ditambahkan ke history.");
    }

    public void back() {
        if (!history.isEmpty()) {
            String removeWebsite = history.remove(history.size() - 1);
            System.out.println("Kembali dari website: " + removeWebsite);
        } else {
            System.out.println("Tidak ada history untuk kembali.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main browserHistory = new Main();
        String command;

        System.out.println("Simulasi history browser");
        System.out.println("Perintah: view, browse <website>, back, exit");

        while (true) {
            System.out.println("Masukkan perintah: ");
            command = scanner.nextLine();

            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("view")) {
                browserHistory.view();
            } else if (command.startsWith("browse")) {
                if (command.length() > 7) {
                    String website = command.substring(7).trim();
                    browserHistory.browse(website);
                } else {
                    System.out.println("Website tidak valid. Silahkan coba lagi.");
                }
            } else if (command.equalsIgnoreCase("back")) {
                browserHistory.back();
            } else {
                System.out.println("Perintah tidak dikenali. Silahkan coba lagi");
            }
        }
        scanner.close();
        System.out.println("Program selsai");
    }
}
