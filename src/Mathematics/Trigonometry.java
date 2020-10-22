package Mathematics;

import java.math.*;

public class Trigonometry {
	private BigDecimal radian, degree;
	
	private BigDecimal reduceDegree(BigDecimal degree) {
		this.degree = degree.remainder(new BigDecimal(360));
		return this.degree;
	}
	
	private BigDecimal reduceRadian(BigDecimal radian) {
		this.radian = radian.remainder(new BigDecimal(2*Math.PI));
		return this.radian;
	}
	
	public void getValuesByRadian(BigDecimal radian) {
		this.radian = reduceRadian(radian);
		System.out.println("sin(" + degree + ") : " + new BigDecimal(Math.sin(this.radian.doubleValue())));
		System.out.println("cos(" + degree + ") : " + new BigDecimal(Math.cos(this.radian.doubleValue())));
		System.out.println("tan(" + degree + ") : " + new BigDecimal(tan(this.radian.doubleValue())));
		System.out.println("cot(" + degree + ") : " + new BigDecimal(cot(this.radian.doubleValue())));
		System.out.println("sec(" + degree + ") : " + new BigDecimal(sec(this.radian.doubleValue())));
		System.out.println("cosec(" + degree + ") : " + new BigDecimal(cosec(this.radian.doubleValue())));
	}
	

	public void getValuesByDegree(BigDecimal degree) {
		this.degree = reduceDegree(degree);
		this.radian = toRadian(degree);
		System.out.println("sin(" + degree + ") : " + new BigDecimal(Math.sin(this.radian.doubleValue())));
		System.out.println("cos(" + degree + ") : " + new BigDecimal(Math.cos(this.radian.doubleValue())));
		System.out.println("tan(" + degree + ") : " + new BigDecimal(tan(this.radian.doubleValue())));
		System.out.println("cot(" + degree + ") : " + new BigDecimal(cot(this.radian.doubleValue())));
		System.out.println("sec(" + degree + ") : " + new BigDecimal(sec(this.radian.doubleValue())));
		System.out.println("cosec(" + degree + ") : " + new BigDecimal(cosec(this.radian.doubleValue())));
	}
	
	private String cosec(double radian) {
		double sin = Math.sin(radian);
		if(sin == 0)
			return "infinity";
		return "" + 1/sin;
	}

	private String sec(double radian) {
		double cos = Math.cos(radian);
		if(cos == 0)
			return "infinity";
		return "" + 1/cos;
	}

	private String cot(double radian) {
		double sin = Math.sin(radian);
		double cos = Math.cos(radian);
		if(sin == 0)
			return "infinity";
		return "" + cos/sin;
	}
	
	private String tan(double radian) {
		double sin = Math.sin(radian);
		double cos = Math.cos(radian);
		if(cos == 0)
			return "infinity";
		return "" + sin/cos;
	}
	
	private BigDecimal toRadian(BigDecimal degree) {
		this.radian = degree.multiply(new BigDecimal(Math.PI/180));
		return this.radian;
	}
}
