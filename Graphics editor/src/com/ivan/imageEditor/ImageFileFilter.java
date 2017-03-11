package com.ivan.imageEditor;

import javax.swing.filechooser.FileFilter;

/**
 * Created by Ivan on 11.03.2017.
 */
public class ImageFileFilter extends FileFilter {
    private String ext;

    public ImageFileFilter(String ext) {
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