package Mathematics;

import java.math.BigDecimal;
import java.util.Scanner;

public class Hemisphere extends Sphere {
	private BigDecimal area, volume;
	static Scanner reader = new Scanner(System.in);
	
	@Override
	public BigDecimal findTotalSurfaceArea(BigDecimal radius) {
		area = super.findArea(radius).multiply(new BigDecimal(3));
		return area;
	}

	public BigDecimal findCurveArea(BigDecimal radius) {
		area = super.findArea(radius).multiply(new BigDecimal(2));
		return area;
	}
	
	@Override
	public BigDecimal findVolume(BigDecimal radius) {
		volume = radius.pow(3).multiply(new BigDecimal(2/3)).multiply(new BigDecimal(Math.PI));
		return volume;
	}

	static void hemiSphereAreaChoice() {
		int choice;
		Hemisphere h = new Hemisphere();
		System.out.flush();
		System.out.println("----------------------------------");
		System.out.println("Choose type of Area");
		System.out.println("1. Area of Curve of Hemisphere");
		System.out.println("2. Area of closed Hemisphere");
		System.out.println("3. Exit");
		System.out.println("----------------------------------");
		System.out.print("\nEnter your choice : ");
		choice = reader.nextInt();
		
		System.out.flush();
		System.out.print("Enter Radius of Hemisphere : ");
		BigDecimal radius = reader.nextBigDecimal();
		
		switch(choice) {
		case 1: {
			System.out.println("Required Surface Area of Cone : " + h.findCurveArea(radius));
			break;
		}

		case 2: {
			System.out.println("Required Surface Area of Cone : " + h.findTotalSurfaceArea(radius));
			break;
		}
		
		case 3: {
			System.exit(0);
			break;
		}
		
		default:
			System.out.println("Invalid choice...\nExiting from Program...");
			System.exit(1);
			break;
		}
	}

}
