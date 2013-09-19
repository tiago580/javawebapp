package br.com.twmtecnologia.base.graph.entity;

import org.springframework.data.neo4j.annotation.GraphId;

public abstract class AbstractEntity {

	@GraphId
	private Long id;
	
}
