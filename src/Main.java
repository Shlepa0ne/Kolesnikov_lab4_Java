import java.util.ArrayList;
import java.util.Scanner;

class CarDatabase {
    private int numCars = 0;
    private ArrayList<Car> cars = new ArrayList<>();

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создание записи об автомобиле.\n");

        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите фамилию: ");
        String surname = scanner.next();
        System.out.print("Введите телефонный номер: ");
        String phoneNumber = scanner.next();
        CustomerData customer = new CustomerData(name, surname, phoneNumber);

        System.out.print("Введите марку автомобиля: ");
        String carBrand = scanner.next();
        System.out.print("Введите год выпуска автомобиля: ");
        String yearOfRelease = scanner.next();
        System.out.print("Введите госномер автомобиля: ");
        String stateNumber = scanner.next();
        CarData car = new CarData(carBrand, yearOfRelease, stateNumber);

        System.out.print("Выберите тип двигателя (1. бензиновый; 2. дизельный; 3. электрический): ");
        Engine eng = Engine.UNKNOWN_ENGINE;
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                eng = Engine.PETROL;
                break;
            case 2:
                eng = Engine.DIESEL;
                break;
            case 3:
                eng = Engine.ELECTRIC;
                break;
        }

        System.out.print("Выберите тип привода (1. передний; 2. задний; 3. полный): ");
        WheelDrive drive = WheelDrive.UNKNOWN_WD;
        option = scanner.nextInt();
        switch (option) {
            case 1:
                drive = WheelDrive.FWD;
                break;
            case 2:
                drive = WheelDrive.RWD;
                break;
            case 3:
                drive = WheelDrive.AWD;
                break;
        }

        System.out.print("Введите цвет кузова: ");
        String color = scanner.next();

        System.out.print("Выберите материал кузова (1. алюминий; 2. сталь; 3. углеволокно): ");
        Material mat = Material.UNKNOWN_MATERIAL;
        option = scanner.nextInt();
        switch (option) {
            case 1:
                mat = Material.ALUMINUM;
                break;
            case 2:
                mat = Material.STEEL;
                break;
            case 3:
                mat = Material.CARBON_FIBER;
                break;
        }

        CarBody body = new CarBody(color, mat);
        Car carObj = new Car(customer, car, eng, drive, body);

        cars.add(carObj);
        numCars++;
        System.out.println("Запись создана.\n");
    }

    public void output() {
        if (numCars > 0) {
            System.out.println("Вывод всех записей.\n");
            for (int counter = 0; counter < numCars; counter++) {
                System.out.println("Заказ №" + (counter + 1));
                cars.get(counter).displayCarInfo();
                System.out.println("-----------------------------------\n");
            }
        } else {
            System.out.println("Записи не найдены!\n");
        }
    }

    public static void main(String[] args) {
        CarDatabase carDb = new CarDatabase();
        int quit = 0;
        int option;
        Scanner scanner = new Scanner(System.in);

        while (quit == 0) {
            System.out.println("Выберите действие:");
            System.out.println(" 1. Создать запись об автомобиле");
            System.out.println(" 2. Редактировать конкретную запись");
            System.out.println(" 3. Вывести все существующие записи");
            System.out.println(" 4. Вывести конкретную запись");
            System.out.println(" 5. Удалить конкретную запись");
            System.out.println(" 0. Выйти");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        carDb.input();
                        break;
                    case 2:
                        System.out.println("Редактирование находится в разработке!\n");
                        break;
                    case 3:
                        carDb.output();
                        break;
                    case 4:
                        System.out.println("Вывод конкретной записи находится в разработке!\n");
                        break;
                    case 5:
                        System.out.println("Удаление находится в разработке!\n");
                        break;
                    case 0:
                        System.out.println("Выход.\n");
                        quit = 1;
                        break;
                    default:
                        System.out.println("Некорректный ввод. Попробуйте еще раз\n");
                        break;
                }
            } else {
                scanner.next();
                System.out.println("Некорректный ввод. Попробуйте еще раз\n");
            }
        }
    }
}
