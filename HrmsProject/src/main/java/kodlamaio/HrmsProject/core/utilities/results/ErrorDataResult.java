package kodlamaio.HrmsProject.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, boolean success, String message) {
		super(data, success, message);
	}

	public ErrorDataResult(T data) {
		super(data, false);
	}

	public ErrorDataResult(String message) {
		super(null, false, message);
	}

	public ErrorDataResult() {
		super(null, false);
	}
}
