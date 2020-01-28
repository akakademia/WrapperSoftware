package wrappersoftware;

import java.util.Scanner;

public class OrderCompilator {

	public void setUpOrder(BasicDates basicDates, Order order, Scanner scanner) {
		int menuPoint = -1;

		while (menuPoint != 3) {
			order.printOrder();
			System.out.println();

			Menu menu = new Menu(MenuType.ORDER);
			System.out.println(menu);

			GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg menüpontot: ");
			menuPoint = getInput.getValidIntegerFromUser(0, menu.getFields().length - 1);

			if (menuPoint == 0) {
				chooseAndAddProduct(basicDates, order, scanner);
				continue;
			}
			if (menuPoint == 1) {
				if (order.getProducts()
						.isEmpty()) {
					System.out.println("Figyelem! A megrendelés üres!");
				} else {
					chooseAndRemoveProduct(basicDates, order, scanner);
				}
				System.out.println();
				continue;
			}
			if (menuPoint == 2) {
				setDiscount(order, scanner);
				continue;
			}
			if (menuPoint == 3) {
				if (order.getProducts()
						.isEmpty()) {
					System.out.println("Figyelem! A megrendelés üres!");
					menuPoint = -1;
				}
				System.out.println();
			}
		}
		System.out.println("Megrendelés össze van állítva.");
		order.printOrder();
		System.out.println();
	}

	private void setDiscount(Order order, Scanner scanner) {
		GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg kedvezmény mértékét: ");
		int discount = getInput.getValidIntegerFromUser(0, 100);
		order.setDiscount(discount);
	}

	private void chooseAndRemoveProduct(BasicDates basicDates, Order order, Scanner scanner) {
		Menu menu = new Menu(MenuType.PRODUCTS_LIST_TO_REMOVE);
		String[] listGlassyProducts = listingGlassyProductsFromOrder(order);
		menu.setAdditonalFields(listGlassyProducts);
		System.out.println(menu);

		GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg menüpontot: ");
		int menuPoint = getInput.getValidIntegerFromUser(0, menu.getFields().length - 1);

		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpontot választott!");

		if (menuPoint != 0) {
			int indexOfProductInOrder = menuPoint - menu.getNumberOfBasicFields();
			removeProduct(scanner, order, indexOfProductInOrder);
		}
	}

	private void removeProduct(Scanner scanner, Order order, int indexOfProductInOrder) {
		GlassyProduct productToRemove = order.getProducts()
				.get(indexOfProductInOrder);
		int indexInOrder = order.getProducts()
				.indexOf(productToRemove);

		GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg darabszámot: ");
		int amountToRemove = getInput.getValidIntegerFromUser(1, productToRemove.getAmountInOrder());

		if (amountToRemove == productToRemove.getAmountInOrder()) {
			order.getProducts()
					.remove(indexInOrder);
			order.getProducts()
					.trimToSize(); 
		} else {
			order.getProducts()
					.get(indexInOrder)
					.setAmountInOrder(productToRemove.getAmountInOrder() - amountToRemove);
		}
	}

	private String[] listingGlassyProductsFromOrder(Order order) {
		String[] list = new String[order.getProducts()
				.size()];
		for (int i = 0; i < list.length; i++) {
			list[i] = order.getProducts()
					.get(i)
					.toString() + " - "
					+ order.getProducts()
							.get(i)
							.getAmountInOrder()
					+ " db.";
		}
		
		return list;
	}

	private void chooseAndAddProduct(BasicDates basicDates, Order order, Scanner scanner) {
		Menu menu = new Menu(MenuType.PRODUCTS_LIST_TO_ADD);
		String[] listGlassyProducts = listingGlassyProductsFromBasicDates(basicDates);
		menu.setAdditonalFields(listGlassyProducts);
		System.out.println(menu);

		GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg menüpontot: ");
		int menuPoint = getInput.getValidIntegerFromUser(0, menu.getFields().length - 1);

		System.out.println(menuPoint + " - " + menu.getFields()[menuPoint] + " - menüpontot választott!");

		if (menuPoint != 0) {
			int indexOfProductInBasicDates = menuPoint - menu.getNumberOfBasicFields();
			addProduct(scanner, order, basicDates, indexOfProductInBasicDates);
		}
	}

	private void addProduct(Scanner scanner, Order order, BasicDates basicDates, int indexOfProductInBasicDates) {
		GetInputFromUser getInput = new GetInputFromUser(scanner, "Kérem, adja meg darabszámot: ");
		int amountToAdd = getInput.getValidIntegerFromUser(1, 100);

		GlassyProduct productToAdd = basicDates.getGlassyProducts()[indexOfProductInBasicDates];

		if (isProductExistInOrder(order, productToAdd)) {
			int indexOfProductInOrder = order.getProducts()
					.indexOf(productToAdd);
			int amountInOrder = order.getProducts()
					.get(indexOfProductInOrder)
					.getAmountInOrder();
			order.getProducts()
					.get(indexOfProductInOrder)
					.setAmountInOrder(amountInOrder + amountToAdd);
		} else {
			productToAdd.setAmountInOrder(amountToAdd);
			order.getProducts()
					.add(productToAdd);
		}
	}

	private boolean isProductExistInOrder(Order order, GlassyProduct glassyProduct) {
		return order.getProducts()
				.contains(glassyProduct);
	}

	private String[] listingGlassyProductsFromBasicDates(BasicDates basicDates) {
		String[] list = new String[basicDates.getGlassyProducts().length];
		for (int i = 0; i < list.length; i++) {
			list[i] = basicDates.getGlassyProducts()[i].toString();
		}
		return list;
	}
}
