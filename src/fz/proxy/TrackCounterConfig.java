package fz.proxy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import fz.bean.BlankDisc;
import fz.bean.TrackCounter;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {

	@Bean
	public BlankDisc sgtPeppers() {
		BlankDisc cd2 = new BlankDisc();
		List<String> tracks = new ArrayList<String>();
		tracks.add("光辉岁月");
		tracks.add("晴天");
		tracks.add("一路上有你");
		tracks.add("约定");
		cd2.setTracks(tracks);
		return cd2;
	}

	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
	}
}
