package app;

import java.awt.Color;

public class Init {
	
	GUIElements.Bat _autoplayer = new GUIElements.Bat(Color.GREEN);
	GUIElements.Bat _realplayer = new GUIElements.Bat(Color.GREEN);
	GUIElements.Ball _ball = new GUIElements.Ball(Color.GREEN);
	
	public static void main(String[] args) {
		new Init();
	}
	
	public Init() {
		GameFrame pong = new GameFrame(_autoplayer, _realplayer, _ball);
	}
}
