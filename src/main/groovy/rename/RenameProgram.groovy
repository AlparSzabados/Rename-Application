package rename

class RenameProgram {
    static int newCounter
    static String fromExtension
    static String toExtension
    static boolean shouldDeleteSuffix

    static newName(File file) {
        println "Processing input: ${file}"
        def matcher = (file.name =~ /(?i)^(\d+)([a-z]?)\.${fromExtension}$/)[0]
        def (_, String counter, String part) = matcher

        if (!part || part.equalsIgnoreCase('a'))
            newCounter++

        def newCounterPad = "${newCounter}".padLeft(counter.size(), '0')

        if (shouldDeleteSuffix)
            part = ''

        "${file.parent}/${newCounterPad}${part}.${toExtension}" as File
    }
}