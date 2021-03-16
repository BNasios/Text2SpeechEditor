package encode;

import java.util.HashMap;

public abstract class Encoding implements IEncoding {

	protected HashMap<Character,Integer> cipher_map;
	protected char[] cipher_alphabet;
	
	public Encoding() {
		cipher_map = new HashMap<Character,Integer>();
		cipher_alphabet = new char[52];
		
		for(int i = 0; i<26; i++) {
			cipher_map.put((char) ('a'+i), i);
			cipher_map.put((char) ('A'+i), i+26);
		}
	}
	
	public abstract char encodeCharacter(char c);
	
	@Override
	public String encode(String text) {
		String s = "";
		char[] Arr;
		Arr = text.toCharArray();
		
		for(int i = 0; i<Arr.length; i++) {
			s += encodeCharacter(Arr[i]);
		}		
		return s;
	}
}
