package br.com.twmtecnologia.entities.graph;

import org.springframework.data.neo4j.annotation.GraphProperty;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@NodeEntity
public class Tag extends AbstractEntity{

	@Indexed(unique = true)
	String name;
	@GraphProperty
	Object value;
}
