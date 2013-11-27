/**
* <p>Copyright @ 2009 深圳市金绎科技发展有限公司</p>
* <p>All right reserved. </p>
* <p>项目名称				： 佛山市地方公路信息资源整合</p>
* <p>JDK使用版本号		： jdk1.5 </P>
* <p>描述				： </p>
* @版本					： 1.0.0 
* @author				： 谢庚才
*
* <p>修改历史 </p>
*
* <p>修改时间            修改人员    修改内容 </p>
*  <p>2009-5-15			谢庚才	  新建    </p>
*/
package com.rosy.bill.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;
/**
 * 该工具类的计算方法皆忽略为 null 参数，即 sum(1,null,1)=2,sub(10,null,5)=2,mul(5,null,3)=15,div(10,null,5)=2
 * @author 谢庚才
 *
 */
public final class MathsUtils{
	private MathsUtils(){}
	
	public static String formatDoubleToString(Double d){
		  if(d == null) {
			  return "";
		  }
		NumberFormat fmt = new java.text.DecimalFormat();
    	fmt.setMaximumFractionDigits(100);
    	fmt.setGroupingUsed(false);
    	return fmt.format(d);
	}
	/**
	 * 以指定的舍入模式格式化双精度浮点型小数
	 * @param d 需格式化小数
	 * @param precision 保留小数位数
	 * @param roundingMode 舍入模式
	 * @return
	 */
	public static Double formatDouble(Double d, int precision, int roundingMode) {
		 if(d == null) {
			 return null;
		 }
		BigDecimal bd = new BigDecimal(d);
		return bd.setScale(precision, roundingMode).doubleValue();
	}
	
	/**
	 * 以指定的舍入模式格式化单精度浮点型小数
	 * @param d 需格式化小数
	 * @param precision 保留小数位数
	 * @param roundingMode 舍入模式
	 * @return
	 */
	public static Float formatFloat(Float d, int precision, int roundingMode) {
		 if(d == null) {
			 return null;
		 }
		BigDecimal bd = new BigDecimal(d);
		return bd.setScale(precision, roundingMode).floatValue();
	}

	public static Number sum(Number...values) {
		  if(values instanceof Double[]){
			  Double[]dvalues =(Double[])values;
				Double result = new Double(0);
				for (Double value : dvalues) {
					if (value!=null) {
						result += value;
					}
				}
				return result;
			
			  
		  }
		  else if(values instanceof Integer[]){
			  Integer[]ivalues =(Integer[])values;
			  Integer result = new Integer(0);
				for (Integer value : ivalues) {
					if (value!=null) {
						result += value;
					}
				}
				return result; 
		  }
		  else if(values instanceof Float[]){
			  Float[] fvalues =(Float[])values;
			  Float result = new Float(0);
				for (Float value : fvalues) {
					if (value!=null) {
						result += value;
					}
				}
				return result; 
		  }
		  else if(values instanceof Long[]){
			  Long[] lvalues =(Long[])values;
			  Long result = new Long(0);
				for (Long value : lvalues) {
					if (value!=null) {
						result += value;
					}
				}
				return result; 
		  }
		  return 0; 
		
	}
	/**
	 * 求和运算
	 * 
	 * @param ds
	 *            参数列表
	 * @return
	 */
	public static Double sum(Double...values) {
	
		Double result = new Double(0);
		for (Double value : values) {
			if (value!=null) {
				result += value;
			}
		}
		return result;
	}
	
