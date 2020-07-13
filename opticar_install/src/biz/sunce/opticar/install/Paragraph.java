package biz.sunce.opticar.install;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Paragraph {
	private static final SimpleDateFormat ddMm = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat mmDd = new SimpleDateFormat("MM/dd/yyyy");

	public static String changeDateFormat(String paragraph) {
		String[] words = paragraph.split(" ");
		StringBuilder result = new StringBuilder("");
		for (String word : words) {
			if (isDate(word)) {
				result.append(" ").append(convertDate(word));
			} else {
				result.append(" ").append(word);
			}
		}
		return result.toString();
	}

	private static String convertDate(String word) {
		Date converted = null; 
		try {
		converted = ddMm.parse(word);
		} catch (ParseException ex) {
			System.out.println("Exception parsing word into date: " + word);
			return "?!?";
		}
		
		return mmDd.format(converted);
	}

	private static boolean isDate(String word) {
		try {
			ddMm.parse(word);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(changeDateFormat("Last time it rained was on 07/25/2013 and today is 08/09/2013."));
	}
}