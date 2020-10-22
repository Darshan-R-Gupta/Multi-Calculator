package Mathematics;

import java.math.*;
import java.util.Scanner;

public class Cylinder {
	private BigDecimal area, volume;
	static Scanner reader = new Scanner(System.in);
	
	public BigDecimal findCurveArea(BigDecimal radius, BigDecimal height) {
		area = radius.multiply(height).multiply(new BigDecimal(2*Math.PI));
		return area;
	}
	
	public BigDecimal findCurveAreaWithBase(BigDecimal radius, BigDecimal height) {
		area = findCurveArea(radius, height).add(findBaseArea(radius));
		return area;
	}
	
	public BigDecimal findClosedArea(BigDecimal radius, BigDecimal height) {
		area = findCurveAreaWithBase(radius, height).add(findBaseArea(radius));
		return area;
	}
	
	public BigDecimal findBaseArea(BigDecimal radius) {
		area = radius.pow(2).multiply(new BigDecimal(Math.PI));
		return area;
	}
	
	public BigDecimal findVolume(BigDecimal radius, BigDecimal height) {
		volume = findBaseArea(radius).multiply(height);
		return volume;
	}

	static void cylinderAreaChoice() {
		int choice;
		Cylinder c = new Cylinder();
		System.out.flush();
		System.out.println("----------------------------------");
		System.out.println("Choose type of Area");
		System.out.println("1. Area of Curve of Cylinder");
		System.out.println("2. Area of Cylinder with Base");
		System.out.println("3. Area of closed Cylinder");
		System.out.println("4. Exit");
		System.out.println("----------------------------------");
		System.out.print("\nEnter your choice : ");
		choice = reader.nextInt();
		
		System.out.flush();
		System.out.print("Enter Radius of Cylinder : ");
		BigDecimal radius = reader.nextBigDecimal();
		System.out.print("Enter Height of Cylinder : ");
		BigDecimal height = reader.nextBigDecimal();
		
		switch(choice) {
		case 1: {
			System.out.println("Required Surface Area of Cylinder : " + c.findCurveArea(radius, height));
			break;
		}

		case 2: {
			System.out.println("Required Surface Area of Cylinder : " + c.findCurveAreaWithBase(radius, height));
			break;
		}
		
		case 3: {
			System.out.println("Required Surface Area of Cylinder : " + c.findClosedArea(radius, height));
			break;
		}
		
		case 4: {
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
