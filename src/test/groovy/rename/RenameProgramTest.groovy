package rename

import spock.lang.Specification

class RenameProgramTest extends Specification {
    /*@formatter:off*/
    def 'rename application'() {
        when:   def renameFile = RenameProgram.newName(fileNameList, counter, fromExtension, toExtension, shouldDeleteSuffix)
        then:   renameFile == expectedResult

        where:  fileNameList                                           | counter | fromExtension | toExtension | shouldDeleteSuffix || expectedResult
                ['01.pag']                                             | 0       | 'pag'         | 'pag'       | false              || ['01.pag']
                ['01a.pag', '01b.pag', '02.pag']                       | 1       | 'pag'         | 'pag'       | false              || ['02a.pag', '02b.pag', '03.pag']
                ['01.pag', '02.pag', '04.pag', '05a.pag', '05b.pag']   | 0       | 'pag'         | 'pag'       | false              || ['01.pag', '02.pag', '03.pag', '04a.pag', '04b.pag']
                ['01a.pag', '01b.pag', '02a.pag', '03a.pag']           | 0       | 'pag'         | 'mus'       | true               || ['01.mus', '01.mus', '02.mus', '03.mus']
                ['01a.pag', '02a.pag', '03a.pag']                      | 0       | 'pag'         | 'mus'       | true               || ['01.mus', '02.mus', '03.mus']
    }
    /*@formatter:on*/
}
