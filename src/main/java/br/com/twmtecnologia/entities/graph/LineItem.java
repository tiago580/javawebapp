package br.com.twmtecnologia.entities.graph;

import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@RelationshipEntity(type = "ITEMS")
public class LineItem extends AbstractEntity{
	@StartNode
	private Order order;
	@Fetch
	@EndNode
	private Product product;
	private int amount;
	
}
