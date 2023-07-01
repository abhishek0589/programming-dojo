package com.abhishek.pattern.builder;

import java.util.Date;

public class DatabaseFactory {
	public static Database getOracleDB() {
		return new Database.Builder()
				.name("Oracle")
				.type("relational")
				.isNoSQL(false)
				.releaseDate(new Date())
				.build();
	}

	public static Database getCassandraDB() {
		return new Database.Builder()
				.name("Cassandra")
				.type("NoSQL")
				.isNoSQL(true)
				.releaseDate(new Date())
				.build();
	}
}
	