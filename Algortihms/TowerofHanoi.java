import java.util.Scanner;

public class TowerofHanoi {

	   public void solve(int n, String start, String auxiliary, String end) {
	       if (n == 1) {
	           System.out.println(start + " -> " + end);
	       } else {
	           solve(n - 1, start, end, auxiliary);
	           System.out.println(start + " -> " + end);
	           solve(n - 1, auxiliary, start, end);
	       }
	   }

	   public static void main(String[] args) {
	       TowerofHanoi towersOfHanoi = new TowerofHanoi();
	       System.out.print("Enter number of plates: ");
	       Scanner scanner = new Scanner(System.in);
	       int discs = scanner.nextInt();
	       towersOfHanoi.solve(discs, "A", "B", "C");
	   }
	}