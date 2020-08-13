package com.meet.exeptionHandler;

public class StudentNotFoudExeption extends RuntimeException {

	public StudentNotFoudExeption() {
	}

	public StudentNotFoudExeption(String arg0) {
		super(arg0);
	}

	public StudentNotFoudExeption(Throwable arg0) {
		super(arg0);
	}

	public StudentNotFoudExeption(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public StudentNotFoudExeption(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
