package net.orangemile.informatica.powercenter.domain.constant;

public enum TableAttributeName {
	SQL_QUERY("Sql Query"),
    USER_DEFINED_JOIN("User Defined Join"),
    SOURCE_FILTER("Source Filter"),
    NUMBER_OF_SORTED_PORTS("Number Of Sorted Ports"),
    TRACING_LEVEL("Tracing Level"),
    SELECT_DISTINCT("Select Distinct"),
    IS_PARTITIONABLE("Is Partitionable"),
    PRE_SQL("Pre SQL"),
    POST_SQL("Post SQL"),
    OUTPUT_IS_DETERMINISTIC("Output is deterministic"),
    OUTPUT_IS_REPEATABLE("Output is repeatable");
	
	private String name;
	
	private TableAttributeName( String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}