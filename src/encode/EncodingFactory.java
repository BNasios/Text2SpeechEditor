package encode;

public class EncodingFactory {
	
	public IEncoding createRot13() {
		return new Rot13();
	}
	public IEncoding createAtBash() {
		return new AtBash();
	}
}
