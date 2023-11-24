package com.valtech.training.mobileranking;

import java.util.List;
import java.util.Map;

public interface MobileRankingService {

	public List<String> rankMobiles(Map<String, Integer> phoneScores);

}