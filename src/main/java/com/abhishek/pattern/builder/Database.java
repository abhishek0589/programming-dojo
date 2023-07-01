package com.abhishek.pattern.builder;

import java.util.Date;

// 1. Private constructor
// 2. Variables are copy pasted in builder
// 3. Every method returns this
// 4. Got build method that returns callers object

public class Database {
	
	public static class Builder {
		private String name;
		private String type; // columnar, wide-colum, row
		private Date releaseDate;
		private boolean isNoSQL;

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder type(String type) {
			this.type = type;
			return this;
		}

		public Builder isNoSQL(boolean isNoSQL) {
			this.isNoSQL = isNoSQL;
			return this;
		}

		public Builder releaseDate(Date releaseDate) {
			this.releaseDate = releaseDate;
			return this;
		}
		
		public Database build() {
			Database d = new Database();
			d.name = this.name;
			d.type = this.type;
			d.isNoSQL = this.isNoSQL;
			d.releaseDate = this.releaseDate;
			return d;
		}
	}

	private String name;
	private String type; // columnar, wide-colum, row
	private Date releaseDate;
	private boolean isNoSQL;

	@Override
	public String toString() {
		return "Database [name=" + name + ", type=" + type + ", releaseDate=" + releaseDate + ", isNoSQL=" + isNoSQL
				+ "]";
	}

	public Database() {
	}

	public static void main(String[] args) {
		Database d = DatabaseFactory.getOracleDB();
		System.out.println(d.toString());
		d = DatabaseFactory.getCassandraDB();
		System.out.println(d.toString());
	}
}
