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
	
	@Test
	public void nieMaWSekwencji1() {
		int seq[] = { 123 };
		SearchResult res = BinarySearch.search(456, seq);
		assertThat(res.isFound(), is(false));
		assertThat(res.getPosition(), is(-1));
	}
	
	@Test
	public void jestPierwszyWDlugiejSekwencji() {
		int elem = 42;
		int seq[] = { elem, 100, 200, 300 };
		SearchResult res = BinarySearch.search(elem, seq);
		assertThat(res.isFound(), is(true));
		assertThat(res.getPosition(), is(0));
	}
	
	@Test
	public void jestOstatniWDlugiejSekwencji() {
		int elem = 42;
		int seq[] = { 1, 2, 3, elem };
		SearchResult res = BinarySearch.search(elem, seq);
		assertThat(res.isFound(), is(true));
		assertThat(res.getPosition(), is(seq.length - 1));
	}

}
