import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String[] products = {" ", "Хлеб", "Яблоки", "Молоко"};
        int[] prices = {0, 100, 200, 300};

        File textFile = new File("basket.txt");

        //            Basket basket = null;
        Basket basket = new Basket(products, prices);

//        if (basketFile.exists()) {
//             basket = Basket.loadFromTxtFile(basketFile);
//        } else {
//            Basket basket = new Basket(products, prices);
//        }

        basket.loadFromTxtFile(textFile);


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
            basket.addToCart(productNumber,productCount);
 //           basket.saveTxt(productNumber,productCount);
              basket.saveTxt(textFile);

        }

        //.. .. вывод корзины
            basket.printCart();

    }
}
