package encode;


public class AtBash extends Encoding{
	
	public AtBash() {
		super();
		
		for(int i = 0; i<26; i++) {
			cipher_alphabet[i] = (char) ('z'-i);
			cipher_alphabet[i+26] = (char) ('Z'-i);
		}
	}
	
	public char encodeCharacter(char c) {
		char cipher_char;
		int index = -1;
		
		try {
			index = cipher_map.get(c);
			cipher_char = cipher_alphabet[index];
			
		}catch(NullPointerException e) {			
			cipher_char = c;
		}			
		return cipher_char;
	}
}
