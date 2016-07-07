package fz.bean;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	
	private Map<Integer, Integer> trackCounts = new HashMap<Integer, Integer>();
	
	@Pointcut("execution(* fz.bean.BlankDisc.playTrack(int)) && args(trackNumber)")
	public void trackPlayed(int trackNumber){
		
	} 
	
	@Before("trackPlayed(trackNumber)")
	public void countTrack(int trackNumber){
		Integer trackCount = getTrackCount(trackNumber);
		trackCounts.put(trackNumber, trackCount + 1);
		System.out.print("recording play times ...... ");
	}
	
	public Integer getTrackCount(int trackNumber){
		return trackCounts.containsKey(trackNumber) ? trackCounts.get(trackNumber) : 0;
	}
}
