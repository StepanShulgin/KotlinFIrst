import java.net.URL
import java.net.URLEncoder
import com.google.gson.Gson
import dataBank.ApiRequest
import dataBank.Search
import java.awt.Desktop
import java.net.URI


class WikiListCreator(inputRequest:String) {

    private val request:String=inputRequest
    private var answer:String=""
    private var listOfTitles: List<Search> = listOf()

    private fun makeRequest(): URL {
        return URL("https://ru.wikipedia.org/w/api.php?action=query&list=search&utf8=&format=json&srsearch=${
            URLEncoder.encode(
                request,
                "UTF-8")}")
    }

    private fun getAnswer(){
        answer = makeRequest().readText()
    }

    private fun makeList(){
        getAnswer()
        listOfTitles = Gson().fromJson(answer,ApiRequest::class.java).query.search
    }

    private fun printList()
    {
        for(index in listOfTitles.indices)
        {
            println("Index: $index | Title: ${listOfTitles[index].title}")
        }
    }

    private fun getIndexOfTitle(){
        var index = readln().toInt()
        while(index < 0 || index > listOfTitles.size)
        {
            println("Incorrect index. Enter correct index: ")
            index = readln().toInt()
        }
        openArticle(index)
    }

    private fun openArticle(index: Int){
        Desktop.getDesktop().browse(URI("https://ru.wikipedia.org/w/index.php?curid=" +
                URLEncoder.encode(
                    listOfTitles[index].pageid.toString(),
                    "UTF-8")
        ))
    }
  fun getListOfTitles(){
      makeList()
      printList()
      getIndexOfTitle()
  }



}