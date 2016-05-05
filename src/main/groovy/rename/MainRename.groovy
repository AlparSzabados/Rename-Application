package rename

import static RootFolder.SORTED_FILES
import static rename.RenameProgram.*
import static rename.UserInput.readNumber
import static rename.UserInput.readString

class MainRename {
    static void main(String... args) {
        newCounter = readNumber('Start with number:') - 1
        fromExtension = readString('From extension:')
        toExtension = readString('To extension:')
        shouldDeleteSuffix = readString('Delete suffix (y / n) (Only used for special cases):').trim().toUpperCase() == "Y"

        for (file in SORTED_FILES) {
            def newFile = newName(file)
            println "Renaming '${file.name}' to '${newFile.name}'"
            file.renameTo(newFile)
        }
        readString('')
    }
}

