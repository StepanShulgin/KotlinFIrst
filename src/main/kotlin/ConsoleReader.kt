class ConsoleReader {
    private var inputTitle: String=""

    fun getInputTitle():String{

        println("Enter your request;)")
        inputTitle = readln()
        while(inputTitle=="")
        {
            println("It shouldn't be empty!)")
            inputTitle = readln()
        }
        return inputTitle
    }
}