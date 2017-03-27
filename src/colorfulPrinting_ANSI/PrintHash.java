package colorfulPrinting_ANSI;

public class PrintHash {

	public static void main(String[] args) {

		String toPrint = args[0];
		String hash    = args[1];

		if (hash.length() == 7)
			hash = hash.substring(1);
		if (hash.length() != 6)
			throw new java.lang.Error("The hash you have entered is invalid! Enter hash in format #RRGGBB or RRGGBB!");

		String rh; int ri;
		String gh; int gi;
		String bh; int bi;

		hash = hash.toLowerCase();

		rh = hash.substring(0, 2);
		gh = hash.substring(2, 4);
		bh = hash.substring(4, 6);
		
		try {
			ri = hexToDec(rh);
			gi = hexToDec(gh);
			bi = hexToDec(bh);
		} catch (Exception e) {
			throw new java.lang.Error(e);
		}
		
		System.out.println((char) 27 + "[38;5;" + ri + ";" + gi + ";" + bi + "m" + toPrint + (char) 27 + "[0m");

	}

	private static int hexToDec(String hex) throws Exception{
//		int res = 0;
//		for ( int x = (hex.length() - 1) ; x >= 0 ; x--){
//			char c = hex.charAt(hex.length() - x - 1);
//			int phex = (int) Math.pow(16, x);
//			System.out.println(phex);
//			if (Character.isDigit(c))
//				res += ((int) c) * phex;
//			else if ( c == 'a' ){
//				res += 10 * phex;
//			}else if ( c == 'b' ){
//				res += 11 * phex;
//			}else if ( c == 'c' ){
//				res += 12 * phex;
//			}else if ( c == 'd' ){
//				res += 13 * phex;
//			}else if ( c == 'e' ){
//				res += 14 * phex;
//			}else if ( c == 'f' ){
//				res += 15 * phex;
//			}else
//				throw new java.lang.Exception("Encountered invalid character in hash! Use digits and A-F!");
//			System.out.println(res);
//		}
		return Integer.parseInt(hex,16);
	}
}
