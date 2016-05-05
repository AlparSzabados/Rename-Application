package rename

class RootFolder {
    static File ROOT_FOLDER = 'C:/Rename' as File
    static File[] SORTED_FILES = ROOT_FOLDER.listFiles().sort()
}