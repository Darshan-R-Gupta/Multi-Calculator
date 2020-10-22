package Mathematics;

import java.math.*;
import java.util.*;

public class Menu {
	static Scanner reader = new Scanner(System.in);

	public static void  start() throws Exception {	//menuCard()
		int choice = 0;
		do{
			System.out.flush();
			System.out.println("----------------------------------");
			System.out.println("Choose an Option");
			System.out.println("1. Find Perimeter of a Shape");
			System.out.println("2. Find Area of a Shape");
			System.out.println("3. Find Surface Area of an Object");
			System.out.println("4. Find Volume of an Object");
			System.out.println("5. Trigonomatric Values");
			System.out.println("6. Back");
			System.out.println("7. Exit");
			System.out.println("----------------------------------");
			System.out.print("\nEnter your choice : ");
			choice = reader.nextInt();

			switch (choice) {
				case 1: {
					perimeterShapeChoice();
					break;
				}

				case 2: {
					areaShapeChoice();
					break;
				}

				case 3: {
					areaObjectChoice();
					break;
				}

				case 4: {
					volumeObjectChoice();
					break;
				}

				case 5: {
					trigonomatry();
					break;
				}

				case 6: {
					break;
				}
				case 7: {
					System.exit(0);
					break;
				}
				default:
					System.out.println("Invalid choice! Please Choose between 1-7");
					break;
			}
		}while(choice != 6);
	}

	private static void trigonomatry() {
		int choice = 0;
		do {
			Trigonometry t = new Trigonometry();
			System.out.flush();
			System.out.println("----------------------------------");
			System.out.println("Choose an Angle type");
			System.out.println("1. Degree");
			System.out.println("2. Radian");
			System.out.println("3. Back");
			System.out.println("4. Exit");
			System.out.println("----------------------------------");
			System.out.print("\nEnter your choice : ");
			choice = reader.nextInt();


			switch (choice) {
				case 1: {
					System.out.print("Enter value of Angle : ");
					BigDecimal angle = reader.nextBigDecimal();

					t.getValuesByDegree(angle);
					break;
				}

				case 2: {
					System.out.print("Enter value of Angle : ");
					BigDecimal angle = reader.nextBigDecimal();

					t.getValuesByRadian(angle);
					break;
				}
				case 3: {
					break;
				}
				case 4: {
					System.exit(0);
					break;
				}

				default:
					System.out.println("Invalid choice! Please choose between 1-4");
					break;
			}
		}while(choice != 3);
	}
	
	private static void volumeObjectChoice() {
		int choice = 0;
		do {
			System.out.flush();
			System.out.println("----------------------------------");
			System.out.println("Choose an Object");
			System.out.println("1. Cube");
			System.out.println("2. Cuboid");
			System.out.println("3. Cylinder");
			System.out.println("4. Cone");
			System.out.println("5. Sphere");
			System.out.println("6. Hemi-sphere");
			System.out.println("7. Back");
			System.out.println("8. Exit");
			System.out.println("----------------------------------");
			System.out.print("\nEnter your choice : ");
			choice = reader.nextInt();

			switch (choice) {
				// Cube
				case 1: {
					BigDecimal length;
					Cuboid c = new Cuboid();
					System.out.flush();
					System.out.print("Enter the length of Cube : ");
					length = reader.nextBigDecimal();
					System.out.println("Volume of Cube with given length : " + c.findVolume(length));
					break;
				}

				// Cuboid
				case 2: {
					BigDecimal length, width, height;
					Cuboid c = new Cuboid();
					System.out.flush();
					System.out.print("Enter the length of Cuboid : ");
					length = reader.nextBigDecimal();
					System.out.print("Enter the width of Cuboid : ");
					width = reader.nextBigDecimal();
					System.out.print("Enter the height of Cuboid : ");
					height = reader.nextBigDecimal();
					System.out.println("Volume of Cuboid with given length : " + c.findVolume(length, width, height));
					break;
				}

				// Cylinder
				case 3: {
					Cylinder c = new Cylinder();
					System.out.flush();
					System.out.print("Enter the radius of Cylinder : ");
					BigDecimal radius = reader.nextBigDecimal();
					System.out.print("Enter the height of Cylinder : ");
					BigDecimal height = reader.nextBigDecimal();
					System.out.println("Volume of Cuboid with given length : " + c.findVolume(radius, height));
					break;
				}

				// Cone
				case 4: {
					Cone c = new Cone();
					System.out.flush();
					System.out.print("Enter the radius of Cone : ");
					BigDecimal radius = reader.nextBigDecimal();
					System.out.print("Enter the height of Cone : ");
					BigDecimal height = reader.nextBigDecimal();
					System.out.println("Volume of Cuboid with given length : " + c.findVolume(radius, height));
					break;
				}

				// Sphere
				case 5: {
					Sphere s = new Sphere();
					System.out.flush();
					System.out.print("Enter the radius of Sphere : ");
					BigDecimal radius = reader.nextBigDecimal();
					System.out.println("Volume of Sphere with given Radius : " + s.findVolume(radius));
					break;
				}

				// Hemi-sphere
				case 6: {
					Hemisphere s = new Hemisphere();
					System.out.flush();
					System.out.print("Enter the radius of Hemi-Sphere : ");
					BigDecimal radius = reader.nextBigDecimal();
					System.out.println("Volume of Sphere with given Radius : " + s.findVolume(radius));
					break;
				}

				case 7: {
					break;
				}
				case 8: {
					System.exit(0);
					break;
				}

				default:
					System.out.println("Invalid choice! Please choose between 1-8");
					break;
			}
		}while(choice != 7);
	}

