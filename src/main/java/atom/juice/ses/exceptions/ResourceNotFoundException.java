package atom.juice.ses.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * Generated serial UUID
	 */
	@Serial
	private static final long serialVersionUID = -249970877955578095L;

	public ResourceNotFoundException(String ex) {
		super(ex);
	}

}
