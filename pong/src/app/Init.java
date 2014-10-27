package app;

import java.awt.Color;

public class Init {
	
	private GUIElements.Bat _autoplayer = new GUIElements.Bat(Color.GREEN);
	private GUIElements.Bat _realplayer = new GUIElements.Bat(Color.GREEN);
	private GUIElements.Ball _ball = new GUIElements.Ball(Color.GREEN);
	
	public static void main(String[] args) {
		Init app = new Init();
		app.init();
	}
	
	public void init() {
		GameFrame pong = new GameFrame(_autoplayer, _realplayer, _ball);
		
		AutomaticPlayer auto = new AutomaticPlayer(_autoplayer, _ball);
	}
}
