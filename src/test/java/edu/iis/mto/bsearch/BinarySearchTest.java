package edu.iis.mto.bsearch;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BinarySearchTest {
	
	static final int elem = 42;
	
	@Test
	public void wyszukajIstniejacyElementWSekwencjiJednoelementowej() {
		int seq[] = { elem };
		SearchResult res = BinarySearch.search(elem, seq);
		assertFound(res, seq);
	}
	
	@Test
	public void wyszukajNieistniejacyElementWSekwencjiJednoelementowej() {
		int seq[] = { 123 };
		SearchResult res = BinarySearch.search(elem, seq);
		assertNotFound(res);
	}
	
	@Test
	public void wyszukajElementIstniejacyJakoPierwszyWSekwencjiWieloelementowej() {
		int seq[] = { elem, 100, 200, 300 };
		SearchResult res = BinarySearch.search(elem, seq);
		assertFound(res, seq);
	}
	
	@Test
	public void wyszukajElementIstniejacyJakoOstatniWSekwencjiWieloelementowej() {
		int seq[] = { 1, 2, 3, elem };
		SearchResult res = BinarySearch.search(elem, seq);
		assertFound(res, seq);
	}
	
	@Test
	public void wyszukajElementIstniejacyWSrodkuSekwencjiWieloelementowej() {
		int seq[] = { 1, 2, 3, elem, 100, 200, 300 };
		SearchResult res = BinarySearch.search(elem, seq);
		assertFound(res, seq);
	}
	
	@Test
	public void wyszukajNieistniejacyElementWSekwencjiWieloelementowej() {
		int seq[] = { 1, 2, 3, 100, 200, 300 };
		SearchResult res = BinarySearch.search(elem, seq);
		assertNotFound(res);
	}
	
	void assertNotFound(SearchResult res) {
		assertThat(res.isFound(), is(false));
		assertThat(res.getPosition(), is(-1));
	}
	
	void assertFound(SearchResult res, int[] seq) {
		assertThat(res.isFound(), is(true));
		assertThat(seq[res.getPosition()], is(elem));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void wyszukajWPustejSekwencji() {
		int seq[] = {};
		BinarySearch.search(elem, seq);
	}
	
	@Test
	public void nieZnajdzieElementuWNieposortowanejSekwencji() {
		int seq[] = { 5, 4, 3, 2, 1 };
		SearchResult result = BinarySearch.search(4, seq);
		assertThat(result.isFound(), is(false));
	}
	
	@Test
	public void nibyTest() {
		// zeby byla zmiana w repo
		int r = 5;
		assertThat(r, is(r));
	}

}
