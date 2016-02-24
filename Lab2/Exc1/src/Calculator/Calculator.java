package Calculator;

public class Calculator implements Calculationable {

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int multi(int a, int b) {
		return a*b;
	}

	@Override
	public int div(int a, int b) {
		if(b == 0) {
			throw new IllegalArgumentException();
		} else {
			return a/b;
		}
	}

	@Override
	public boolean greater(int a, int b) {
		if(a > b) {
			return true;
		} else {
			return false;
		}
	}

}
