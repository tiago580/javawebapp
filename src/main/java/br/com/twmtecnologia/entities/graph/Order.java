package br.com.twmtecnologia.entities.graph;

import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@NodeEntity
public class Order extends AbstractEntity{
	
	@RelatedTo(type="ORDERED", direction = Direction.INCOMING)
	private Customer customer;
	@RelatedTo
	private Address billingAddress;
	@RelatedTo
	private Address shippingAddress;
	
	@Fetch
	@RelatedToVia
	private Set<LineItem> lineItems = new HashSet<LineItem>();

}
