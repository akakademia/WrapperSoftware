package wrappersoftware.report;

import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import wrappersoftware.GlassyProduct;
import wrappersoftware.Results;

public class ReportGenerator {

    private final Results calculationResult;
    private final String costumerName;

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
        VelocityContext context = new VelocityContext();
        
        context.put("title", "A&K Packer Kft. - Wrapper Software (WS) rendelés összeállítva");
        context.put("costumer_name", costumerName);
        context.put("header", "A&K Packer Kft. - Wrapper Software (WS)");
        context.put("products_title", "Csomagolásra alkalmas termékek:");
        context.put("products_header", new String[]{"Termék típusa", "Szélessége", "Magassága", "Súlya", "Űrtartalma",
            "Mennyiség"});
        context.put("products_in_box", generateOrderList(calculationResult.getProductsFitInBox()));
        context.put("not_packable_header", "Csomagolásra nem alkalmas termékek:");
        context.put("products_not_packable", generateOrderList(calculationResult.getProductsNotPackable()));
        context.put("title_for_packaging", "Az üvegek csomagolásához szükséges anyagok:");
        context.put("box_title", "Dobozok száma: " + calculationResult.getNeedfulCardboards() + ", ezen belül kell:");
        context.put("box_header", new String[]{"Doboz neve", "Szélessége", "Hosszúsága", "Magassága", "db"});
        context.put("box", generateNeccesaryBoxList());
        context.put("wrapper_title", "Térkitöltő: " + calculationResult.getNeedfulAirplus() + " db");
        context.put("matrix_sheets_title", "Matrica");
        context.put("matrix_sheets_header", new String[]{"Matrica neve", "ívek száma"});
        context.put("matrix_sheets", generateNeccesaryMatrixSheetList());
        context.put("calculation_title", "Ár-Kalkuláció:");
        context.put("calculation_header", new String[]{"Tétel", "Ár"});
        context.put("calculation", generatePriceCalculationList());
        
        return context;
    }

    private String[][] generatePriceCalculationList() {
        String[][] result = new String[7][2];
        
        result[0][0] = "A dobozokhoz szükséges kartonok ára összesen";
        result[0][1] = calculationResult.getCardboardsTotalCost() + " Ft";
        result[1][0] = calculationResult.getNeedfulMatrixSheets()[0].getName() + " matricák - ívek ára összesen";
        result[1][1] = calculationResult.getNeedfulMatrixSheets()[0].calculatePrice() + " Ft";
        result[2][0] = calculationResult.getNeedfulMatrixSheets()[1].getName() + " matricák - ívek ára összesen";
        result[2][1] = calculationResult.getNeedfulMatrixSheets()[1].calculatePrice() + " Ft";
        result[3][0] = calculationResult.getNeedfulMatrixSheets()[2].getName() + " matricák - ívek ára összesen";
        result[3][1] = calculationResult.getNeedfulMatrixSheets()[2].calculatePrice() + " Ft";
        result[4][0] = calculationResult.getNeedfulMatrixSheets()[3].getName() + " matricák - ívek ára összesen";
        result[4][1] = calculationResult.getNeedfulMatrixSheets()[3].calculatePrice() + " Ft";
        result[5][0] = "Térkitöltő ára";
        result[5][1] = calculationResult.getAirplusTotalCost() + " Ft";
        result[6][0] = "A csomagolás teljes költsége ( " + calculationResult.getDiscount() + " % kedvezménnyel )";
        result[6][1] = calculationResult.getSumCostWithDiscont() + " Ft";

        return result;
    }
    
    private String[][] generateOrderList(ArrayList<GlassyProduct> list) {
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
    
    private String[][] generateNeccesaryBoxList() {
        String[][] result = new String[calculationResult.getNeedfulBoxes().size()][5];

        for (int i = 0; i < calculationResult.getNeedfulBoxes().size(); i++) {
            result[i][0] = calculationResult.getNeedfulBoxes().get(i).getName();
            result[i][1] = calculationResult.getNeedfulBoxes().get(i).getWidth() + " mm";
            result[i][2] = calculationResult.getNeedfulBoxes().get(i).getLength()+ " mm";
            result[i][3] = calculationResult.getNeedfulBoxes().get(i).getHeigth()+ " mm";
            result[i][4] = calculationResult.getNeedfulBoxes().get(i).getNumberOfNeccesaryBoxes()+ " db";
        }

        return result;
    }

     private String[][] generateNeccesaryMatrixSheetList() {
        String[][] result = new String[calculationResult.getNeedfulMatrixSheets().length][2];

        for (int i = 0; i < calculationResult.getNeedfulMatrixSheets().length; i++) {
            result[i][0] = calculationResult.getNeedfulMatrixSheets()[i].getName();
            result[i][1] = calculationResult.getNeedfulMatrixSheets()[i].getNumberOfNeccesaryMatrixes() + " db";
        }

        return result;
    }
    
}