package com.test.collection;

import java.util.*;
import java.util.stream.Collectors;

public class SongsHistory {

	public static void main(String[] args) {
        List<Integer> songsPlayHistory = Arrays.asList(58,20,58,45,81,32,58,45,11,79,98,45,81,58,63);
        int limit = 3;
        
        System.out.println("Below are the Top Played "+limit+" Song IDs");
        System.out.println(getRepeatHistory(songsPlayHistory, limit));
    }
    
    private static List<Integer> getRepeatHistory(List<Integer> songsPlayHistory, int limit){
    	
    	List<Integer> repeatedSongsList = new ArrayList<>();
    	
    	if(null == songsPlayHistory || songsPlayHistory.isEmpty()) {
    		System.out.println("Provided Songs List is Empty or Null.");
    	} else {
    		Map<Integer, Integer> songsRepeatMap = new HashMap<>();
            for(int songId:songsPlayHistory){
                if(!songsRepeatMap.containsKey(songId)){
                    songsRepeatMap.put(songId, 1);
                } else {
                    songsRepeatMap.put(songId, (songsRepeatMap.get(songId) + 1));
                }
            }
            
            Map<Integer, Integer> sortedMap = sortMapByValues(songsRepeatMap);
            //System.out.println(sortedMap);
            
            if(limit <= 0) {
            	// Considering all Songs
            	limit = sortedMap.size();
            }
            Set<Integer> songIds = sortedMap.keySet();
            int count = 0;
            for(int songId:songIds){
                count++;
                if(count<=limit){
                    repeatedSongsList.add(songId);
                } else {
                    break;
                }
            }
    	}
    	
    	return repeatedSongsList;
    }
    
    private static Map<Integer, Integer> sortMapByValues(Map<Integer, Integer> inputMap){
    	Map<Integer, Integer> sortedMap = 
    			inputMap.entrySet().stream().sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
    			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e1,LinkedHashMap::new));
    	return sortedMap;
    }

}
