package br.com.twmtecnologia.entities.graph;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@RelationshipEntity(type = "RATED")
public class Rating extends AbstractEntity{
	
	@StartNode
	Customer customer;
	@EndNode
	Product product;
	int stars;
	String comment;
}
