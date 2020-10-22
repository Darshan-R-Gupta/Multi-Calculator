package Mathematics;

import java.math.*;

public class Circle {
	BigDecimal area, perimeter;
	
	public BigDecimal findArea(BigDecimal radius) {
		area = radius.multiply(radius).multiply(new BigDecimal(Math.PI));
		return area;
	}
	
	public BigDecimal findPerimeter(BigDecimal radius) {
		perimeter = radius.multiply(new BigDecimal(2*Math.PI));
		return perimeter;
	}
}
