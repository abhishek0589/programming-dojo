package com.abhishek.dojo.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Questions- 
// what happens when top competitors are more than unique brands mentioned in the review?

public class TopNCompetitors {

	class Competitor{
		String name; int count;
		Competitor(String name, int count){
			this.name = name;
			this.count = count;
		}
	}

	public List<String> getTopNCompetitors(int numCompetitors, int topNCompetitors, String[] competitors,  int numReviews, String[] reviews){
		List<String> result = new ArrayList<>();
		List<Competitor> compsWithReviews = new ArrayList<>(numCompetitors);
		for (String comp : competitors) compsWithReviews.add(new Competitor(comp, 0));
		compsWithReviews.stream().forEach(comp -> countReviewsForEveryCompetitor(reviews, comp));
		Collections.sort(compsWithReviews, (c1, c2) -> c1.count != c2.count ? c2.count - c1.count : c1.name.compareTo(c2.name));
		// consider only authors with atleast 1 review
		int reviewCount = compsWithReviews.parallelStream().filter(x -> x.count > 0).collect(Collectors.toList()).size();
		for (int i = 0; i < reviewCount && i < topNCompetitors; i++) 
			result.add(compsWithReviews.get(i).name);
		return result;
	}

	private void countReviewsForEveryCompetitor(String[] reviews, Competitor comp) {
		for (String review : reviews)
			if (review.toLowerCase().contains(comp.name.toLowerCase())) 
				comp.count++;
	}

	public static void main(String[] args) {
		int numCompetitors = 6;
		int topNCompetitors = 2;
		String[] competitors = {"newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular"};
		int numReviews = 6;
		String[] reviews = {
				"newshop is providing good service in the city; everyone should use newshop",
				"best services by newshop",
				"fashionbeats has great services in the city",
				"Im proud to have fashionbeats",
				"afshion has awesome service",
				"thanks newshop for the quick delivery"
		};
	
		TopNCompetitors t = new TopNCompetitors();
		t.getTopNCompetitors(numCompetitors, topNCompetitors, competitors, numReviews, reviews).forEach(x -> System.out.println(x));
	}

}
