package com.zxt.clinic.utils;

import com.zxt.clinic.entity.Appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class ComputeTool {

	public static int getAgeByBirthday(Date birthday) {
		Calendar cal = Calendar.getInstance();

		if (cal.before(birthday)) {
			throw new IllegalArgumentException("The birthDay is before Now.It's unbelievable!");
		}

		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

		cal.setTime(birthday);
		int yearBirth = cal.get(Calendar.YEAR);
		int monthBirth = cal.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearBirth;
		if (age <= 1) {
			return age;
		}
		if (monthNow <= monthBirth) {
			if (monthNow == monthBirth) {
				if (dayOfMonthNow < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
	}

	public static Date convertStr2Date(String str) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}



	public static int[] convertStr2Array(String s) {
		String[] str = s.split(",");
		int[] array = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			array[i] = Integer.parseInt(str[i]);
		}
		return array;
	}

	public static boolean isSameDate(Date DesDate,Date SrcDate) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(DesDate);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(SrcDate);
		boolean isSameYear = calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear
				&& calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth
				&& calendar1.get(Calendar.DAY_OF_MONTH) == calendar2
				.get(Calendar.DAY_OF_MONTH);
		return isSameDate;
	}

	/*
	计算两个时间点的相差时间
	返回分钟数。
	 */
	public static int getDistanceTime(Date date1,Date date2){
		int result;
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		long diff ;
		if (time1<time2){
			diff = time2 - time1;
		}else {
			diff = time1 - time2;
		}
		long min = diff/(60*1000);
		result = (int)min;
		return result;
	}

	/*
	返回某天的零点
	 */
	public static Date convert2Zero(Date date){
		if (date == null) {
			return null;
		}
		String string = (new SimpleDateFormat("yyyy-MM-dd")).format(date);
		String string2 = string + " " + "00:00:00";
		return convertStr2Date(string2);
	}
	/*
	返回某天的终点
	 */
	public static Date convert2End(Date date){
		if (date == null) {
			return null;
		}
		String string = (new SimpleDateFormat("yyyy-MM-dd")).format(date);
		String string2 = string + " " + "23:59:59";
		return convertStr2Date(string2);
	}
}
