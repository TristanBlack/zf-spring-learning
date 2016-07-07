package fz.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fz.bean.BlankDisc;
import fz.bean.TrackCounter;
import fz.proxy.TrackCounterConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {

	@Autowired
	private BlankDisc blankDisc;

	@Autowired
	private TrackCounter trackCounter;

	@Test
	public void testTrackCounter() {
		blankDisc.playTrack(1);
		blankDisc.playTrack(2);
		blankDisc.playTrack(0);
		blankDisc.playTrack(2);
		
		for (int i = 0; i < blankDisc.getTracks().size(); i++)
			System.out.println(
					blankDisc.getTracks().get(i) + " played " + trackCounter.getTrackCount(i).intValue() + " times");

		assertEquals(1, trackCounter.getTrackCount(1).intValue());
		assertEquals(3, trackCounter.getTrackCount(2).intValue());
		assertEquals(1, trackCounter.getTrackCount(0).intValue());

		/**
		 * spring AOP
		 * 是切面在应用运行的某个时刻被织入，在织入切面时，AOP容器(这里就是@ContextConfiguration注解中的对象)
		 * 会为目标对象动态地创建一个代理对象。在下面代码执行之前，已经动态创建好代理对象了，
		 * 目标对象是TrackCounterConfig中的bean(BlankDisc)， 所以下面代码中的对象不会被代理处理 BlankDisc
		 * cd2 = new BlankDisc(); List<String> tracks = new ArrayList<String>();
		 * tracks.add("光辉岁月"); tracks.add("晴天"); tracks.add("一路上有你");
		 * cd2.setTracks(tracks); cd2.playTrack(2);
		 **/

	}
}
