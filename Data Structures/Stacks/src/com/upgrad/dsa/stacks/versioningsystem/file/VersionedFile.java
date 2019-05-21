package com.upgrad.dsa.stacks.versioningsystem.file;

/**
 * The VersionedFile interface extends the BaseFile interface and adds some
 * methods that we would expect on a file which is being actively versioned.
 *
 * For the purpose of the demonstration, the concept of a versioned file has been slightly
 * simplified for brevity.
 */
public interface VersionedFile extends BaseFile {

    /**
     * Returns the current version number of the file.
     *
     * @return
     */
    int getVersionNumber();

    /**
     * Returns the tag associated with the current version of the file.
     * @return
     */
    String getVersionTag();

    /**
     * Saves the contents of the file as a new version.
     * @param tag The string tag to associate with this version.
     */
    void saveVersion(String tag);

    /**
     * Saves the contents of the file as a new version.
     */
    void saveVersion();

    /**
     * Returns the contents the a former version of the file. The `hops` parameter
     * defines the number of versions that we will go back in the file history.
     *
     * @param hops
     * @return The contents of version found
     */
    String getFormerVersion(int hops);

    /**
     * Returns the previous version of the file.
     * @return The contents of the previous version.
     */
    String getPreviousVersion();

    /**
     * Reverts the file history to a former version of the file. The `hops` parameter
     * defines the number of versions that we will go back in the file history.
     *
     * @param hops
     */
    void revertToFormerVersion(int hops);

    /**
     * Reverts the history of the file by one version.
     */
    void revertToPreviousVersion();
}
