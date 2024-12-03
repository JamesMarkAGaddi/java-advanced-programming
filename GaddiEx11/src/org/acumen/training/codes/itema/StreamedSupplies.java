package org.acumen.training.codes.itema;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamedSupplies {

	private final List<Supply> supplies;

	public record Supply(String productId, Double unitPrice, 
							Integer supply, String supplier, String contact) {
	}

	public StreamedSupplies() {
		supplies = new ArrayList<>();
	}

	public void addSupply(Supply supply) {
		supplies.add(supply);
	}

	public List<String> getStreamProducts() {
		return supplies.stream()
					   .filter(s -> s.supply() > 500)
					   .sorted(Comparator.comparing(Supply::supply).reversed())
					   .map(s -> String.format("%s (%d)", s.productId(), s.supply()))
					   .collect(Collectors.toList());
	}
	
	public void listStreamToyota() {
		supplies.stream()
				.filter(s -> s.supplier().equalsIgnoreCase("Toyota"))
				.forEach(s -> System.out.println(s.productId()));
	}

	public int getStreamSupplyTotal() {
		return supplies.stream()
					   .mapToInt(Supply::supply)
					   .sum();
	}

	public double getCostPrint(String prodId, int qty) throws InvalidInquiryException, Exception {
		return supplies.stream()
					   .filter(s -> s.productId().equalsIgnoreCase(prodId))
					   .findFirst()
					   .map(s -> s.unitPrice() * qty)
					   .orElseThrow(() -> new InvalidInquiryException());
	}

	public void dumpAllSupply(String filename) throws IOException, Exception {
		Path path = Path.of(filename);
		Charset charSet = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(path, charSet, 
			StandardOpenOption.CREATE)) {
			for (Supply s : supplies) {
				writer.write(s.toString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	public class InvalidInquiryException extends Exception {
		private static final long serialVersionUID = 1L;

		public InvalidInquiryException() {
			System.out.println("Product does not exist");
		}
	}

}
