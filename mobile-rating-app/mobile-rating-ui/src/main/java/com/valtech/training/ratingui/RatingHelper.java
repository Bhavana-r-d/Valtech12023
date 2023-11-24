package com.valtech.training.ratingui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.valtech.training.mobileranking.MobileRankingService;
import com.valtech.training.mobileranking.MobileRankingServiceImpl;
import com.valtech.training.patternchecker.PatternCheckerService;
import com.valtech.training.patternchecker.PatternCheckerServiceImpl;

public class RatingHelper {
//	public int getRating(Map<String, Integer> mobile) {
//		return mobRankService.rankMobiles(mobile);
//	}
	
	public int rankNumber(List<String> numbers,String number) {
		PatternCheckerService patternChecker=new PatternCheckerServiceImpl();
		Map<String,Integer> phoneNumberScores=patternChecker.checkPatterns(numbers);
		return phoneNumberScores.get(number);
	}
	
	public static void rankingNumbers() {
		List<String> phoneNumbers = Arrays.asList("1234567890", "2345678901", "3456789012", "4567890123", "5678901234",
				"6789054321", "7890123456", "8901234567", "9012345678", "0123456789");
		
		PatternCheckerService patternChecker=new PatternCheckerServiceImpl();
		Map<String,Integer> phoneNumberScores=patternChecker.checkPatterns(phoneNumbers);
		System.out.println(phoneNumberScores);
		
		MobileRankingService mobileRanker=new MobileRankingServiceImpl();
		List<String> rankedMobileNumbers=mobileRanker.rankMobiles(phoneNumberScores);
		System.out.println(rankedMobileNumbers);
	}
	
	public static void main(String[] args) {
		rankingNumbers();
	}
}

//7dedd55d5d9340efa789ace6bdc29034