import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<List<Integer>> petrolpumps = new ArrayList<>();
        petrolpumps.add(List.of(1, 5));
        petrolpumps.add(List.of(10, 3));
        petrolpumps.add(List.of(3, 4));
        System.out.println(truckTour(petrolpumps));
    }

    public static int truckTour(List<List<Integer>> petrolpumps) {
        // Write your code here
        for (int i = 0; i < petrolpumps.size(); i++) {
            int petrol = petrolpumps.get(i).get(0);
            int nextDistance = petrolpumps.get(i).get(1);

            int next = (i + 1) % petrolpumps.size();

            int sum = petrol;
            int k = 0;
            while (k < petrolpumps.size() - 1 && sum > nextDistance) {
                sum -= nextDistance;

                petrol = petrolpumps.get(next).get(0);
                nextDistance = petrolpumps.get(next).get(1);

                sum += petrol;

                next = (next + 1) % petrolpumps.size();
                
                k++;            
            }
            if (k == petrolpumps.size() - 1) {
                return i;
            }
        }
        return -1;
    }

    /*
    public static int truckTour(List<List<Integer>> petrolpumps) {
        List<List<Integer>> list = new ArrayList<>(petrolpumps);
        bestSelection(list);
        // Write your code here
        for (int i = 0; i < list.size(); i++) {
            int petrol = petrolpumps.get(i).get(0);
            int nextDistance = petrolpumps.get(i).get(1);

            int next = (i + 1) % petrolpumps.size();

            int sum = petrol;
            int k = 0;
            while (k < petrolpumps.size() - 1 && sum > nextDistance) {
                sum -= nextDistance;

                petrol = petrolpumps.get(next).get(0);
                nextDistance = petrolpumps.get(next).get(1);

                sum += petrol;

                next = (next + 1) % petrolpumps.size();
                
                k++;            
            }
            if (k == petrolpumps.size() - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void bestSelection(List<List<Integer>> petrolpumps) {
        Collections.sort(petrolpumps, new Comparator<List<Integer>>() {

            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                // TODO Auto-generated method stub
                return o2.get(0) - o1.get(0);
            }            
        });
    }
    */
}