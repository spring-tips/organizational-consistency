package numbers;

import java.util.concurrent.ThreadLocalRandom;

public class NumberService {

	private final int bound;

	NumberService(NumberProperties np) {
		this.bound = np.getBound();
	}

	public int generateRandomNumber() {
		ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
		return threadLocalRandom.nextInt(this.bound);
	}

}
