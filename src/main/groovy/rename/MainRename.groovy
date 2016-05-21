package rename

import static rename.RenameProgram.newName
import static rename.RootFolder.fileNameAsList
import static rename.RootFolder.SORTED_FILES
import static rename.UserInput.readNumber
import static rename.UserInput.readString

class MainRename {
    static void main(String... args) {
        def newCounter = readNumber('Start with number:') - 1
        def fromExtension = readString('From extension:')
        def toExtension = readString('To extension:')
        def shouldDeleteSuffix = readString('Delete suffix (y / n) (Only used for special cases):').trim().toUpperCase() == "Y"

        def newFile = newName(fileNameAsList(), newCounter, fromExtension, toExtension, shouldDeleteSuffix)

        // TODO make it less confusig
        for (file in 0..(SORTED_FILES.size() - 1)) {
            println "Processing file: '${SORTED_FILES[file].name}"
            println "Renaming '${SORTED_FILES[file].name}' to '${newFile[file]}'"
            SORTED_FILES[file].renameTo("${SORTED_FILES[file].parent}/${newFile[file]}")
        }
    }
}