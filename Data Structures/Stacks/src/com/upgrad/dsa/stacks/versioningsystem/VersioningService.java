package com.upgrad.dsa.stacks.versioningsystem;

import com.upgrad.dsa.stacks.versioningsystem.file.BaseFile;

import java.util.Objects;
import java.util.Stack;

/**
 * The VersioningService is responsible for building the version hierarchy, of
 * {@link com.upgrad.dsa.stacks.versioningsystem.Version} nodes. Therefore, the
 * VersioningService is essentially responsible for building and maintaining
 * our stack with each node in the stack being a different file version.
 *
 * @param <T>
 */
public class VersioningService<T extends BaseFile> {

    /**
     * Uses {@link java.util.Stack} to create the internal stack for the
     * versioning system.
     */
    private Stack<Version<T>> versionStack;

    /**
     * VersionService constructor.
     *
     * @param file the file instance which will be used as the base (first)
     *             version in the hierarchy.
     */
    public VersioningService(T file) {
        if (Objects.isNull(file)) {
            throw new NullPointerException("Cannot initialize with null file.");
        }
        // Initialize the stack for this versioning service.
        this.versionStack = new Stack<>();
        // add the first version to the stack. Tag is automatically marked "initial version."
        this.versionStack.push(new Version<>(
            file,
            (this.versionStack.size() + 1),
            "initial version"));
    }

    /**
     * Returns the current version i.e. the most recent version. (top of the stack)
     *
     * @return
     */
    public Version<T> getCurrentVersion() {
        return this.versionStack.peek();
    }

    /**
     * Returns the total number of versions
     * in the hierarchy chain.
     *
     * @return
     */
    public int getNumberOfVersions() {
        return this.versionStack.size();
    }

    /**
     * Adds a version to the version hierarchy.
     *
     * @param file The file object which should be used as the latest version.
     * @param tag
     */
    public void addVersion(T file, String tag) {
        Version<T> newVersion = new Version<>(file, this.getNumberOfVersions() + 1, tag);
        this.versionStack.push(newVersion);
    }

    private void validateGetVersionRequest(int n) {
        if (n > this.versionStack.size()) {
            throw new IllegalArgumentException("Trying to request a version that doesn't exist");
        }
    }

    /**
     * Returns a former version. The `hops` parameter defines how far back we
     * look for this version in the history (version hierarchy)
     *
     * @param hops
     * @return
     */
    public Version<T> getFormerVersion(int hops) {
        this.validateGetVersionRequest(hops);
        // in case we are going back as many versions as are in the stack, the return value will
        // be null, since no version is defined.
        if (hops == this.versionStack.size()) {
            return null;
        }
        return this.versionStack.elementAt((this.versionStack.size() - 1) - hops);
    }

    /**
     * Resets the version hierarchy to a previous version. The `hops` denotes the
     * number of versions (counted from the latest/most recent version) we go back
     * in the version history.
     *
     * @param hops
     */
    public void revertToFormerVersion(int hops) {
        this.validateGetVersionRequest(hops);
        // for every hop, we pop a single version off the top of the stack.
        while (hops > 0) {
            this.versionStack.pop();
            hops--;
        }
    }
}
