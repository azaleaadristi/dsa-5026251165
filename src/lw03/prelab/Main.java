package lw03.prelab;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        
        // ===== Problem 1 =====
        System.out.println("===== Problem 1 =====");
        List<String> playlist = new LinkedList<>();
        
        Scanner sc = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        while (sc.hasNext()) {
            String operasi = sc.next(); 
            
            if (operasi.equals("ADD")) {
                String lagu = sc.nextLine().trim(); 
                playlist.add(lagu);
            } 
            else if (operasi.equals("INSERT")) {
                int index = sc.nextInt();          
                String lagu = sc.nextLine().trim(); 
                playlist.add(index, lagu);
            } 
            else if (operasi.equals("REMOVE")) {
                String lagu = sc.nextLine().trim();
                playlist.remove(lagu); 
            }
        }
        sc.close(); 

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }


        // ===== Problem 2 =====
        System.out.println("\n===== Problem 2 =====");

        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;

        sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        while (sc.hasNextLine()) {
            String nama = sc.nextLine().trim();
            if (nama.isEmpty()) continue; 

            if (participants.contains(nama)) {
                duplicates++;
            } else {
                participants.add(nama);
            }
        }
        sc.close();

        System.out.println("Unique participants: " + participants.size());
        int nomor = 1;

        for (String nama : participants) {
            System.out.println(nomor + ". " + nama);
            nomor++;
        }
        System.out.println("Duplicate registrations: " + duplicates);


        // ===== Problem 3 =====
        System.out.println("\n===== Problem 3 =====");

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        sc = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while (sc.hasNext()) {
            String tipe = sc.next();    
            String produk = sc.next();  
            int jumlah = sc.nextInt(); 

            if (tipe.equals("ADD")) {
                if (inventory.containsKey(produk)) {
                    int stokLama = inventory.get(produk);
                    inventory.put(produk, stokLama + jumlah);
                } else {
                    inventory.put(produk, jumlah);
                }
            } 
            else if (tipe.equals("SELL")) {
                if (inventory.containsKey(produk)) {
                    int stokSekarang = inventory.get(produk);
                    
                    if (stokSekarang >= jumlah) {
                        inventory.put(produk, stokSekarang - jumlah);
                    } else {
                        failedSales++; 
                    }
                } else {
                    failedSales++; 
                }
            }
        }
        sc.close(); 

        for (String key : inventory.keySet()) {
            System.out.println(key + ": " + inventory.get(key));
        }
        System.out.println("Failed sales: " + failedSales);
    }
}