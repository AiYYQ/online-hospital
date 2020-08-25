package xyz.cfsaisi.utils;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	
	public static QueryRunner getQueryRunner() {
		return new QueryRunner(new ComboPooledDataSource());
	}
	

}
