package Mathematics;

import java.math.*;
import java.util.Scanner;

public class Triangle {
	private BigDecimal area, perimeter;
	static Scanner reader = new Scanner(System.in);
	
	// Normal Triangle
	public BigDecimal findArea(BigDecimal base, BigDecimal height) {
		area = base.multiply(height).multiply(new BigDecimal(0.5));
		return area;
	}
	
	// Equilateral Triangle
	public BigDecimal findArea(BigDecimal side) {
		area = side.pow(2).multiply(new BigDecimal(Math.sqrt(3)/4));
		return area;
	}
	
	// Any
	public BigDecimal findArea(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
		if(isValid(side1, side2, side3)) {
			perimeter = findPerimeter(side1, side2, side3);
			BigDecimal s = perimeter.divide(new BigDecimal(2));
			area = s.multiply(s.subtract(side1)).multiply(s.subtract(side2)).multiply(s.subtract(side3)).sqrt(new MathContext(10000));
			return area;
		}
		else {
			System.out.println("Invalid side values.");
			return null;
		}
	}

	public BigDecimal findPerimeter(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
		// TODO Auto-generated method stub
		return side1.add(side2).add(side3);
	}
	
	// Validity
	private boolean isValid(BigDecimal side1, BigDecimal side2, BigDecimal side3) {
		BigDecimal temp = side1.add(side2).add(side3);
		BigDecimal max = side1.max(side2).max(side3);
		if(temp.subtract(max).compareTo(max) == 1)
			return true;
		return false;
	}
	
	static void trianglePerimeterChoice() {
		int choice;
		Triangle t = new Triangle();
		System.out.flush();
		System.out.println("----------------------------------");
		System.out.println("Choose a type of Triangle");
		System.out.println("1. Equilateral");
		System.out.println("2. Isosceles");
		System.out.println("3. Triangle with Unequal sides");
		System.out.println("4. Exit");
		System.out.println("----------------------------------");
		System.out.print("\nEnter your choice : ");
		choice = reader.nextInt();
		
		switch (choice) {
		// Equilateral
		case 1: {
			BigDecimal side;
			System.out.flush();
			System.out.print("Enter the length of side : ");
			side = reader.nextBigDecimal();
			System.out.println("Perimeter of Equilateral Triangle with given Side : " + t.findPerimeter(side, side, side));
			break;
		}
		
		// Isosceles
		case 2: {
			BigDecimal height, width;
			System.out.flush();
			System.out.print("Enter the length of equal sides : ");
			height = reader.nextBigDecimal();
			System.out.print("Enter the length of another side : ");
			width = reader.nextBigDecimal();
			System.out.println("Perimeter of Isosceles Triangle with given Sides : " + t.findPerimeter(width, height, height));
			break;
		}
		
		// Unequal sides
		case 3: {
			BigDecimal side1, side2, side3;
			System.out.flush();
			System.out.print("Enter the length of side-1 : ");
			side1 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-2 : ");
			side2 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-3 : ");
			side3 = reader.nextBigDecimal();
			System.out.println("Perimeter of Triangle with given Sides : " + t.findPerimeter(side1, side2, side3));
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
	
	static void triangleAreaChoice() {
		int choice;
		Triangle t = new Triangle();
		System.out.flush();
		System.out.println("----------------------------------");
		System.out.println("Choose a type of Triangle");
		System.out.println("1. Equilateral");
		System.out.println("2. Isosceles");
		System.out.println("3. Triangle with Unequal sides");
		System.out.println("4. Exit");
		System.out.println("----------------------------------");
		System.out.print("\nEnter your choice : ");
		choice = reader.nextInt();
		
		switch (choice) {
		// Equilateral
		case 1: {
			BigDecimal side;
			System.out.flush();
			System.out.print("Enter the length of side : ");
			side = reader.nextBigDecimal();
			System.out.println("Area of Equilateral Triangle with given Side : " + t.findArea(side, side, side));
			break;
		}
		
		// Isocseles
		case 2: {
			BigDecimal height, width;
			System.out.flush();
			System.out.print("Enter the length of equal sides : ");
			height = reader.nextBigDecimal();
			System.out.print("Enter the length of another side : ");
			width = reader.nextBigDecimal();
			System.out.println("Area of Isosceles Triangle with given Sides : " + t.findArea(width, height, height));
			break;
		}
		
		// Unequal sides
		case 3: {
			BigDecimal side1, side2, side3;
			System.out.flush();
			System.out.print("Enter the length of side-1 : ");
			side1 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-2 : ");
			side2 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-3 : ");
			side3 = reader.nextBigDecimal();
			System.out.println("Area of Triangle with given Sides : " + t.findArea(side1, side2, side3));
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
