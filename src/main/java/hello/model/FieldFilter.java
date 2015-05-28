package hello.model;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FieldFilter {

    private final static String COMMA = ",";
    private final static String EXCLAMATION = "!";

    private Set<String> fields = Collections.<String>emptySet();
    private boolean exclude = false;

    public FieldFilter(String expression) {

        String fields = expression;
        if (StringUtils.isNotBlank(fields) && !StringUtils.endsWith(fields, EXCLAMATION)) {
            if (fields.startsWith(EXCLAMATION)) {
                exclude = true;
                fields = expression.substring(1);
            }

            this.fields = new HashSet<>(Arrays.asList(fields.split(COMMA)));
        }
    }

    public FieldFilter(Set<String> fields, boolean exclude) {
        Assert.notNull(fields, "fields may not be null");
        this.fields = fields;
        this.exclude = exclude;
    }

    public boolean isExclude() {
        return exclude;
    }

    public Set<String> getFields() {
        return fields;
    }

    public boolean hasFilters() {
        return getFields().size() > 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        FieldFilter otherFieldFilter = (FieldFilter) obj;

        return new EqualsBuilder()
                .append(fields, otherFieldFilter.fields)
                .append(exclude, otherFieldFilter.exclude)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(fields)
                .append(exclude)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
