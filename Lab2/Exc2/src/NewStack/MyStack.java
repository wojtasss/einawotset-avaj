package NewStack;
import java.util.List;

public class MyStack implements Stackable {
	
	private List<Integer> stack;
	
	@Override
	public void myPush(int e) {
		if(stack == null) {
			throw new NullPointerException();
		} else {
			stack.add(0, e);
		}
	}

	@Override
	public int myPop() {
		if(stack == null) {
			throw new NullPointerException();
		} else if(stack.isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			int head = stack.get(0);
			stack.remove(0);
			return head;
		}
	}

	@Override
	public boolean isNull() {
		if(stack == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int myTop() {
		if(stack == null) {
			throw new NullPointerException();
		} else if(stack.isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			return stack.get(0);
		}
	}

	public List<Integer> getStack() {
		return stack;
	}

	public void setStack(List<Integer> stack) {
		this.stack = stack;
	}

}
