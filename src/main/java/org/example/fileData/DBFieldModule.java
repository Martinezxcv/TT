package org.example.fileData;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import org.example.annotations.DBField;

import java.util.ArrayList;
import java.util.List;

public class DBFieldModule extends SimpleModule {

    @Override
    public void setupModule(Module.SetupContext context) {
        super.setupModule(context);
        context.addBeanSerializerModifier(new DBFieldSerializerModifier());
    }

    private static class DBFieldSerializerModifier extends BeanSerializerModifier {

        @Override
        public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
                                                         List<BeanPropertyWriter> beanProperties) {
            List<BeanPropertyWriter> filteredProperties = new ArrayList<>();

            for (BeanPropertyWriter writer : beanProperties) {
                AnnotatedMember propertyMember = writer.getMember();
                if (propertyMember != null && propertyMember.hasAnnotation(DBField.class)) {
                    filteredProperties.add(writer);
                }
            }
            return filteredProperties;
        }
    }
}
