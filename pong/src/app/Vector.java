package app;

public class Vector {
	float _vX,
		  _vY;
	
	public Vector() {
		_vX = 0;
		_vY = 0;
	}
	
	public Vector(float vX, float vY) {
		_vX = vX;
		_vY  = vY;
	}

	
	public float getVX() {
		return _vX;
	}

	public void setVX(float vX) {
		_vX = vX;
	}

	public float getVY() {
		return _vY;
	}

	public void setVY(float vY) {
		_vY = vY;
	}
}
