package org.kt.temp.config;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		String value = source.trim();
		if ("".equals(value))
			return null;

		final DateFormat DF_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final DateFormat DF_SHORT = new SimpleDateFormat("yyyy-MM-dd");
		final DateFormat DF_YEAR = new SimpleDateFormat("yyyy");
		final DateFormat DF_MONTH = new SimpleDateFormat("yyyy-MM");

		final int SHORT_DATE = 10;
		final int YEAR_DATE = 4;
		final int MONTH_DATE = 7;

		try {
			if (value.length() <= YEAR_DATE) {
				return new java.sql.Date(DF_YEAR.parse(value).getTime());
			} else if (value.length() <= MONTH_DATE) {
				return new java.sql.Date(DF_MONTH.parse(value).getTime());
			} else if (value.length() <= SHORT_DATE) {
				return new java.sql.Date(DF_SHORT.parse(value).getTime());
			} else {
				return new java.sql.Timestamp(DF_LONG.parse(value).getTime());
			}
		} catch (ParseException e) {
			return null;
		}
	}
}
