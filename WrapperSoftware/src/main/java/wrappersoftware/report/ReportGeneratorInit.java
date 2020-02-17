package wrappersoftware.report;

import java.io.StringWriter;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import wrappersoftware.GlassyProduct;
import wrappersoftware.Order;
import wrappersoftware.Results;

public class ReportGeneratorInit {

	public static void main(String[] args) {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();

		Template template = velocityEngine.getTemplate("src/main/java/wrappersoftware/report/template.vm");

		VelocityContext context = new VelocityContext();

		// tesztadatok
		ArrayList<GlassyProduct> products = new ArrayList<GlassyProduct>();
		GlassyProduct e = new GlassyProduct("tea", 100, 200, 60, 50, 5);
		e.setAmountInOrder(10);
		GlassyProduct e2 = new GlassyProduct("méz", 100, 100, 800, 150, 15);
		e2.setAmountInOrder(15);
		products.add(e);
		products.add(e2);
		Order order = new Order();
		order.setDiscount(10);
		order.setProducts(products);

		Results calculationResult = new Results(order);
		ArrayList<GlassyProduct> productsInBox = calculationResult.getProductsFitInBox();
		ArrayList<GlassyProduct> productsNotPackable = calculationResult.getProductsNotPackable();

		String[][] productsInBoxFormatedList = new String[productsInBox.size()][6];
		String[][] productsNotPackableFormatedList = new String[productsNotPackable.size()][6];

		for (int i = 0; i < productsInBox.size(); i++) {

			productsInBoxFormatedList[i][0] = productsInBox.get(i).getName();
			productsInBoxFormatedList[i][1] = productsInBox.get(i).getWidth() + " mm";
			productsInBoxFormatedList[i][2] = productsInBox.get(i).getHeight() + " mm";
			productsInBoxFormatedList[i][3] = productsInBox.get(i).getWeight() + " g";
			productsInBoxFormatedList[i][4] = productsInBox.get(i).getVolume() + " ml";
			productsInBoxFormatedList[i][5] = productsInBox.get(i).getAmountInOrder() + " db";
		}

		System.out.println(productsNotPackable.size());
		System.out.println(productsNotPackable);

		for (int i = 0; i < productsNotPackable.size(); i++) {

			productsNotPackableFormatedList[i][0] = productsNotPackable.get(i).getName();
			productsNotPackableFormatedList[i][1] = productsNotPackable.get(i).getWidth() + " mm";
			productsNotPackableFormatedList[i][2] = productsNotPackable.get(i).getHeight() + " mm";
			productsNotPackableFormatedList[i][3] = productsNotPackable.get(i).getWeight() + " g";
			productsNotPackableFormatedList[i][4] = productsNotPackable.get(i).getVolume() + " ml";
			productsNotPackableFormatedList[i][5] = productsNotPackable.get(i).getAmountInOrder() + " db";
		}

		String costumerName = "Interspar";
		String[] productsHeader = new String[] { "Termék típusa", "Szélessége", "Magassága", "Súlya", "Űrtartalma",
				"Mennyiség" };
		String[] table2Header = new String[] { "Doboz", "Térkitöltő", "Matrica (kicsi)", "Matrica (nagy)" };
		String[] table3Header = new String[] { "Karton", "Matrica (kicsit)", "Matrica (nagy)", "Térkitöltő", "Összesen "+ order.getDiscount() +"% kedvezménnyel" };

		String[] table2content = new String[] {
				"" + calculationResult.getNeedfulCardboard() + " db",
				"" + calculationResult.getNeedfulAirplus() + " db",
				"" + (calculationResult.getNeedfulMatrixSheet())[0].calculateNeccesaryMatrixSheet() + " db",
				"" + (calculationResult.getNeedfulMatrixSheet())[1].calculateNeccesaryMatrixSheet() + " db"
				};
		
		String[] table3content = new String[] {
				"" + calculationResult.getNeedfulCardboardCost() + " Ft",
				"" + calculationResult.getNeedfulMatrixSheet()[0].calculatePrice() + " Ft",
				"" + calculationResult.getNeedfulMatrixSheet()[1].calculatePrice() + " Ft",
				"" + calculationResult.getNeedfulAirplusCost() + " Ft",
				"" + calculationResult.getSumCostWithDiscont() + " Ft"
		};

		// propertiek létrehozása
		context.put("title", "A&K Packer Kft. - Wrapper Software (WS) rendelés összeállítva");
		context.put("costumer_name", costumerName);
		context.put("header", "A&K Packer Kft. - Wrapper Software (WS)");

		context.put("content_of_order", "Megrendelés tartalma:");
		context.put("products_header", productsHeader);
		context.put("products_in_box", productsInBoxFormatedList);

		context.put("not_packable_header", "Nem csomagolható:");
		context.put("products_not_packable", productsNotPackableFormatedList);

		context.put("table_name2", "Felhasználandó mennyiségek: ");
		context.put("table2_header", table2Header);
		context.put("table2_content", table2content);
		

		context.put("table_name3", "Ár-Kalkuláció:");
		context.put("table3_header", table3Header);
		context.put("table3_content", table3content);

		StringWriter data = new StringWriter();
		template.merge(context, data);

		System.out.println(data);

		new FileMaker().writeOutDataToFile(data.toString(), "src/main/java/wrappersoftware/report", costumerName);
	}
}
