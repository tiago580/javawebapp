package br.com.twmtecnologia.entities.graph;

import org.springframework.data.neo4j.annotation.NodeEntity;

import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@NodeEntity
public class Address extends AbstractEntity{
	private String street;
	private String city;
	private Country country;
}
