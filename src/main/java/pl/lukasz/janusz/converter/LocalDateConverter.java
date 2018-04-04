package pl.lukasz.janusz.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;

public final class LocalDateConverter implements Converter<String, Date> {

    private final SimpleDateFormat formatter;

    public LocalDateConverter(String dateFormat) {
        this.formatter = new SimpleDateFormat(dateFormat, Locale.US);
    }

    @Override
    public Date convert(String source) {
        try {
            return this.formatter.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}