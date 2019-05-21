package com.upgrad.dsa.stacks.versioningsystem.file;

import com.upgrad.dsa.stacks.versioningsystem.VersioningService;

/**
 * The VersionedStringFile implements the VersionedFile interface and makes use of the
 * {@link com.upgrad.dsa.stacks.versioningsystem.VersioningService} to maintain file versions.
 *
 * This class uses the {@link com.upgrad.dsa.stacks.versioningsystem.file.StringFile} as the concrete
 * implementation to store files.
 */
public class VersionedStringFile implements VersionedFile {

    /**
     * Instance of the versioning service, that is used to maintain the different versions of this file.
     */
    private VersioningService<StringFile> versioningService;

    /**
     * Initializes a VersionedStringFile with the given content.
     *
     * @param content
     */
    public VersionedStringFile(String content) {
        StringFile file = new StringFile(content);
        this.versioningService = new VersioningService<>(file);
    }

    /**
     * Initializes an empty VersionedStringFile.
     */
    public VersionedStringFile() {
        this("");
    }

    /**
     * {@inheritDoc}
     */
    public void saveVersion(String tag) {
        String content = this.versioningService.getCurrentVersion().getFile().getContent();
        this.versioningService.addVersion(new StringFile(content), tag);
    }

    /**
     * {@inheritDoc}
     */
    public void saveVersion() {
        this.saveVersion(null);
    }


    /**
     * {@inheritDoc}
     */
    public String getFormerVersion(int hops) {
        return this.versioningService.getFormerVersion(hops).getFile().getContent();
    }

    /**
     * {@inheritDoc}
     */
    public String getPreviousVersion() {
        return this.getFormerVersion(1);
    }

    /**
     * {@inheritDoc}
     */
    public void revertToFormerVersion(int hops) {
        this.versioningService.revertToFormerVersion(hops);
    }

    /**
     * {@inheritDoc}
     */
    public void revertToPreviousVersion() {
        this.revertToFormerVersion(1);
    }

    /**
     * {@inheritDoc}
     */
    public String getContent() {
        return this.versioningService.getCurrentVersion().getFile().getContent();
    }

    /**
     * {@inheritDoc}
     */
    public void setContent(String content) {
        this.versioningService.getCurrentVersion().getFile().setContent(content);
    }

    /**
     * {@inheritDoc}
     */
    public void appendContent(String toAppend) {
        this.versioningService.getCurrentVersion().getFile().appendContent(toAppend);
    }

    /**
     * {@inheritDoc}
     */
    public int getVersionNumber() {
        return this.versioningService.getCurrentVersion().getVersionNumber();
    }

    /**
     * {@inheritDoc}
     */
    public String getVersionTag() {
        return this.versioningService.getCurrentVersion().getTag();
    }
}
