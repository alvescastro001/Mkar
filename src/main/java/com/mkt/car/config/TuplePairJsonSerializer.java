package com.mkt.car.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.tuple.Pair;

import java.io.IOException;

public class TuplePairJsonSerializer extends StdSerializer<Pair> {

    private static final long serialVersionUID = -7912422754354082076L;

    /**
     * Construtor padrão para o serializador JSON de objetos {@link org.apache.commons.lang3.tuple.Pair}.
     *
     * @since 1.0.0
     */
    public TuplePairJsonSerializer() {
        this(Pair.class);
    }

    /**
     * @see StdSerializer#StdSerializer(Class)
     * @since 1.0.0
     */
    public TuplePairJsonSerializer(Class<Pair> t) {
        super(t);
    }

    /**
     * @see StdSerializer#serialize(Object, JsonGenerator, SerializerProvider)
     * @since 1.0.0
     */
    @Override
    public void serialize(Pair value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeObjectField("key", value.getKey());
        if (value.getValue() != null) {
            gen.writeObjectField("value", value.getValue());
        }
        gen.writeEndObject();
    }
}
