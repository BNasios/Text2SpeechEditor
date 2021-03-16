package encode;


public class Rot13 extends  Encoding {
		
	public Rot13() {
		super();
		
		for(int i = 0; i<26; i++) {
			cipher_alphabet[i] = (char) ('a'+i);
			cipher_alphabet[i+26] = (char) ('A'+ i);
		}
	}
	
	public char encodeCharacter(char c) {	
		int index = -1;
		char cipher_char;
		
		try {
			index = cipher_map.get(c);
			if(index <= 25) {
				cipher_char = cipher_alphabet[(index+13)%26];
			}else {
				cipher_char = cipher_alphabet[(index+13)%26+26];
			}
		}catch(NullPointerException e) {
			cipher_char = c;
		}	
		return cipher_char;
	}	
}
