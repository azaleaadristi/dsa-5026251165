package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> transaksi = new LinkedList<>();
        LinkedList<String[]> nasabah = new LinkedList<>();
        Queue<String[]> antrean = new LinkedList<>();
        Stack<String[]> gagal = new Stack<>();

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transactions.txt"));
        
        while (sc.hasNext()) {
            String nama = sc.next();
            String jenis = sc.next();
            String jumlah = sc.next();
            transaksi.add(new String[]{nama, jenis, jumlah});
        }
        sc.close(); 
   
        for (int i = 0; i < transaksi.size(); i++) {
            String nama = transaksi.get(i)[0];
            boolean sudahAda = false;
            
            for (int j = 0; j < nasabah.size(); j++) {
                if (nasabah.get(j)[0].equals(nama)) {
                    sudahAda = true;
                    break;
                }
            }
            
            if (!sudahAda) {
                nasabah.add(new String[]{nama, "0"});
            }
        }

    
        for (int i = 0; i < transaksi.size(); i++) {
            antrean.add(transaksi.get(i));
        }

        while (!antrean.isEmpty()) {
            String[] t = antrean.poll();
            String nama = t[0];
            String jenis = t[1];
            int jumlah = Integer.parseInt(t[2]);

            
            int index = -1;
            for (int j = 0; j < nasabah.size(); j++) {
                if (nasabah.get(j)[0].equals(nama)) {
                    index = j;
                    break;
                }
            }

            int saldo = Integer.parseInt(nasabah.get(index)[1]);

            if (jenis.equals("DEPOSIT")) {
                saldo = saldo + jumlah;
                nasabah.get(index)[1] = String.valueOf(saldo);
            } else if (jenis.equals("WITHDRAW")) {
                if (jumlah > saldo) {
                    gagal.push(t);
                } else {
                    saldo = saldo - jumlah;
                    nasabah.get(index)[1] = String.valueOf(saldo);
                }
            }
        }

 
        System.out.println("=== Final Balances ===");
        for (int i = 0; i < nasabah.size(); i++) {
            System.out.println(nasabah.get(i)[0] + ": " + nasabah.get(i)[1]);
        }

        System.out.println("=== Failed Transactions ===");
        while (!gagal.isEmpty()) {
            String[] t = gagal.pop();
            System.out.println(t[0] + " " + t[1] + " " + t[2]);
        }
    }
}