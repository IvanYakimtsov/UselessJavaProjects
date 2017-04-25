package tableEditorModel;

import javax.swing.filechooser.FileFilter;

/**
 * Created by Ivan on 29.03.2017.
 */
public class TableFileFilter extends FileFilter {
    private String ext;

    public TableFileFilter(String ext) {
        this.ext = ext;
    }

    @Override
    public boolean accept(java.io.File file) {
        if (file.isDirectory()) return true;
        return (file.getName().endsWith(ext));
    }

    @Override
    public String getDescription() {
        return "*" + ext;
    }
}
