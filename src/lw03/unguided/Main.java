package lw03.unguided;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Map<String, Integer> enroll = new LinkedHashMap<>();
        List<String> cekHasil = new LinkedList<>();
        
        int rejectedOperations = 0;

        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        
        while (sc.hasNext()) {
            String operation = sc.next(); 
            String course = sc.next();

            if (operation.equals("CHECK")) {
                if (enroll.containsKey(course)) {
                    cekHasil.add(course + ": " + enroll.get(course) + " students");
                } else {
                    cekHasil.add(course + ": Not found");
                }
            }
            
            else if (operation.equals("REGISTER")) {
                int count = sc.nextInt(); 
                
                if (count <= 0) {
                    rejectedOperations++;
                } else {
                    if (enroll.containsKey(course)) {
                        int currentStudents = enroll.get(course);
                        enroll.put(course, currentStudents + count);
                    } else {
                        enroll.put(course, count);
                    }
                }
            }

            else if (operation.equals("WITHDRAW")) {
                int count = sc.nextInt();
                
                if (count <= 0) {
                    rejectedOperations++;
                } else {
                    if (enroll.containsKey(course) && enroll.get(course) >= count) {
                        int currentStudents = enroll.get(course);
                        enroll.put(course, currentStudents - count);
                    } else {
                        rejectedOperations++;
                    }
                }
            }
        }
        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for (String result : cekHasil) {
            System.out.println(result);
        }

        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (String key : enroll.keySet()) {
            System.out.println(key + ": " + enroll.get(key) + " students");
        }
        
        System.out.println();
        System.out.println("Rejected operations: " + rejectedOperations);

    }
}
