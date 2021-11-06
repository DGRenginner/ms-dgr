package commerce.dgr.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
public class ErrorModel implements Serializable {
    private static final long serialVersionaUID = 1L;

    private Integer status;
    private String msg;
}
