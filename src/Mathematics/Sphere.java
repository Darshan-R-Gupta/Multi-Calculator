package Mathematics;

import java.math.BigDecimal;

public class Sphere extends Circle {
	private BigDecimal area, volume;
	
	public BigDecimal findTotalSurfaceArea(BigDecimal radius) {
		// TODO Auto-generated method stub
		area = super.findArea(radius).multiply(new BigDecimal(4));
		return area;
	}
	
	public BigDecimal findVolume(BigDecimal radius) {
		// TODO Auto-generated method stub
		volume = radius.pow(3).multiply(new BigDecimal(4/3)).multiply(new BigDecimal(Math.PI));
		return volume;
	}

}
