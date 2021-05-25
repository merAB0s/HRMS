package kodlamaio.HrmsProject.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, boolean success, String message) {
		super(data, success, message);
	}

	public SuccessDataResult(T data) {
		super(data, true);
	}

	public SuccessDataResult(String message) {
		super(null, true, message);
	}

	public SuccessDataResult() {
		super(null, true);
	}

}
