package lab3;

public class Main {
    public static void main(String[] args) {

        HashTable<Integer, Product> store = new HashTable<>(20);
        store.put(1, new Product("Диван", "Мягкий, удобный диван для вашего жилища", 12000, 3));
        store.put(2, new Product("Стул", "Деревянный стул со спинокой", 2000, 6));
        store.put(3, new Product("Стол", "Стол письменный, регулируемый", 8000, 2));
        Product chair = store.get(2);
        System.out.println(chair.getDescription());
        store.remove(2);
        System.out.println(store.get(2));
        System.out.println(store.size());

    }

}
