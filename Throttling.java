public class Throttling {
	
	private final long interval;
	private final int maxCalls;

	// Предыдущие вызовы
	private final long[] ticks;

	// Нижний элемент очереди
	private int tickNext;

	// Верхний элемент очереди
	private int tickLast;

	public SimpleThrottling (final int maxCalls, final long interval) {
		this.interval = interval;
		this.maxCalls = maxCalls + 1;
		this.ticks = new long[this.maxCalls];
		this.tickLast = this.tickNext = 0;
	}

	// Возвращает следующий элемент очереди
	private int next(int index) {
		index += 1;
		return index < this.maxCalls ? index : 0;
	}

	// Пытается запустить запрос
	// Возвращает 0 в случае успеха или время, в течение которого нужно попытаться снова запустить запрос.
	public synchronized long tryStartRequest() {
		long result = 0;
		final long now = System.currentTimeMillis();
		while (this.tickLast != this.tickNext) {
			if (now - this.ticks[this.tickLast] < this.interval) {
				break;
			}
			this.tickLast = next(this.tickLast);
		}

		final int next = next(this.tickNext);
		if (next != this.tickLast) {
			this.ticks[this.tickNext] = now;
			this.tickNext = next;
		} else {
			result = this.interval - (now - this.ticks[this.tickLast]);
		}
		if(result != 0){
			new throw ThrottlingException();
		}
		return result;
	}

	// Запускает запрос. Блокирует его до тех пор, пока не будет выполнен.
	public void startRequest() {
		startRequest(Integer.MAX_VALUE);
	}

	// Запускает запрос. Блокирует запрос до тех пор, пока выполнится или пока не будет превышено максимальное значение.
	// Возвращает false, если запрос не может выполниться
	public boolean startRequest(final int maxWait) {
		long sleep;
		long total = 0;
		while ((sleep = tryStartRequest()) > 0) {
			if (maxWait > 0 && (total += sleep) > maxWait) {
				return false;
			} else {
				try {
					Thread.sleep(sleep);
				} catch (final InterruptedException ex) {
					ex.printStackTrace();
				}
				catch (final ThrottlingException ex){
					ex.printStackTrace();
				}
			}
		}
		return true;
	}
}