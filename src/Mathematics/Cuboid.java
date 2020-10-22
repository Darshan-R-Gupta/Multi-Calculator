package Mathematics;

import java.math.*;

public class Cuboid {
	private BigDecimal area, volume;
	
	public BigDecimal findTotalArea(BigDecimal length) {
		area = length.pow(2).multiply(new BigDecimal(6));
		return area;
	}
	
	public BigDecimal findTotalArea(BigDecimal length, BigDecimal width, BigDecimal height) {
		area = length.multiply(width).add(length.multiply(height)).add(width.multiply(height)).multiply(new BigDecimal(2));
		return area;
	}
	
	public BigDecimal findVolume(BigDecimal length) {
		area = length.pow(3);
		return volume;
	}
	
	public BigDecimal findVolume(BigDecimal length, BigDecimal width, BigDecimal height) {
		volume = length.multiply(width).multiply(height);
		return volume;
	}

}
