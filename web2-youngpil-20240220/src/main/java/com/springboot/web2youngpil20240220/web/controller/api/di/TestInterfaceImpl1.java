package com.springboot.web2youngpil20240220.web.controller.api.di;

import org.springframework.stereotype.Component;

@Component("t1")
public class TestInterfaceImpl1 implements TestInterface {

	@Override
	public void a() {
		System.out.println("테스트 인터페이스1에서 호출한 a메소드");
	}

	@Override
	public void b() {
		System.out.println("테스트 인터페이스1에서 호출한 b메소드");
	}

	
}
