package br.com.twmtecnologia.entities.graph;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.fieldaccess.DynamicProperties;
import org.springframework.data.neo4j.fieldaccess.PrefixedDynamicProperties;
import org.springframework.data.neo4j.support.index.IndexType;

import br.com.twmtecnologia.base.graph.entity.AbstractEntity;

@NodeEntity
public class Product extends AbstractEntity{

	@Indexed(unique = true)
	private String name;
	@Indexed(indexType = IndexType.FULLTEXT, indexName = "search")
	private String description;
	private BigDecimal price;
	
	@RelatedTo
	private Set<Tag> tags = new HashSet<Tag>();
	private DynamicProperties attributes = new PrefixedDynamicProperties("attributes");
	
}
