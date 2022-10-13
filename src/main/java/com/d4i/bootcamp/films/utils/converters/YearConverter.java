package com.d4i.bootcamp.films.utils.converters;

import java.time.Year;
import java.util.logging.Logger;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class YearConverter implements AttributeConverter<Year, Short> {

    private static final Logger LOGGER = Logger.getLogger(YearConverter.class.getSimpleName());

    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        short year = (short) attribute.getValue();
        LOGGER.info("Convert Year [" + attribute + "] to short [" + year + "]");

        return year;
    }

    @Override
    public Year convertToEntityAttribute(Short dbRecord) {
        Year year = Year.of(dbRecord);
        LOGGER.info("Convert Short [" + dbRecord + "] to Year [" + year + "]");

        return year;
    }
}
