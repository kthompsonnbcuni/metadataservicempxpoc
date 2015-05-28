package hello.resource;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public abstract class ResourcePropertyFilter extends SimpleBeanPropertyFilter {

    public static final String RESOURCE_FILTER_ID = "resource";

    public abstract boolean isSerializable(Object obj, JsonGenerator jsonGenerator,
                                           SerializerProvider serializerProvider, PropertyWriter writer);

    @Override
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider,
                                 PropertyWriter writer) throws Exception { // NOSONAR
        if (isSerializable(obj, jsonGenerator, serializerProvider, writer)) {
            writer.serializeAsField(obj, jsonGenerator, serializerProvider);
        }
    }

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return true;
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return true;
    }

}
