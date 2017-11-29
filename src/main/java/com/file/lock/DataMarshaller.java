package com.file.lock;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class DataMarshaller {
    private static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
    private static final String DEFAULT_DELIMITER = ",";

    private Collection<String> headers = Arrays.asList("val1", "val2", "val3");
    private String lineBreak = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);

    void marshal(final Writer writer, final List<Entity> data) throws IOException {
        final CsvWriter csvWriter = new CsvWriter(writer);
        writeHeaders(csvWriter);
        writeData(csvWriter, data);
    }

    private void writeHeaders(final CsvWriter writer) throws IOException {
        if (CollectionUtils.isNotEmpty(headers)) {
            writer.writeLine(headers);
        }
    }

    private void writeData(final CsvWriter writer, final List<Entity> data) throws IOException {
        for (final Entity entry : data) {
            writeDataEntry(writer, entry);
            writer.writeLineBreak();
        }
    }

    private void writeDataEntry(CsvWriter writer, Entity entry) throws IOException {
        writer.write(entry.getVal1());
        writer.write(entry.getVal2());
        writer.write(entry.getVal3());
    }

    private final class CsvWriter {

        private final Writer writer;

        private int lineIndex;

        CsvWriter(final Writer writer) {
            this.writer = writer;
            this.lineIndex = 0;
        }

        void writeLine(final Collection<?> values) throws IOException {
            if (lineIndex > 0) {
                writeLineBreak();
            }
            for (Object value : values) {
                write(value);
            }
            writeLineBreak();
        }

        void write(final Object value) throws IOException {
            final Object nonNullValue = ObjectUtils.defaultIfNull(value, StringUtils.EMPTY);
            write(nonNullValue.toString());
        }

        void writeLineBreak() throws IOException {
            writer.write(lineBreak);
            lineIndex = 0;
        }

        private void write(final String value) throws IOException {
            if (lineIndex > 0) {
                writer.write(DEFAULT_DELIMITER);
            }
            lineIndex++;
            writer.write(value);
        }
    }

}
