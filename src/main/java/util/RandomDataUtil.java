package util;

import java.util.Random;

public class RandomDataUtil {
	
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String SPECIAL_CHARS = "!~@#$_&^%-";
	private static Random random = new Random();

	public static String generateString(int length) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++) {
			int index = random.nextInt(CHARACTERS.length());
			sb.append(CHARACTERS.charAt(index));
		}
		return sb.toString();
	}
	
	public static String generateEmail(int length) {
		return generateString(length).concat("@gmail.com");
	}
	
	public static String generateName(int length) {
		return generateString(length).toUpperCase();
	}
	
	public static String generatePassword(int length) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<length; i++) {
			if(i==0) {
				sb.append(CHARACTERS.charAt(random.nextInt(25)));
			}
			else if(i<length/2) {
				sb.append(CHARACTERS.charAt(random.nextInt(26, CHARACTERS.length())));
			}else {
				sb.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
				sb.append(random.nextInt(10));
			}
		}
		return sb.toString();
	}
	
	public static String generateMobileNo() {
		long num = 9;
		for(int i=1; i<10; i++) {
			num *=10;
			num+= random.nextInt(10);
		}
		return String.valueOf(num);
	}
	
	public static void main(String args []) {
		for(int i=0; i<10; i++) {
			//System.out.println("|"+generateName(7)+"|"+generateName(7)+"|"+generateEmail(11)+"|"+generateMobileNo()+"|"+generatePassword(8)+"|");
			System.out.println(generateEmail(11)+", "+generatePassword(8));
		}
	}
	
}
