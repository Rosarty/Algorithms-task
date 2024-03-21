package app.data;

import app.entity.Product;
import app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class DataHandler {
    List<Product> list = new DataRepository().getData();

    public int search(String search) {
        double priceSearch = Double.parseDouble(search);
        for (int i = 0; i < list.size(); i++) {
            if (priceSearch == list.get(i).getPrice()) {
                return i;
            }
        }
        return -1;
    }

    public String formOutput() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger count = new AtomicInteger(1);
        for (Product product : list) {
            sb.append(String.format("%d. %s%n", count.getAndIncrement(), product.toString()));
        }
        return "Initial data:\n" + sb;
    }

    public String formOutput(String search, int index) {
        if (index == -1) {
            return "No data.\n";
        } else {
            return String.format(" Search price: %s%n Product: %s, price is %s %.2f%n", search,
                    list.get(index).getName(), Constants.CURRENCY, list.get(index).getPrice());

        }
    }
}