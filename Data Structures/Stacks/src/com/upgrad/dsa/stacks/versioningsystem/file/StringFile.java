package com.upgrad.dsa.stacks.versioningsystem.file;

import java.util.Objects;

/**
 * The StringFile class implements the BaseFile interface using a
 * {@link java.lang.String} as the storage medium for the File.
 */
public class StringFile implements BaseFile {

    /**
     * The content of the file.
     */
    private String content;

    /**
     * Constructor for the StringFile, which is null safe.
     * In case of a null content being passed, the constructor
     * initializes the content as an empty string.
     *
     * @param content
     */
    public StringFile(String content) {
        if(Objects.nonNull(content)) {
            this.content = content;
        } else {
            this.content = "";
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getContent() {
        return this.content;
    }

    /**
     * {@inheritDoc}
     */
    public void setContent(String content) {
        if(Objects.nonNull(content)) {
            this.content = content;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void appendContent(String toAppend) {
        if(Objects.nonNull(toAppend)) {
            this.content = this.content.concat(toAppend);
        }
    }
}
