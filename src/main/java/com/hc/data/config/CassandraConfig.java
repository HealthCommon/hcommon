/**
 * 
 */
package com.hc.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

/**
 * @author akjha
 *
 */
@Configuration
@EnableCassandraRepositories
@PropertySource(value= {"classpath:cassandra.properties"})
public class CassandraConfig /*extends AbstractCassandraConfiguration */{
	
	/*private static final String KEYSPACE = "cassandra.keyspace";
	
	@Autowired
	private Environment environment;
	
	@Override
	public String getContactPoints() {
		return "localhost";
	}
	
	@Override
	protected String getKeyspaceName() {
		return environment.getProperty(KEYSPACE);
	}*/

}
