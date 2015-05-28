package hello;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private HttpStatus status;

    private String message;

    @JsonIgnore
    private Throwable throwable;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
        if (StringUtils.isEmpty(message)) {
            this.message = ExceptionUtils.getRootCauseMessage(throwable);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        ErrorMessage otherErrorMessage = (ErrorMessage) obj;

        return new EqualsBuilder()
                .append(status, otherErrorMessage.status)
                .append(message, otherErrorMessage.message)
                    .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(status)
                .append(message)
                .toHashCode();
    }

    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("status", status)
                .append("message", message)
                .toString();
    }

    public static class Builder {

        private HttpStatus status;
        private String message;
        private Throwable throwable;

        public ErrorMessage build() {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setStatus(status);
            errorMessage.setMessage(message);
            errorMessage.setThrowable(throwable);

            return errorMessage;
        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder throwable(Throwable throwable) {
            this.throwable = throwable;
            return this;
        }
    }
}
