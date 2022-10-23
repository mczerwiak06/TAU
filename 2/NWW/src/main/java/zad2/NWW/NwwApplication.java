package zad2.NWW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class NwwApplication {
	public static int nwd(int a, int b) { // korzystamy tutaj z metody obliczającej NWD
		int c = (a>b) ? a%b : b%a;
		if(c==0) return (a>b) ? b : a;
		return (a>b) ? nww(c, b) : nww(c, a);
	}
	public static int nww(int a, int b) {
		int nww = a*b/nwd(a, b); // wykorzystujemy tutaj właściwość, że najmniejsza wspólna wielkrotność dwóch liczb jest równa ich iloczynowi, podzielonemu przez ich największy wspólny dzielnik
		return nww;
	}

	public static String animals(int c){

		String result="";
		if (c == 1)

			result = "Miau!!";
		else if (c == 2) {
			result = "HauHau!";
		} else if (c == 3) {
			result = "Muuu!";
		}
		else if (c < 0)
			throw new IllegalArgumentException();
		else result = "Wybrałeś złe zwierzę";
		return result;

	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // inicjalizujemy Scanner - obiekt, który będzie zczytywał dane od użytkownika
		System.out.println("Program obliczający najwmniejszą wspólną wielokrotność");
		System.out.println("Podaj pierwszą liczbę: ");
		int a = scanner.nextInt(); // pobieramy zmienną od użytkownika
		System.out.println("Podaj drugą liczbę: ");
		int b = scanner.nextInt(); // pobieramy zmienną od użytkownika
			System.out.println("Najmniejsza wspólna wielokrotność liczb " + a + " i " + b + " to: " + nww(a, b)); // wywołujemy metodę przy drukowaniu wyniku

		System.out.println("Wybierz zwierzę:");
		System.out.println("1 - kot");
		System.out.println("2 - pies");
		System.out.println("3 - krowa");
		int c = scanner.nextInt();
		System.out.println(animals(c));
	}
}
