package kodlamaio.HrmsProject.core.utilities.results;

public class SuccessResult extends Result {

	public SuccessResult(boolean success, String message) {
		super(success, message);
	}

	public SuccessResult(String message) {
		super(true, message);
	}

}
