package tf.nick.hypertrash.badHashTable;

import java.util.Scanner;

class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entries = Integer.parseInt(sc.nextLine().trim());
        HashTable<String> dict = new HashTable<>(5);
        for (int i = 0; i < entries; i++) {
            String[] kvp = sc.nextLine().trim().split("\\s+");
            dict.put(Integer.parseInt(kvp[0]), kvp[1]);
        }
        System.out.println(dict);
        System.out.println(dict.get(44));
        System.out.println(dict.get(13));
        System.out.println(dict.get(95));
    }
}
