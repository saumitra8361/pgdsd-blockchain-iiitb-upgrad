package com.upgrad.dsa.stacks.versioningsystem;

import com.upgrad.dsa.stacks.versioningsystem.file.BaseFile;

import java.util.Objects;

/**
 * The Version class abstracts the concept of a version.
 * <p>
 * Every version has an associated
 * - File
 * - version number
 * - tag
 * <p>
 * The Version class has been created to allow storing the contents of a file as a numbered and
 * tagged version.
 * <p>
 * The {@link VersioningService} builds builds the version stack with nodes of
 * this class.
 *
 * @param <T> Type which implements BaseFile
 */
public class Version<T extends BaseFile> {

    /**
     * Instance of the file that is associated with this version.
     */
    private T file;

    /**
     * The number for this version. Corresponds to the number for this version in the version hierarchy.
     */
    private int number;

    /**
     * Link the previous version (node) in the version hierarchy (stack)
     */
    // private Version<T> previous;

    /**
     * The tag (if any) that is associated with this version.
     */
    private String tag;

    /**
     * Instantiates a new Version.
     *
     * @param file     The file object that will be associated with this version.
     * @param number   the number for this version.
     * @param previous The previous version in the version hierarchy.
     * @param tag      The tag (if any) that is associated with this version.
     */
    public Version(T file, int number, String tag) {
        if (Objects.isNull(file)) {
            throw new NullPointerException("Version must be created using an object");
        }
        this.file = file;
        this.number = number;
        this.tag = tag;
    }

    /**
     * Returns the instance of the file that is associated with this version.
     *
     * @return
     */
    public T getFile() {
        return this.file;
    }

    /**
     * Returns the version number for this version.
     *
     * @return
     */
    public int getVersionNumber() {
        return this.number;
    }

    /**
     * Returns the previous version in the version hierarchy.
     * @return
     */
    // public Version<T> getPrevious() {
    //     return this.previous;
    // }

    /**
     * Returns the tag (if any) that is associated with this version.
     *
     * @return
     */
    public String getTag() {
        return this.tag;
    }
}
