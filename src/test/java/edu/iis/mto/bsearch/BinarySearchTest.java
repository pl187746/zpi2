package edu.iis.mto.bsearch;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearchTest {
	
	@Test
	public void jestWSekwencji1() {
		int elem = 42;
		int seq[] = { elem };
		SearchResult res = BinarySearch.search(elem, seq);
		assertThat(res.isFound(), is(true));
		assertThat(res.getPosition(), is(0));
	}

}