	private static void areaShapeChoice() {
		int choice = 0;
		do {
			System.out.flush();
			System.out.println("----------------------------------");
			System.out.println("Choose an Object");
			System.out.println("1. Circle");
			System.out.println("2. Quadrilateral");
			System.out.println("3. Triangle");
			System.out.println("4. Back");
			System.out.println("5. Exit");
			System.out.println("----------------------------------");
			System.out.print("\nEnter your choice : ");
			choice = reader.nextInt();

			switch (choice) {
				// Circle
				case 1: {
					BigDecimal radius;
					Circle c = new Circle();
					System.out.flush();
					System.out.print("Enter the radius of Circle : ");
					radius = reader.nextBigDecimal();
					System.out.println("Area of Circle with given radius : " + c.findArea(radius));
					break;
				}

				// Quadrilateral
				case 2: {
					Quadrilateral.quadrilateralAreaChoice();
					break;
				}

				// Triangle
				case 3: {
					Triangle.triangleAreaChoice();
					break;
				}

				case 4:{
					break;
				}
				case 5: {
					System.exit(0);
					break;
				}

				default:
					System.out.println("Invalid choice! Please Choose between 1-5!");
					break;
			}
		}while(choice != 4);
	}

	private static void areaObjectChoice() {
		int choice =0 ;
		do {
			System.out.flush();
			System.out.println("----------------------------------");
			System.out.println("Choose an Object");
			System.out.println("1. Cube");
			System.out.println("2. Cuboid");
			System.out.println("3. Cylinder");
			System.out.println("4. Cone");
			System.out.println("5. Sphere");
			System.out.println("6. Hemi-sphere");
			System.out.println("7. Back");
			System.out.println("8. Exit");
			System.out.println("----------------------------------");
			System.out.print("\nEnter your choice : ");
			choice = reader.nextInt();

			switch (choice) {
				// Cube
				case 1: {
					BigDecimal length;
					Cuboid c = new Cuboid();
					System.out.flush();
					System.out.print("Enter the length of Cube : ");
					length = reader.nextBigDecimal();
					System.out.println("Surface Area of Cube with given length : " + c.findTotalArea(length));
					break;
				}

				// Cuboid
				case 2: {
					BigDecimal length, width, height;
					Cuboid c = new Cuboid();
					System.out.flush();
					System.out.print("Enter the length of Cuboid : ");
					length = reader.nextBigDecimal();
					System.out.print("Enter the width of Cuboid : ");
					width = reader.nextBigDecimal();
					System.out.print("Enter the height of Cuboid : ");
					height = reader.nextBigDecimal();
					System.out.println("Surface Area of Cuboid with given length : " + c.findTotalArea(length, width, height));
					break;
				}

				// Cylinder
				case 3: {
					Cylinder.cylinderAreaChoice();
					break;
				}

				// Cone
				case 4: {
					Cone.coneAreaChoice();
					break;
				}

				// Sphere
				case 5: {
					Sphere s = new Sphere();
					System.out.flush();
					System.out.print("Enter the radius of Sphere : ");
					BigDecimal radius = reader.nextBigDecimal();
					System.out.println("Surface Area of Sphere with given Radius : " + s.findTotalSurfaceArea(radius));
					break;
				}

				// Hemi-sphere
				case 6: {
					Hemisphere.hemiSphereAreaChoice();
					break;
				}

				case 7: break;
				case 8: {
					System.exit(0);
					break;
				}

				default:
					System.out.println("Invalid choice! Please Choose between 1-8");
					break;
			}
		}while(choice != 7);
	}

	private static void perimeterShapeChoice() {
		int choice =0;
		do {
			System.out.flush();
			System.out.println("----------------------------------");
			System.out.println("Choose a Shape");
			System.out.println("1. Circle");
			System.out.println("2. Quadrilateral");
			System.out.println("3. Triangle");
			System.out.println("4. Back");
			System.out.println("5. Exit");
			System.out.println("----------------------------------");
			System.out.print("\nEnter your choice : ");
			choice = reader.nextInt();

			switch (choice) {
				// Circle
				case 1: {
					BigDecimal radius;
					Circle c = new Circle();
					System.out.flush();
					System.out.print("Enter the radius of Circle : ");
					radius = reader.nextBigDecimal();
					System.out.println("Perimeter of Circle with given Radius : " + c.findPerimeter(radius));
					break;
				}

				// Quadrilateral
				case 2: {
					Quadrilateral.quadrilateralPerimeterChoice();
					break;
				}

				// Triangle
				case 3: {
					Triangle.trianglePerimeterChoice();
					break;
				}
				case 4: break;
				case 5: {
					System.exit(0);
					break;
				}

				default:
					System.out.println("Invalid choice! Please choose between 1-5");
					break;
			}
		}while(choice != 4);
	}
}
