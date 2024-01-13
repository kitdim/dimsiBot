package kit.org;

import kit.org.repository.QuotesRepository;

public class Application {
    public static void main(String[] args) {
        System.out.println(QuotesRepository.show());
    }
}
