package practicealone;

public class Car {
	Tire frontLeftTire = new HankookTire();
	Tire frontRightTire = new HankookTire();
	Tire backLeftTire = new HankookTire();
	Tire backRighttTire = new HankookTire();
	//인터페이스 타입의 필드 선언 & 초기 구현 객체 대입.
	
	void run() {
		frontLeftTire.roll();
		frontRightTire.roll();
		backLeftTire.roll();
		backRighttTire.roll();
		//인터페이스에서 기술된 roll()메소드 호출.
	}
}
