import java.io.*;

public class Basket {
    private String[] products;
    private int[] prices;
    private int[] count;

    public Basket() {
    }

    public Basket(String[] products, int[] prices) {
        this.products = products;
        this.prices = prices;
        this.count = new int[products.length];
    }

    // добавление покупок в корзину
    public void addToCart(int productNum, int amount) {
        count[productNum] += amount;
    }

    public void printCart() {
        int totalPrice = 0;
        System.out.println("Список покупок:");
        for (int i = 0; i < products.length; i++) {
            if (count[i] > 0) {
                int currentPrices = prices[i] * count[i];
                totalPrice += currentPrices;
                System.out.println(products[i] + " " + prices[i] + "руб.  " + count[i] + " шт.   " + currentPrices + " руб.");
            }
        }
        System.out.println("Итого:   " + totalPrice);
    }

    public void saveTxt(File textFile) {

        try (FileWriter writer = new FileWriter(textFile, false)) {

            for (int i = 0; i < count.length; i++) {
                // запись всей строки
                String s = Integer.toString(count[i]);
                writer.write(s);
                writer.append('\n');
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void loadFromTxtFile(File textFile) {
        //
        if (textFile.exists()) {

            try (BufferedReader reader = new BufferedReader(new FileReader(textFile))) {

                String text;
                int i = 0;
                while ((text = reader.readLine()) != null) {
                    //   читаем файл построчно
                    count[i] = Integer.parseInt(text);
                    System.out.println(text);
                    i++;
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
