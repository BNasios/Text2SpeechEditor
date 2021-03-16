package commands;

import model.Line;

public class LineToSpeech implements ICommand {
	
	private Object[] data; 
	
	public LineToSpeech() {}
	
	public LineToSpeech(Object[] data) {
		this.data = data;
	}
	
	public int execute() {
		Line l = new Line(data);
		l.playLine();
		
		return 0;
	}
}
