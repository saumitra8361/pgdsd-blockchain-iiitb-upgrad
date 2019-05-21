package com.upgrad.dsa.stacks.versioningsystem;

import com.upgrad.dsa.stacks.versioningsystem.file.BaseFile;
import com.upgrad.dsa.stacks.versioningsystem.file.VersionedFile;

import java.util.Objects;

/**
 * Utility class used to nicely print the output for the code sample provided.
 */
public class Utils {

    private Utils() {

    }

    public static void printFileContents(BaseFile file) {
        if (Objects.nonNull(file)) {
            System.out.println(file.getContent());
        }
    }

    public static void printVersionNumber(VersionedFile file) {
        if (Objects.nonNull(file)) {
            int versionNumber = file.getVersionNumber();
            String tag = file.getVersionTag();
            if (Objects.isNull(tag)) {
                tag = "<no tag>";
            }
            System.out.println("Version: " + versionNumber + " Tag: " + tag);
        }
    }

    public static void printVersionedFile(VersionedFile file) {
        System.out.println();
        Utils.printVersionNumber(file);
        System.out.print("Contents: ");
        Utils.printFileContents(file);
    }
}
