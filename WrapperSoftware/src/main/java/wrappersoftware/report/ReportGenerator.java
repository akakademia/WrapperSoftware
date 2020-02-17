
package wrappersoftware.report;

import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import wrappersoftware.GlassyProduct;
import wrappersoftware.Results;

public class ReportGenerator {

    private Results calculationResult;
    private String costumerName;

    public ReportGenerator(Results calculationResult, String costumerName) {
        this.calculationResult = calculationResult;
        this.costumerName = costumerName;
    }

    public void generateReport() {
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.init();

        Template template = velocityEngine.getTemplate("src/main/java/wrappersoftware/report/template.vm");

        VelocityContext context = generateContext();

        StringWriter data = new StringWriter();

        template.merge(context, data);

        new FileMaker().writeOutDataToFile(data.toString(), "src/main/java/wrappersoftware/report", costumerName);

    }

    private VelocityContext generateContext() {
        String[][] productsInBoxFormatedList = convertArrayList(calculationResult.getProductsFitInBox());
        String[][] productsNotPackableFormatedList = convertArrayList(calculationResult.getProductsNotPackable());

        String[] productsHeader = new String[]{"Termék típusa", "Szélessége", "Magassága", "Súlya", "Űrtartalma",
            "Mennyiség"};
        String[] table2Header = new String[]{"Doboz", "Térkitöltő", "Matrica (kicsi)", "Matrica (nagy)"};
        String[] table3Header = new String[]{"Karton", "Matrica (kicsit)", "Matrica (nagy)", "Térkitöltő", "Összesen " + calculationResult.getDiscount() + "% kedvezménnyel"};

        String[] table2content = new String[]{
            "" + calculationResult.getNeedfulCardboards() + " db",
            "" + calculationResult.getNeedfulAirplus() + " db",
            "" + (calculationResult.getNeedfulMatrixSheets())[0].calculateNeccesaryMatrixSheet() + " db",
            "" + (calculationResult.getNeedfulMatrixSheets())[1].calculateNeccesaryMatrixSheet() + " db"
        };

        String[] table3content = new String[]{
            "" + calculationResult.getCardboardsTotalCost() + " Ft",
            "" + calculationResult.getNeedfulMatrixSheets()[0].calculatePrice() + " Ft",
            "" + calculationResult.getNeedfulMatrixSheets()[1].calculatePrice() + " Ft",
            "" + calculationResult.getAirplusTotalCost() + " Ft",
            "" + calculationResult.getSumCostWithDiscont() + " Ft"
        };

        VelocityContext context = new VelocityContext();
        
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
        
        return context;
    }

    private String[][] convertArrayList(ArrayList<GlassyProduct> list) {
        String[][] result = new String[list.size()][6];

        for (int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).getName();
            result[i][1] = list.get(i).getWidth() + " mm";
            result[i][2] = list.get(i).getHeight() + " mm";
            result[i][3] = list.get(i).getWeight() + " g";
            result[i][4] = list.get(i).getVolume() + " ml";
            result[i][5] = list.get(i).getAmountInOrder() + " db";
        }

        return result;
    }

}