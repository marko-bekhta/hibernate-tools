package org.hibernate.tool.orm.jbt.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hibernate.tool.internal.reveng.strategy.TableFilter;
import org.hibernate.tool.orm.jbt.internal.factory.TableFilterWrapperFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TableFilterWrapperTest {

	private TableFilter wrappedTableFilter = null;
	private TableFilterWrapper tableFilterWrapper = null;
	
	@BeforeEach
	public void beforeEach() {
		wrappedTableFilter = new TableFilter();
		tableFilterWrapper = TableFilterWrapperFactory.createTableFilterWrapper(wrappedTableFilter);
	}
	
	@Test
	public void testConstruction() {
		assertNotNull(wrappedTableFilter);
		assertNotNull(tableFilterWrapper);
	}
	
	@Test
	public void testSetExclude() {
		assertNull(wrappedTableFilter.getExclude());
		tableFilterWrapper.setExclude(true);
		assertTrue(wrappedTableFilter.getExclude());
	}
	
	@Test
	public void testSetMatchCatalog() {
		assertNotEquals("foo", wrappedTableFilter.getMatchCatalog());
		tableFilterWrapper.setMatchCatalog("foo");
		assertEquals("foo", wrappedTableFilter.getMatchCatalog());
	}
		
	@Test
	public void testSetMatchSchema() {
		assertNotEquals("foo", wrappedTableFilter.getMatchSchema());
		tableFilterWrapper.setMatchSchema("foo");
		assertEquals("foo", wrappedTableFilter.getMatchSchema());
	}
		
	@Test
	public void testSetMatchName() {
		assertNotEquals("foo", wrappedTableFilter.getMatchName());
		tableFilterWrapper.setMatchName("foo");
		assertEquals("foo", wrappedTableFilter.getMatchName());
	}
		
	@Test
	public void testGetExclude() {
		assertNull(tableFilterWrapper.getExclude());
		wrappedTableFilter.setExclude(true);
		assertTrue(tableFilterWrapper.getExclude());
	}
		
}
