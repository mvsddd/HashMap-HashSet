import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Address addressOne = new Address("Андорра", "Аринсаль");
        Address addressTwo = new Address("Швейцария", "Берн");
        Address addressThree = new Address("Норвегия", "Осло");
        Address addressFour = new Address("Австралия", "Канберра");
        Address addressFive = new Address("Австралия", "Сидней");

        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(addressOne, 3_000);
        costPerAddress.put(addressTwo, 2_800);
        costPerAddress.put(addressThree, 4_200);
        costPerAddress.put(addressFour, 4_500);
        costPerAddress.put(addressFive, 3_200);

        boolean isRunning = true;

        int costOfDelivery;
        int amountOrders = 0;

        Set<String> uniqueCountries = new HashSet<>();

        while (isRunning) {
            System.out.println("\nЗаполнение нового заказа.");

            System.out.print("Введите страну: ");
            String inputCountry = scanner.nextLine();

            isRunning = isContinue(inputCountry);
            if (!isRunning) break;

            System.out.print("Введите город: ");
            String inputCity = scanner.nextLine();

            isRunning = isContinue(inputCity);
            if (!isRunning) break;

            System.out.print("Введите вес (кг): ");
            String inputWeight = scanner.nextLine();

            isRunning = isContinue(inputWeight);
            if (!isRunning) break;

            int productWeight = Integer.parseInt(inputWeight);

            Address addressEntered = new Address(inputCountry, inputCity);

            if (costPerAddress.containsKey(addressEntered)) {
                for (Map.Entry<Address, Integer> keyAndValue : costPerAddress.entrySet()) {
                    if (keyAndValue.getKey().equals(addressEntered)) {
                        costOfDelivery = productWeight * keyAndValue.getValue();
                        amountOrders += costOfDelivery;

                        uniqueCountries.add(keyAndValue.getKey().country);

                        System.out.println("Стоимость доставки составит: " +
                                costOfDelivery + " руб.");
                        System.out.println("Общая стоимость всех доставок: " +
                                amountOrders + " руб.");
                        System.out.println("Количество стран, в которые направятся посылки: " +
                                uniqueCountries.size());
                        break;
                    }
                }
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
        }

        System.out.println("\nПрограмма завершена!");
    }

    public static boolean isContinue (String input) {
        if (input.equals("end") || input.equals("утв")) {
            return false;
        } else {
            return true;
        }
    }
}
