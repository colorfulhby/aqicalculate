package com.colorfulhby.aqi.aqi;


import com.colorfulhby.aqi.constant.Co_1;
import com.colorfulhby.aqi.constant.IAQI;
import com.colorfulhby.aqi.constant.No2_1;
import com.colorfulhby.aqi.constant.O3_1;
import com.colorfulhby.aqi.constant.Pm10;
import com.colorfulhby.aqi.constant.Pm25;
import com.colorfulhby.aqi.constant.So2_1;

/**
 * AQI实时报 IAQI计算
 * <p>
 * 分浓度, 分指数涉及指标:
 * <ul>
 * <li>so2 1h average
 * <li>no2 1h average
 * <li>pm10 1h average
 * <li>co 1h average
 * <li>o3 1h average
 * <li>pm25 1h average
 * </ul>
 */
public class RealTimeCalc {

	/**
	 * 计算IAQI
	 * 
	 * @param composition 指标名称
	 * @param concentrations 指标浓度 ug/m3
	 * @return IAQI 参数无效时返回-1
	 */
	public int getIAqi(String composition, float concentrations) {
		int iAqi = -1;

		if (concentrations < 0) {
			return iAqi;
		}

		int bpH = -1; // 污染物浓度限值高位值
		int bpL = -1; // 污染物浓度限值低位值
		int iAqiH = -1; // 与bpH对应的空气质量分指数
		int iAqiL = -1; // 与bpL对应的空气质量分指数

		if (composition == "so2") {
			if (concentrations > So2_1.c7.getValue()) {
				iAqi = IAQI.c7.getValue();
			} else {
				bpH = So2_1.c0.getBpH(concentrations);
				bpL = So2_1.c0.getBpL(concentrations);
				iAqiH = So2_1.c0.calcIAqiH(bpH);
				iAqiL = So2_1.c0.calcIAqiH(bpL);

				iAqi = (int) Math.ceil((iAqiH - iAqiL) * (concentrations - bpL) / (bpH - bpL) + iAqiL);
			}
			return iAqi;
		} else if (composition == "no2") {
			if (concentrations > No2_1.c7.getValue()) {
				iAqi = IAQI.c7.getValue();
			} else {
				bpH = No2_1.c0.getBpH(concentrations);
				bpL = No2_1.c0.getBpL(concentrations);
				iAqiH = No2_1.c0.calcIAqiH(bpH);
				iAqiL = No2_1.c0.calcIAqiH(bpL);

				iAqi = (int) Math.ceil((iAqiH - iAqiL) * (concentrations - bpL) / (bpH - bpL) + iAqiL);
			}
			return iAqi;
		} else if (composition == "pm10") {
			if (concentrations > Pm10.c7.getValue()) {
				iAqi = IAQI.c7.getValue();
			} else {
				bpH = Pm10.c0.getBpH(concentrations);
				bpL = Pm10.c0.getBpL(concentrations);
				iAqiH = Pm10.c0.calcIAqiH(bpH);
				iAqiL = Pm10.c0.calcIAqiH(bpL);

				iAqi = (int) Math.ceil((iAqiH - iAqiL) * (concentrations - bpL) / (bpH - bpL) + iAqiL);
			}
			return iAqi;
		} else if (composition == "co") {
			if (concentrations > Co_1.c7.getValue()) {
				iAqi = IAQI.c7.getValue();
			} else {
				bpH = Co_1.c0.getBpH(concentrations);
				bpL = Co_1.c0.getBpL(concentrations);
				iAqiH = Co_1.c0.calcIAqiH(bpH);
				iAqiL = Co_1.c0.calcIAqiH(bpL);

				iAqi = (int) Math.ceil((iAqiH - iAqiL) * (concentrations - bpL) / (bpH - bpL) + iAqiL);
			}
			return iAqi;
		} else if (composition == "o3") {
			if (concentrations > O3_1.c7.getValue()) {
				iAqi = IAQI.c7.getValue();
			} else {
				bpH = O3_1.c0.getBpH(concentrations);
				bpL = O3_1.c0.getBpL(concentrations);
				iAqiH = O3_1.c0.calcIAqiH(bpH);
				iAqiL = O3_1.c0.calcIAqiH(bpL);

				iAqi = (int) Math.ceil((iAqiH - iAqiL) * (concentrations - bpL) / (bpH - bpL) + iAqiL);
			}
			return iAqi;
		} else if (composition == "pm25") {
			if (concentrations > Pm25.c7.getValue()) {
				iAqi = IAQI.c7.getValue();
			} else {
				bpH = Pm25.c0.getBpH(concentrations);
				bpL = Pm25.c0.getBpL(concentrations);
				iAqiH = Pm25.c0.calcIAqiH(bpH);
				iAqiL = Pm25.c0.calcIAqiH(bpL);

				iAqi = (int) Math.ceil((iAqiH - iAqiL) * (concentrations - bpL) / (bpH - bpL) + iAqiL);
			}
			return iAqi;
		}

		return iAqi;
	}

}
