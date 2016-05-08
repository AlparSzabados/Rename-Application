package rename

class RenameProgram {

    static newName(List fileName, int newCounter, String fromExtension, String toExtension, Boolean shouldDeleteSuffix) {
        List newFileName = []
        for (String file in fileName) {
            def matcher = (file =~ /(?i)^(\d+)([a-z]?)\.${fromExtension}$/)[0]
            def (_, String counter, String part) = matcher

            if (!part || part.equalsIgnoreCase('a'))
                newCounter++

            def newCounterPad = "${newCounter}".padLeft(counter.size(), '0')

            if (shouldDeleteSuffix)
                part = ''

            newFileName += "${newCounterPad}${part}.${toExtension}"
        }
        newFileName
    }
}