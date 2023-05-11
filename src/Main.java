import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.IOException;
import java.io.FileWriter;


public class Main {
        static String[] products = {" ", "Хлеб", "Яблоки", "Молоко"};
        static int[] prices = {0, 100, 200, 300};
        static File file = new File("basket.bin");

        public static void main(String[] args) throws FileNotFoundException  {

        Basket basket = null;
        if (file.exists()) {
            basket = Basket.loadFromBinFile(file);
        } else {
            basket = new Basket(products, prices);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Список возможных товаров для покупки");
        for (int i = 1; i < products.length; i++) {
            System.out.println(i + ". " + products[i] + " " + prices[i] + " р/шт");
        }

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            int productNumber = 0;
            int productCount = 0;

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] inputString = input.split(" ");
            productNumber = Integer.parseInt(inputString[0]);
            productCount = Integer.parseInt(inputString[1]);

            // добавление покупок в корзину
            basket.addToCart(productNumber, productCount);
            basket.saveBin(file);
        }
        //.. .. вывод корзины
        basket.printCart();
//        basket.saveBin(file);
    }
}
