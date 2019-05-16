package com.upgrad.dsa.stacks.versioningsystem;

import com.upgrad.dsa.stacks.versioningsystem.file.VersionedStringFile;

/**
 * Main class which demonstrates file versioning using the
 * {@link com.upgrad.dsa.stacks.versioningsystem.file.VersionedStringFile}
 */
public class Main {

    public static void main(String args[]) {
        // intitialize the file
        // the file is still empty.
        VersionedStringFile file = new VersionedStringFile();
        /*
        Expected Output
        ===============
        Version: 1 Tag: init
        Contents:
         */
        Utils.printVersionedFile(file);

        // we haven't yet saved the file, so we're still editing the first version.
        file.setContent("Hello, World.");
        /*
        Expected Output
        ===============
        Version: 1 Tag: init
        Contents: Hello, World.
         */
        Utils.printVersionedFile(file);

        // Again, we haven't saved the file, but now instead of replacing the entire
        // contents of the, we're appending to the file.
        file.appendContent("Version 1.");
        /*
        Expected Output
        ===============
        Version: 1 Tag: init
        Contents: Hello, World.Version 1.
         */
        Utils.printVersionedFile(file);

        // save the file. Create a new version.
        file.saveVersion();
        /*
        Expected Output
        ===============
        Version: 2 Tag: <no tag>
        Contents: Hello, World.Version 1.
         */
        Utils.printVersionedFile(file);

        // Again, we haven't saved the file, so the version won't change,
        // but we append text to the file, so the contents will change.
        file.appendContent("Version 2");
        /*
        Expected Output
        ===============
        Version: 2 Tag: <no tag>
        Contents: Hello, World.Version 1.Version 2
         */
        Utils.printVersionedFile(file);

        // Replace the file contents. But don't change the version.
        file.setContent("We've reset the content, but this is still version 2");
        /*
        Expected Output
        ===============
        Version: 2 Tag: <no tag>
        Contents: We've reset the content, but this is still version 2
         */
        Utils.printVersionedFile(file);

        // save the file. bump up the version.
        file.saveVersion("saved");
        /*
        Expected Output
        ===============
        Version: 3 Tag: saved
        Contents: We've reset the content, but this is still version 2
        */
        Utils.printVersionedFile(file);

        // replace the contents of the file.
        file.setContent("Now, we've saved the previous version, and are editing version 3");
        /*
        Expected Output
        ===============
        Version: 3 Tag: saved
        Contents: Now, we've saved the previous version, and are editing version 3
        */
        Utils.printVersionedFile(file);

        System.out.println();
        /*
        The following statement, prints the previous version of the file. i.e. The last contents of the file
        at the time of version 2, will be printed.
        Expected Output
        ===============
        We've reset the content, but this is still version 2
         */
        System.out.println(file.getPreviousVersion());

        // bump of the file version.
        file.saveVersion();
        /*
        Expected Output
        ===============
        Version: 4 Tag: <no tag>
        Contents: Now, we've saved the previous version, and are editing version 3
         */
        Utils.printVersionedFile(file);

        // replace the contents of the file.
        file.setContent("This is now version 4");
        /*
        Expected Output
        ===============
        Version: 4 Tag: <no tag>
        Contents: This is now version 4
         */
        Utils.printVersionedFile(file);

        // revert the file back to version 3
        file.revertToPreviousVersion();
        /*
        Expected Output
        ===============
        Version: 3 Tag: saved
        Contents: Now, we've saved the previous version, and are editing version 3
         */
        Utils.printVersionedFile(file);

        // Replace the contents of the file (in version 3)
        file.setContent("Saving some new content to version 3");
        /*
        Expected Output
        ===============
        Version: 3 Tag: saved
        Contents: Saving some new content to version 3
         */
        Utils.printVersionedFile(file);

        // save the version, as a "new Version 4" which is different from out previous
        // version 4 that had been reverted.
        file.saveVersion("New Version 4");
        /*
        Expected Output
        ===============
        Version: 4 Tag: New Version 4
        Contents: Saving some new content to version 3
         */
        Utils.printVersionedFile(file);

        // revert back to version 2, that is make 2 hops when reverting.
        file.revertToFormerVersion(2);
        /*
        Expected Output
        ===============
        Version: 2 Tag: <no tag>
        Contents: We've reset the content, but this is still version 2
         */
        Utils.printVersionedFile(file);

    }

}