	public static Integer sum(Integer...values){
		Integer result = new Integer(0);
		for (Integer value : values) {
			if (value!=null) {
				result+=value;
			}
		}
		return result;
	}
	public static Float sum(Float...values){
		Float result = new Float(0);
		for (Float value : values) {
			if (value!=null) {
				result+=value;
			}
		}
		return result;
	}
	public static Long sum(Long...values){
		Long result = new Long(0);
		for (Long value : values) {
			if (value!=null) {
				result+=value;
			}
		}
		return result;
	}
	/**
	 * 减法运算，取第一个参数为被减数
	 * 
	 * @param ds
	 * @return
	 */
	public static Double sub(Double... values) {
		Double result = 0d;
		if (values.length > 0) {
			if (values[0]!=null) {
				result = values[0];
			}
		}
		for (int i = 1; i < values.length; i++) {
			if (values[i]!=null) {
				result -= values[i];
			}
		}
		return result;
	}
	public static Float sub(Float... values) {
		Float result = 0f;
		if (values.length > 0) {
			if (values[0]!=null) {
				result = values[0];
			}
		}
		for (int i = 1; i < values.length; i++) {
			if (values[i]!=null) {
				result -= values[i];
			}
		}
		return result;
	}
	public static Integer sub(Integer... values) {
		Integer result = 0;
		if (values.length > 0) {
			if (values[0]!=null) {
				result = values[0];
			}
		}
		for (int i = 1; i < values.length; i++) {
			if (values[i]!=null) {
				result -= values[i];
			}
		}
		return result;
	}
	public static Long sub(Long... values) {
		Long result = 0l;
		if (values.length > 0) {
			if (values[0]!=null) {
				result = values[0];
			}
		}
		for (int i = 1; i < values.length; i++) {
			if (values[i]!=null) {
				result -= values[i];
			}
		}
		return result;
	}
	/**
	 * 乘法运算，如果第一个参数为“0”，不管后面的参数怎样结果都为“0”
	 * 
	 * @param ds
	 * @return
	 */
	public static Double mul(Number...numbers) {
		Double result = 0d;
		if (numbers.length > 0 && numbers[0] != null) {
			result = numbers[0].doubleValue();
			for (int i = 1; i < numbers.length; i++) {
				if (numbers[i]!=null) {
					if (numbers[i].doubleValue() == 0) {
						result = 0d;
					} else {
						result *= numbers[i].doubleValue();
					}
				}
			}
		}
		return result;
	}
	public static Double mul(Double... ds) {
		Double result = 0d;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] == 0) {
						result = 0d;
					} else {
						result *= ds[i];
					}
				}
			}
		}

		return result;
	}
	public static Float mul(Float... ds) {
		Float result = 0f;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] == 0) {
						result = 0f;
					} else {
						result *= ds[i];
					}
				}
			}
		}

		return result;
	}
	public static Integer mul(Integer... ds) {
		Integer result = 0;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] == 0) {
						result = 0;
					} else {
						result *= ds[i];
					}
				}
			}
		}

		return result;
	}
	public static Long mul(Long... ds) {
		Long result = 0l;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] == 0) {
						result = 0l;
					} else {
						result *= ds[i];
					}
				}
			}
		}

		return result;
	}
	/**
	 * 除法运算，如果第一个参数为“0”，不管后面的参数怎样结果都为“0”； 若第一个参数不为“0”，后面的参数也不能为零，否则抛出除“0”异常
	 * 
	 * @param ds
	 * @return
	 */
	public static Double div(Double... ds) {
		Double result = 0d;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] != 0) {
						result /= ds[i];
					} else {
						throw new ArithmeticException("除数不能为“0”");
					}
				}
			}
		}
		return result;
	}
	public static Float div(Float... ds) {
		Float result = 0f;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] != 0) {
						result /= ds[i];
					} else {
						throw new ArithmeticException("除数不能为“0”");
					}
				}
			}
		}
		return result;
	}
	public static Integer div(Integer... ds) {
		Integer result = 0;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] != 0) {
						result /= ds[i];
					} else {
						throw new ArithmeticException("除数不能为“0”");
					}
				}
			}
		}
		return result;
	}
	public static Long div(Long... ds) {
		Long result = 0L;
		if (ds.length > 0 && ds[0] != null) {
			result = ds[0];
			for (int i = 1; i < ds.length; i++) {
				if (ds[i]!=null) {
					if (ds[i] != 0) {
						result /= ds[i];
					} else {
						throw new ArithmeticException("除数不能为“0”");
					}
				}
			}
		}
		return result;
	}
}
