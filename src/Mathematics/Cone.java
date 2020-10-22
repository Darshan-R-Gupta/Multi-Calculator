package Mathematics;

import java.math.*;
import java.util.Scanner;

public class Cone {
	protected BigDecimal area, volume, slantHeight;
	static Scanner reader = new Scanner(System.in);
	
	public BigDecimal findCurveArea(BigDecimal radius, BigDecimal slantHeight) {
		area = radius.multiply(slantHeight).multiply(new BigDecimal(Math.PI));
		return area;
	}
	
	public BigDecimal findCurveAreaWithBase(BigDecimal radius, BigDecimal slantHeight) {
		area = findCurveArea(radius, slantHeight).add(findBaseArea(radius));
		return area;
	}
	
	public BigDecimal findBaseArea(BigDecimal radius) {
		area = radius.pow(2).multiply(new BigDecimal(Math.PI));
		return area;
	}
	
	public BigDecimal findVolume(BigDecimal radius, BigDecimal height) {
		volume = findBaseArea(radius).multiply(height).multiply(new BigDecimal(1/3));
		return volume;
	}
	
	public BigDecimal findSlantHeight(BigDecimal radius, BigDecimal height) {
		slantHeight = (radius.pow(2).add(height.pow(2))).sqrt(new MathContext(10000));
		return slantHeight;
	}

	static void coneAreaChoice() {
		int choice;
		Cone c = new Cone();
		System.out.flush();
		System.out.println("----------------------------------");
		System.out.println("Choose type of Area");
		System.out.println("1. Area of Curve of Cone");
		System.out.println("2. Area of closed Cylinder");
		System.out.println("3. Exit");
		System.out.println("----------------------------------");
		System.out.print("\nEnter your choice : ");
		choice = reader.nextInt();
		
		System.out.flush();
		System.out.print("Enter Radius of Cone : ");
		BigDecimal radius = reader.nextBigDecimal();
		System.out.print("Enter Slant-Height of Cone : ");
		BigDecimal slantHeight = reader.nextBigDecimal();
		
		switch(choice) {
		case 1: {
			System.out.println("Required Surface Area of Cone : " + c.findCurveArea(radius, slantHeight));
			break;
		}

		case 2: {
			System.out.println("Required Surface Area of Cone : " + c.findCurveAreaWithBase(radius, slantHeight));
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
