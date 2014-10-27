package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GUIElements {
	public static class Bat {
		// Bat is 6 cells high, 1 cell wide
		
		// runtime variables
		private Color _c;
		private Dimension _pos;
		private int _cellSize;
		
		public Bat(Color c) {
			_c = c;
		}
		
		
		
		public Color getColor() {
			return _c;
		}

		public void setColor(Color c) {
			_c = c;
		}

		public Dimension getPosition() {
			return _pos;
		}

		public void setPosition(Dimension pos) {
			_pos = pos;
		}

		public int getCellSize() {
			return _cellSize;
		}

		public void setCellSize(int cellSize) {
			_cellSize = cellSize;
		}

		
		
		public void drawElement(Graphics g) {
			g.setColor(_c);
			g.fillRect(_pos.width*_cellSize, _pos.height*_cellSize, _cellSize, 6*_cellSize);
		}
	}
	
	public static class Ball {
		// Ball is square
		
		// runtime variables
		private int _length = 1;
		private Color _c;
		private Dimension _pos;
		private int _cellSize;
		private float _velocity;
		private int _angle = 60;
		
		public Ball(Color c) {
			_c = c;
		}
		
		
		public int getLength() {
			return _length;
		}
		
		public void setLength(int length) {
			_length = length;
		}

		public Color getColor() {
			return _c;
		}

		public void setColor(Color c) {
			_c = c;
		}
		
		public Dimension getPosition() {
			return _pos;
		}

		public void setPosition(Dimension pos) {
			_pos = pos;
		}

		public int getCellSize() {
			return _cellSize;
		}
		
		public void setCellSize(int cellSize) {
			_cellSize = cellSize;
		}
		
		public float getVelocity(){
			return _velocity;
		}
		
		public void setVelocity(float velocity){
			_velocity = velocity;
		}

		public void drawElement(Graphics g) {
			g.setColor(_c);
			g.fillRect(_pos.width*_cellSize, _pos.height*_cellSize, _length * _cellSize, _length * _cellSize);
		}
	}
}
