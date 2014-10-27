package app;

import java.awt.Dimension;

import app.GUIElements.Ball;
import app.GUIElements.Bat;

public class AutomaticPlayer implements Runnable {
	
	private static final int INTERVAL = 500;
	
	private GUIElements.Bat _autoplayer;
	private GUIElements.Ball _ball;
	
	public AutomaticPlayer(GUIElements.Bat autoplayer, GUIElements.Ball ball) {
		_autoplayer = autoplayer;
		_ball = ball;
		run();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if(_ball.getVelocity() < 0) {
					// Ball moves to bat
					
				}
				else {
					// ball moves in opposite direction
					// move bat in the center
					// if the ball is not already in the center (=27)
					if(_autoplayer.getPosition().height < 27) {
						// move bat down
						_autoplayer.setPosition(new Dimension(
								_autoplayer.getPosition().width,
								_autoplayer.getPosition().height++
								));
					} else if(_autoplayer.getPosition().height > 27) {
						// move bat up
						_autoplayer.setPosition(new Dimension(
							_autoplayer.getPosition().width,
							_autoplayer.getPosition().height--
							));
					}
				}
				
				Thread.sleep(INTERVAL);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}