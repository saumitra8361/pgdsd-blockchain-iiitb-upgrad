package com.upgrad.dsa.stacks.versioningsystem.file;

/**
 * The BaseFile interface that provides the basic operations required of any file.
 *
 * For the purpose of this demonstration we have created a simpler interface
 * than the {@link java.io.File} interface.
 */
public interface BaseFile {

    /**
     * Retrieve the contents stored in the file.
     * @return The contents stored in the file
     */
    String getContent();

    /**
     * Set the content of the file, overwriting any previously written content.
     * @param content
     */
    void setContent(String content);

    /**
     * Append to the already present content in the file.
     * @param toAppend
     */
    void appendContent(String toAppend);
}