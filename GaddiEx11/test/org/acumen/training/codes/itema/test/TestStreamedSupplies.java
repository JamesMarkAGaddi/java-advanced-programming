package org.acumen.training.codes.itema.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.acumen.training.codes.itema.StreamedSupplies;
import org.acumen.training.codes.itema.StreamedSupplies.Supply;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStreamedSupplies {

	StreamedSupplies supplies;

	@BeforeEach
	public void setup() {
		supplies = new StreamedSupplies();
		supplies.addSupply(new Supply("PO788-1", 56.00, 78999, "Johnson and Johnson", "Jimmy Yu"));
		supplies.addSupply(new Supply("WER23-9", 78.23, 456, "ACG Mfg.", "Edward Lao"));
		supplies.addSupply(new Supply("TYTF23-0", 98.5, 767567, "YKLMN Mfg.", "Cathy Koo"));
		supplies.addSupply(new Supply("G009G-1", 23.7, 454, "Toyota", "Gary"));
		supplies.addSupply(new Supply("IOP890-2", 56.3, 34, "Honda", "Nathan Welsh"));
		supplies.addSupply(new Supply("BHN987-3", 21.2, 367, "Wiley and Sons", "Joey Dim"));
	}

	@AfterEach
	public void teardown() {
		supplies = null;
	}

	@Test
	public void testGetStreamProducts() {
		List<String> expected = Arrays.asList("TYTF23-0 (767567)", "PO788-1 (78999)");
		
		List<String> result = supplies.getStreamProducts();
		System.out.print("Product/s with 500+ supplies: ");
		System.out.println(result);
		assertEquals(expected, result);
	}

	@Test
	public void testListStreamToyota() {
		System.out.print("Toyota product/s: ");
		supplies.listStreamToyota();
	}

	@Test
	public void testGetStreamSupplyTotal() {
		int total = supplies.getStreamSupplyTotal();
		System.out.println("Total supply: %d".formatted(total));
		assertEquals(847877, total);
	}

	@Test
	public void testGetCostPrintNoExpectedThrow() {

		assertDoesNotThrow(() -> {
			double cost = supplies.getCostPrint("PO788-1", 2);
			System.out.println("Total cost: %.2f".formatted(cost));
		});
	}

	@Test
	public void testgetCostPrintExpectedThrow() {
		assertThrows(StreamedSupplies.InvalidInquiryException.class, () -> {
			double cost = supplies.getCostPrint("Invalid_ID", 2);
			System.out.println("Total cost: %.2f".formatted(cost));
		});
	}

	@Test
	public void testDumpAllSupply() {
		assertDoesNotThrow(() -> {
			supplies.dumpAllSupply("supply.txt");
		});
	}
	
}
