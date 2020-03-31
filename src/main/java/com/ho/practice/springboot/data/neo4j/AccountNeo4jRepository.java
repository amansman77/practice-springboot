package com.ho.practice.springboot.data.neo4j;

import java.util.List;

public interface AccountNeo4jRepository /* extends Neo4jRepository<Account, Long> */ {

	List<Account> findByUsername(String username);
}
