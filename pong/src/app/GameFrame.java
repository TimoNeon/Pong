package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.GUIElements.Ball;
import app.GUIElements.Bat;

public class GameFrame implements Runnable {
	
	// Implementation of constants
	public static final Dimension FRAME_SIZE = new Dimension(650, 600);
	// TODO make variable
	public int cellSize = 10;
	
	//keys
	boolean key_up = false, key_down = false;
	
	GUIElements.Bat _autoplayer;
	GUIElements.Bat _realplayer;
	GUIElements.Ball _ball;
	
	//Draw Panel
	DrawPanel drawer = new DrawPanel();
	
	public static final int TIMEOUT = Init.TIMEOUT;
	
	// Runtime variables
	private JFrame _frame = new JFrame();
	
	public GameFrame(Bat autoplayer, Bat realplayer, Ball ball) {
		this._autoplayer = autoplayer;
		this._realplayer = realplayer;
		this._ball = ball;
		
		// create frame
		_frame.setVisible(true);
		_frame.setContentPane(drawer);
		_frame.setSize(FRAME_SIZE);
		_frame.setResizable(false);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				int keyCode = e.getKeyCode();
				
				if(keyCode==KeyEvent.VK_W) key_down = true; //W_Key is pressed = Bat down
				else if(keyCode==KeyEvent.VK_S) key_up = true; //S_Key is pressed = Bat up
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				int keyCode = e.getKeyCode();
				
				if(keyCode==KeyEvent.VK_W) key_down = false; //W_Key is released
				else if(keyCode==KeyEvent.VK_S) key_up = false; //S_Key is released
			}
		});
		
		// set initial bats position
		_autoplayer.setPosition(new Dimension(0, 27));
		_realplayer.setPosition(new Dimension(64, 27));
		_ball.setPosition(new Dimension(32, 30));
		
		_autoplayer.setCellSize(getCellSize());
		_realplayer.setCellSize(getCellSize());
		_ball.setCellSize(getCellSize());
	}

	@Override
	public void run() {
		while(true) {
			try {
				handleKeys();
				drawer.repaint();
				
				Thread.sleep(TIMEOUT);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void handleKeys(){
		if(key_up){
			_realplayer.setPosition(new Dimension(_realplayer.getPosition().width, _realplayer.getPosition().height+1));
		}else if(key_down){
			_realplayer.setPosition(new Dimension(_realplayer.getPosition().width, _realplayer.getPosition().height-1));
		}
	}
	
	public int getCellSize(){
		return cellSize;
	}
	
	private class DrawPanel extends JPanel{
		@Override
		public void paintComponent(Graphics g) {
			int width = getWidth();
			int height = getHeight();
		
			//Background
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, width, height);
			
			//Bats
			_realplayer.drawElement(g);
			_autoplayer.drawElement(g);
			
			//Ball
			_ball.drawElement(g);
		}
	}
}
