package org.example;

import java.io.File;
import java.io.FilenameFilter;

public class PdfFilenameFilter implements FilenameFilter {

    private final String prefix, postfix;

    public PdfFilenameFilter(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".pdf");
    }

    public boolean acceptPrefixAndPostfix(File dir, String name) {
        return name.startsWith(prefix) && name.endsWith(postfix);
    }
}


/* JDK 8 Lambda synthax:

final FileFilter pdfFilter =(final File file) -> {
    return file.getName().toLowerCase().endsWith(".pdf");
    }

final FileNameFilter xmlFilter = (final File dir, final String name) -> {
    return name.toLowerCase().endsWith(".xml");
    }
*/

