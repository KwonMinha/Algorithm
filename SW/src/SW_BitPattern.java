import java.util.Arrays;

public class SW_BitPattern {

	public static void main(String[] args) {
		// String hex = "0DEC";
		String hex = "0269FAC9A0";

		String[] hexa = { "0000", "0001", "0010", "0011", "0100", 
				"0101", "0110", "0111", "1000", "1001", 
				"1010", "1011", "1100", "1101", "1110", "1111" };

		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		String[] number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

//		int hexToDecimal = Integer.parseInt(hex, 16);
//		String decimalToBinary = Integer.toBinaryString(hexToDecimal);
		// 이렇게 하면 앞이나 뒤의 00같은 것들이 짤림

		// System.out.println(decimalToBinary);

		String password = "";

		for(int i = 0; i < hex.length(); i++) {
			for(int j = 0; j < 16; j++) { 
//				if(hex.charAt(i) == num[j])  {
//					System.out.println(hexa[j]);
//					password += hexa[j];
//				}

				String str = hex.charAt(i) + "";
				if(str.equalsIgnoreCase(number[j]) ) {
					//System.out.println(hexa[j]);
					password += hexa[j];
				}
			}
		}
		
		String[] bitPattern = {"001101", "010011", "111011", "110001", "100011", 
								"110111", "001011", "111101", "011001", "101111"};
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 5; i < password.length(); i++) {
			if(password.charAt(i) == '1') {
				String pattern = password.substring(i-5, i+1);
				
//				if(Arrays.asList(bitPattern).contains(pattern)) {
//					System.out.println(pattern);
//				}
				
				// System.out.println(pattern);
				
				for(int j = 0; j < bitPattern.length; j++) {
					if(pattern.equals(bitPattern[j])) {
						System.out.println(j);
						i += 5;
						break;
					}
				}
			}
		}
		



	}

}
