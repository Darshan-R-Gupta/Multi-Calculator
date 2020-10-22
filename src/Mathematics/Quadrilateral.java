package Mathematics;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Quadrilateral {
	private BigDecimal area, perimeter;
	static Scanner reader = new Scanner(System.in);
	
	// Square
	public BigDecimal findArea(BigDecimal side1) {
		return findArea(side1, side1);
	}
	
	// Rectangle & Parallelogram & Rhombus*2
	public BigDecimal findArea(BigDecimal base, BigDecimal height) {
		area = base.multiply(height);
		return area;
	}
	
	// Any
	public BigDecimal findArea(BigDecimal side1, BigDecimal side2, BigDecimal side3, BigDecimal side4) {
		if(isValid(side1, side2, side3, side4)) {
			perimeter = findPerimeter(side1, side2, side3, side4);
			BigDecimal s = perimeter.divide(new BigDecimal(2));
			area = s.subtract(side1).multiply(s.subtract(side2)).multiply(s.subtract(side3)).multiply(s.subtract(side4)).sqrt(new MathContext(10000));
			return area;
		}
		else {
			System.out.println("Invalid side values.");
			return null;
		}
	}

	public BigDecimal findPerimeter(BigDecimal side1, BigDecimal side2, BigDecimal side3, BigDecimal side4) {
		// TODO Auto-generated method stub
		return side1.add(side2).add(side3).add(side4);
	}
	
	// Validity
	private boolean isValid(BigDecimal side1, BigDecimal side2, BigDecimal side3, BigDecimal side4) {
		BigDecimal temp = findPerimeter(side1, side2, side3, side4);
		BigDecimal max = side1.max(side2).max(side3).max(side4);
		if(temp.subtract(max).compareTo(max) == 1)
			return true;
		return false;
	}
	
	static void quadrilateralPerimeterChoice() {
		int choice;
		Quadrilateral q = new Quadrilateral();
		System.out.flush();
		System.out.println("----------------------------------");
		System.out.println("Choose a type of Quadrilateral");
		System.out.println("1. Square/Rhombus");
		System.out.println("2. Rectangle/Parallelogram");
		System.out.println("3. Quadrilateral with Unequal sides");
		System.out.println("4. Exit");
		System.out.println("----------------------------------");
		System.out.print("\nEnter your choice : ");
		choice = reader.nextInt();
		
		switch (choice) {
		// Square/Rhombus
		case 1: {
			BigDecimal side;
			System.out.flush();
			System.out.print("Enter the length of side : ");
			side = reader.nextBigDecimal();
			System.out.println("Perimeter of Square/Rhombus with given Side : " + q.findPerimeter(side, side, side, side));
			break;
		}
		
		// Rectangle/Parallelogram
		case 2: {
			BigDecimal height, width;
			System.out.flush();
			System.out.print("Enter the length of height : ");
			height = reader.nextBigDecimal();
			System.out.print("Enter the length of width : ");
			width = reader.nextBigDecimal();
			System.out.println("Perimeter of Rectangle/Parallelogram with given Sides : " + q.findPerimeter(width, width, height, height));
			break;
		}
		
		// Unequal sides
		case 3: {
			BigDecimal side1, side2, side3, side4;
			System.out.flush();
			System.out.print("Enter the length of side-1 : ");
			side1 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-2 : ");
			side2 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-3 : ");
			side3 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-4 : ");
			side4 = reader.nextBigDecimal();
			System.out.println("Perimeter of Quadrilateral with given Sides : " + q.findPerimeter(side1, side2, side3, side4));
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

	static void quadrilateralAreaChoice() {
		int choice;
		Quadrilateral q = new Quadrilateral();
		System.out.flush();
		System.out.println("----------------------------------");
		System.out.println("Choose a type of Quadrilateral");
		System.out.println("1. Square");
		System.out.println("2. Rectangle");
		System.out.println("3. Rhombus");
		System.out.println("4. Parallelogram");
		System.out.println("5. Quadrilateral with Unequal sides");
		System.out.println("6. Exit");
		System.out.println("----------------------------------");
		System.out.print("\nEnter your choice : ");
		choice = reader.nextInt();
		
		switch (choice) {
		// Square
		case 1: {
			BigDecimal side;
			System.out.flush();
			System.out.print("Enter the length of side : ");
			side = reader.nextBigDecimal();
			System.out.println("Area of Square/Rhombus with given Side : " + q.findArea(side));
			break;
		}
		
		// Rectangle
		case 2: {
			BigDecimal height, width;
			System.out.flush();
			System.out.print("Enter the length of height : ");
			height = reader.nextBigDecimal();
			System.out.print("Enter the length of width : ");
			width = reader.nextBigDecimal();
			System.out.println("Area of Rectangle/Parallelogram with given Sides : " + q.findArea(width, height));
			break;
		}
		
		// Parallelogram
		case 4: {
			BigDecimal height, base;
			System.out.flush();
			System.out.print("Enter the length of base : ");
			base = reader.nextBigDecimal();
			System.out.print("Enter the length of height : ");
			height = reader.nextBigDecimal();
			System.out.println("Area of Parallelogram with given Sides : " + q.findArea(base, height));
			break;
		}
		
		// Rhombus
		case 3: {
			BigDecimal diag1, diag2;
			System.out.flush();
			System.out.print("Enter the length of Diagonal-1 : ");
			diag1 = reader.nextBigDecimal();
			System.out.print("Enter the length of Diagonal-2 : ");
			diag2 = reader.nextBigDecimal();
			System.out.println("Area of Rhombus with given Sides : " + q.findArea(diag1, diag2.divide(new BigDecimal(2))));
			break;
		}
		
		// Unequal sides
		case 5: {
			BigDecimal side1, side2, side3, side4;
			System.out.flush();
			System.out.print("Enter the length of side-1 : ");
			side1 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-2 : ");
			side2 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-3 : ");
			side3 = reader.nextBigDecimal();
			System.out.print("Enter the length of side-4 : ");
			side4 = reader.nextBigDecimal();
			System.out.println("Area of Quadrilateral with given Sides : " + q.findArea(side1, side2, side3, side4));
			break;
		}
		
		case 6: {
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
