import java.io.*;

public class Basket implements Serializable {
   private static final long serialVersionUID = 1L;
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

    public void saveBin(File file) {
// откроем выходной поток для записи в файл
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
// запишем экземпляр класса в файл
            oos.writeObject(this);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static Basket loadFromBinFile(File file)  {
        Basket basket = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
// десериализуем объект и скастим его в класс
            basket = (Basket) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return basket;
    }
}
