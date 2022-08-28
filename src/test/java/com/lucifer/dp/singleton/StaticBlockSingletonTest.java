package com.lucifer.dp.singleton;

import com.lucifer.dp.factory.FactoryUseNameSpace;
import com.lucifer.dp.shape.Circle;
import com.lucifer.dp.shape.Shape;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;


@RunWith(PowerMockRunner.class)
@PrepareForTest({StaticBlockSingleton.class})
public class StaticBlockSingletonTest {

	private List<String> shapeNames;
	
	@Before
	public void setUp() throws Exception {
		shapeNames = Arrays.asList("Circle", "Ellipse", "Rectangle", "Square", "Triangle");
		
	}

	@Test
	public void testSingleton() {
		FactoryUseNameSpace fus = StaticBlockSingleton.getInstance();
		
		shapeNames.forEach(n -> {
			try {
				fus.create(n).get().draw();
			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		
	}
	
	@Test
	public void testPowerMock() {
		mockStatic(StaticBlockSingleton.class);
		FactoryUseNameSpace fus = mock(FactoryUseNameSpace.class);
		Circle c = new Circle();
		
		try {
			when(StaticBlockSingleton.getInstance()).thenReturn(fus);
			when(fus.create(Mockito.anyString())).thenReturn(Optional.of(c));

			Optional<Shape> s1 = StaticBlockSingleton.getInstance().create("Circle");
			assertEquals(s1.getClass(), Circle.class);
			
			Optional<Shape> s2 = StaticBlockSingleton.getInstance().create("XXX");
			assertEquals(s2.getClass(), Circle.class);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
