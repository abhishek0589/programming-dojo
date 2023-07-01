package org.abhishek.dojo.java8.streams;

import java.net.URISyntaxException;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsPractice {

	public static void main(String[] args) throws URISyntaxException {
		
		
		Instant start = Instant.now();
		
		Set<Article> articles = Article.readAll();

		System.out.println("Using streams => ");

		// count number of articles in file
		System.out.println("count = " + articles.stream().count());

		// oldest article
		int oldest = articles.stream().
				filter(article -> article.getInceptionYear() > 1900)
				.map(Article::getInceptionYear)
				.min(Comparator.naturalOrder())
				.get();		

		System.out.println("Oldest article = " + oldest);

		// newest article
		int newest = articles.stream()
				.filter(article -> article.getInceptionYear() > 1900)
				.map(Article::getInceptionYear)
				.max(Comparator.naturalOrder())
				.get();		

		System.out.println("Newest article = " + newest);

		// summary statistics
		IntSummaryStatistics summaryStatistics = articles.stream()
				.filter(article -> article.getInceptionYear() > 1900)
				.mapToInt(Article::getInceptionYear)
				.summaryStatistics();

		System.out.println("summaryStatistics = " + summaryStatistics);

		// doing same with the help of comparator
		System.out.println("Using collectors => ");
		// count number of articles in file
		System.out.println("count = " + articles.stream().collect(Collectors.counting()));

		// oldest article
		oldest = articles.stream().
				filter(article -> article.getInceptionYear() > 1900)
				.map(Article::getInceptionYear)
				.collect(Collectors.minBy(Comparator.naturalOrder()))
				.get();		

		System.out.println("Oldest article using Collectors.minBy(Comparator.naturalOrder())  = " + oldest);
		
		oldest = articles.stream().
				filter(article -> article.getInceptionYear() > 1900)
				.collect(Collectors.minBy(Comparator.comparing(Article::getInceptionYear)))
				.get().getInceptionYear();		
		
		System.out.println("Oldest article using Collectors.minBy(Comparator.comparing(Article::getInceptionYear))= " + oldest);

		// newest article
		newest = articles.stream()
				.filter(article -> article.getInceptionYear() > 1900)
				.map(Article::getInceptionYear)
				.collect(Collectors.maxBy(Comparator.naturalOrder()))
				.get();	

		System.out.println("Newest article = " + newest);


		// summary statistics
		summaryStatistics = articles.stream()
				.filter(article -> article.getInceptionYear() > 1900)
				.collect(Collectors.summarizingInt(Article::getInceptionYear));

		System.out.println("summaryStatistics = " + summaryStatistics);

		
		Function<? super Article, ? extends String> mapper = Article::getTitle;
		
		mapper = new Function<Article, String>() {
			@Override
			public String apply(Article article) {
				return article.getTitle();
			};
		};
		
		mapper = article -> article.getTitle();
		
		
		String articles1960 = articles.stream().
				filter(article -> article.getInceptionYear() == 1960)
				.map(mapper)
				.collect(Collectors.joining(","));
		
		System.out.println("articles1960 = " + articles1960);
		
		Map<Integer, Long> articlespublishedPerYear = 
				articles.stream()
				.filter(article -> article.getInceptionYear() > 1900)
				.collect(Collectors.groupingBy(
						Article::getInceptionYear, Collectors.counting())
						);
		System.out.println("yearVsArticlesPublished = " + articlespublishedPerYear);
		
		// find year with max numbers of articles published
		Entry<Integer, Long> maxNumberOfArticlesPublishedInYear= 
				articlespublishedPerYear.entrySet().stream()
				.max(Map.Entry.comparingByValue())
				.get();
		
		System.out.println("yearWithMaxArticles = " + maxNumberOfArticlesPublishedInYear.getKey());
		
		maxNumberOfArticlesPublishedInYear= 
				articlespublishedPerYear.entrySet().stream()
				.collect(Collectors.maxBy(Comparator.comparing(entry -> entry.getValue())))
				.get();
		
		System.out.println("yearWithMaxArticles = " + maxNumberOfArticlesPublishedInYear);
		
		// invert the map
		// not very readable process
		Entry<Long, List<Entry<Integer, Long>>> allMaxes = 
		articlespublishedPerYear.entrySet().stream() // Stream<Map.Entry<Integer, Long>>
			.collect(Collectors.groupingBy(entry -> entry.getValue())) //Map<Long, List<Integer>>
			.entrySet().stream() //Stream<Map<Long, List<Integer>>>
			.collect(Collectors.maxBy(Comparator.comparing(entry -> entry.getKey())))
			.get();
		
		System.out.println("allMaxes = " + allMaxes);
		
		
		// Get number of articles each author has published
		// use identity for grouping by if you need to group by exiting class only
		
		// author vs number of articles
		Map<Author, Long> articlesPerAuthor = 
				articles.stream()
				.flatMap(article -> article.getAuthors().stream()) // flat map's function takes T as input and V's stream as output
				.collect(Collectors.groupingBy(
						Function.identity(), Collectors.counting()
						));
		
		System.out.println("articlesPerAuthor = " + articlesPerAuthor);
		
		// which author wrote most number of articles
		Entry<Author, Long> authorWithMaxArticle = articlesPerAuthor.entrySet().stream()
												.collect(Collectors.maxBy(Comparator.comparing(entry -> entry.getValue()))).get();
		System.out.println("authorWithMaxArticle = " + authorWithMaxArticle);
		
		authorWithMaxArticle = articlesPerAuthor.entrySet().stream()
				.max(Comparator.comparing(entry -> entry.getValue())).get();
		System.out.println("authorWithMaxArticle = " + authorWithMaxArticle);
		
		System.out.println(
				"time taken to run all functions = " + Duration.between(start, Instant.now()).toMillis() / 1000);
	}
}
