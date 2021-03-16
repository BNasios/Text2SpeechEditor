package commands;

import model.Line;

public class ReverseLineToSpeech implements ICommand {

private Object[] data; 
	
	public ReverseLineToSpeech() {}
	
	public ReverseLineToSpeech(Object[] data) {
		this.data = data;
	}
	
	public int execute() {
		Line l = new Line(data);
		l.playReverseLine();
		return 0;
	}
}
