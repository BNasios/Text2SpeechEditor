package commands;

import model.Line;

public class EncodedLineToSpeech implements ICommand {

	private String method;
	Object[] data2 = new Object[6];
	
	public EncodedLineToSpeech() {}
	
	/*
	 * Data[0] = encode strategy
	 * Data[1] = line contexts to be transformed
	 * Data[2] = voice volume
	 * Data[3] = voice rate
	 * Data[4] = voice pitch
	 * Data[5] = voice range
	 * Data[6] = argument for testing purposes		if 'action' then user_story else testing mode
	 */
	
	public EncodedLineToSpeech(Object[] data) {
		this.method = (String) data[0];
		this.data2[0] = (String) data[1];
		this.data2[1] = (String) data[2];
		this.data2[2] = (String) data[3];
		this.data2[3] = (String) data[4];
		this.data2[4] = (String) data[5];
		this.data2[5] = (String) data[6];
	}
	
	public int execute() {
		Line l = new Line(data2);
		l.playEncodedLine(method);
		return 0;
	}
}
