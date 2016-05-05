package rename

class UserInput {
    static readString(String text) {
        println text
        System.in.newReader().readLine()
    }

    static readNumber(String text) {
        def input = readString(text)
        input.toInteger()
    }
}