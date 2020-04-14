package com.example.demo;

import com.example.annotion.Color;
import com.example.vo.Apple;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.AfterTestMethod;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.statements.SpringRepeat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@SpringBootTest(classes = DemoApplication.class)
@RunWith(SpringRunner.class)
public class DemoApplicationTests {

	@Before
	public void before(){
		System.out.println("method before..........");
	}

	@Test
	public void getAnnotionValue() throws Exception{
		// 创建对象
		Apple apple = new Apple();
		apple.setName("苹果一");
		apple.setPrice(2.12);

		Field name = apple.getClass().getDeclaredField("name");
		Color color = name.getAnnotation(Color.class);

		System.out.println("苹果的颜色:"+color.value());


	}

	@After
	public void after(){
		System.out.println("method after.........");
	}

}
