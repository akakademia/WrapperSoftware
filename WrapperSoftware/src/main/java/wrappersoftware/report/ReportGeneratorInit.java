package wrappersoftware.report;

import java.io.StringWriter;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class ReportGeneratorInit {

	public static void main(String[] args) {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.init();

		Template template = velocityEngine.getTemplate("src/main/java/wrappersoftware/report/template.vm");

		VelocityContext context = new VelocityContext();

		// tesztadatok
		String costumerName = "Interspar";
		String[] table1Header = new String[] { "Termék típusa", "Szélessége", "Magassága", "Súlya", "Űrtartalma",
				"Mennyiség" };
		String[] table2Header = new String[] { "Méretei", "Hullámvastagsága", "Súlyhatár", "Mennyiség" };
		String[] table3Header = new String[] { "Anyag", "Mennyiség", "Egységár", "Összesen" };
		String[] table1Content1 = new String[] { "Csatos", "10.6 cm", "16 cm", "0.77 kg", "1000.0 ml", "10 db" };
		String[] table1Content2 = new String[] { "Kerek díszüveg", "6.0 cm", "8.0 cm", "0.1 kg", "100.0 ml", "5 db" };
		String[] table2Content1 = new String[] { "200X200X100mm", "2,5 mm", "5 kg", "10 db" };
		String[] table2Content2 = new String[] { "150X100X50mm", "2,5 mm", "1 kg", "5 db" };
		String[][] table2Content = new String[][] { table2Content1, table2Content2 };
		String[] table3Content1 = new String[] { "Karton", "10 db", "200 Ft", "2000 Ft" };
		String[] table3Content2 = new String[] { "Matrica", "10 db", "100 Ft", "1000 Ft" };
		String[] table3Content3 = new String[] { "AirPlus", "10 db", "50 Ft", "500 Ft" };
		String[][] table3Content = new String[][] { table3Content1, table3Content2, table3Content3 };
		String[][] table1Content = new String[][] { table1Content1, table1Content2 };

		// propertiek létrehozása
		context.put("title", "A&K Packer Kft. - Wrapper Software (WS) rendelés összeállítva");
		context.put("costumer_name", costumerName);
		context.put("header", "A&K Packer Kft. - Wrapper Software (WS)");
		context.put("table_name1", "Megrendelés tartalma:");
		context.put("table_name2", "Doboz: ");
		context.put("table_name3", "Költségek:");
		context.put("table1_header", table1Header);
		context.put("table2_header", table2Header);
		context.put("table3_header", table3Header);
		context.put("table1_content", table1Content);
		context.put("table2_content", table2Content);
		context.put("table3_content", table3Content);

		StringWriter data = new StringWriter();
		template.merge(context, data);

		new FileMaker().writeOutDataToFile(data.toString(), "src/main/java/wrappersoftware/report", costumerName);
	}
}
